package page.objects;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.data.TestData;
import utils.element.ElementHelper;
import utils.url.CurrentUrlHelper;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductOfferPage extends NavigationPage {
    SelenideElement filterCategories = $(By.cssSelector("select.gotourl"));
    SelenideElement candysMenuItem = $(By.cssSelector("a#headlink39"));
    SelenideElement barsSubMenuCategory = $(By.cssSelector("#hcategory_2 a"));
    SelenideElement displayListOfProductsIconSwitchedOff = $(By.cssSelector("li.full a"));
    SelenideElement displayListOfProductsIconSwitchedOn = $(By.cssSelector("li[class='full selected']"));
    SelenideElement goToSecondProductListIcon = $(By.cssSelector(".innerbox div.floatcenterwrap .last a"));

    private static Logger logger = LogManager.getLogger(ProductOfferPage.class);

    public void selectDescendingPriceFilterForJapanProducts() {
        displayJapanProducts();
        Select categoriesDropdown = new Select(filterCategories);
        categoriesDropdown.selectByVisibleText("Od najwyższej ceny");
        List<WebElement> selectedOptionsFromDropDownMenu = categoriesDropdown.getAllSelectedOptions();
        logger.info("There were selected the number of options: " + selectedOptionsFromDropDownMenu.size() + " from dropDown menu");
    }

    @SneakyThrows
    public boolean isDescendingPriceFilterOn(TestData testData) {
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getJapanCandiesDescendingPriceResults().getJapansCandy4thSiteResults());
    }

    public void selectListOfProductsFilterActive() {
        ElementHelper.moveToElement(candysMenuItem);
        ElementHelper.moveToElementAndClick(barsSubMenuCategory);
        ElementHelper.moveToElementAndClick(displayListOfProductsIconSwitchedOff);
        displayListOfProductsIconSwitchedOn.shouldBe(visible);
    }

    public boolean isFullListOfProductsDisplayed(TestData testData) {
        if (!displayListOfProductsIconSwitchedOn.is(visible)) {
            logger.error("The icon for displaying products as a list is not active");
        }
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getBarsResults1stSite().getBars1stSiteResultsUrl());
    }

    public boolean isSecondListOfBarsDisplayed(TestData testData) {
        if (!goToSecondProductListIcon.is(visible)) {
            logger.error("Icon named: Go to product's second resuts page is not displayed");
        }
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getBarsResults2ndSite().getBars2ndSiteResultsUrl());
    }
}
