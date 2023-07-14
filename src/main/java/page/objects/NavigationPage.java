package page.objects;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import test.data.TestData;
import utils.element.ElementHelper;
import utils.url.CurrentUrlHelper;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {
    SelenideElement countrysMenuItem = $(By.cssSelector("a#headlink9"));
    SelenideElement asiaProductsLabel = $(By.cssSelector("a#headercategory19"));
    SelenideElement tajlandProductsLabel = $(By.cssSelector("#hcategory_19 a#headercategory168"));
    SelenideElement japanProductsLabel = $(By.cssSelector("a#headercategory18"));
    SelenideElement displayedProductsNameLabel = $(By.cssSelector("#box_mainproducts .category-name"));
    private static Logger logger = LogManager.getLogger(NavigationPage.class);

    public void displayJapanProducts() {
        ElementHelper.moveToElement(countrysMenuItem);
        japanProductsLabel.click();
        logger.info("The name of displayed current section is:" + displayedProductsNameLabel.getText());
    }

    public void displayTajlandProducts() {
        ElementHelper.moveToElement(countrysMenuItem);
        ElementHelper.moveToElement(asiaProductsLabel);
        tajlandProductsLabel.click();
    }

    @SneakyThrows
    public boolean areJapanProductsDisplayed(TestData testData) {
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getJapanCandies().getJapansCandyCategoryUrl());
    }

    @SneakyThrows
    public boolean areTajlandProductsDisplayed(TestData testData) {
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getTajlandCandies().getTajlandsCandyCategoryUrl());
    }
}
