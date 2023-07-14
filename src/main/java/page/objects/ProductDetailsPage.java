package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.TestData;
import utils.element.ElementHelper;
import utils.url.CurrentUrlHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {
    SelenideElement addToCartBtnProductsDetail = $(By.cssSelector(".button_wrap button.addtobasket"));
    SelenideElement continueShoppingBtn = $(By.cssSelector(".modal-visible a.left"));
    SelenideElement incrementBtnProductsDetail = $(By.cssSelector("span.increment"));
    SelenideElement groceryMenuItem = $(By.id("headlink36"));
    SelenideElement saucesSubMenuCategory = $(By.id("hcategory_120"));
    SelenideElement productsImage = $(By.cssSelector("a[href='/Art-spozywcze/Sosy/Doritos-Salsa-Epicee-Dip-paprykowo-pomidorowy']"));
    SelenideElement productsDetailIncrementNumberOfProductsBtn = $(By.cssSelector("span.increment"));

    protected WebDriver driver;

    public void addProductToCart() {
        incrementBtnProductsDetail.click();
        addToCartBtnProductsDetail.click();
        continueShoppingBtn.shouldBe(visible);
        continueShoppingBtn.click();
    }

    public void goToSalsaDipDetails() {
        ElementHelper.moveToElement(groceryMenuItem);
        ElementHelper.moveToElementAndClick(saucesSubMenuCategory);
        productsImage.click();
        productsDetailIncrementNumberOfProductsBtn.click();
    }

    public boolean isProductDetailsDisplayed(TestData testData) {
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getSalsaDipDetails().getSalsaDipDetailsUrl());
    }
}
