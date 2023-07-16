package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.element.ElementHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PaginationPage extends NavigationPage {
    SelenideElement candysMenuItem = $(By.cssSelector("a#headlink39"));
    SelenideElement barsSubMenuCategory = $(By.cssSelector("#hcategory_2 a"));
    SelenideElement paginationElementsContainer = $(By.cssSelector(".innerbox div.floatcenterwrap"));
    SelenideElement goToSecondProductListIcon = $(By.cssSelector(".innerbox div.floatcenterwrap .last a"));
    SelenideElement goToThirdProductListIcon = $(By.xpath(".//div[@class='floatcenterwrap']/ul//a[@href='/Slodycze/Zelki-owocowe/3']"));

    public void goToSecondListOfBarsUsingPaginationBar() {
        ElementHelper.moveToElement(candysMenuItem);
        ElementHelper.moveToElementAndClick(barsSubMenuCategory);
        ElementHelper.moveToElement(paginationElementsContainer);
        goToSecondProductListIcon.shouldBe(visible).click();
    }

    public void goToSecondPaginationPageForAnyProduct() {
        ElementHelper.moveToElement(paginationElementsContainer);
        goToSecondProductListIcon.click();
    }

    public void goToThirdPaginationPageForAnyProduct() {
        ElementHelper.moveToElement(paginationElementsContainer);
        goToThirdProductListIcon.click();
    }
}
