package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class RelatedProducts {

    protected WebDriver driver;

    public RelatedProducts(WebDriver driver) {
        this.driver = driver;
    }

    SelenideElement continueShoppingBtn = $(By.cssSelector(".modal-visible a.left"));

    public void addRelatedProductToCartAndContinueShopping() {
        SelenideElement relatedProducts = $(By.cssSelector("div#box_productrelated"));
        relatedProducts.shouldBe(visible);
        actions().moveToElement(relatedProducts).build().perform();
        SelenideElement addToCartBtnRelatedProducts = $(By.cssSelector("[data-product-id='2192'] button"));
        addToCartBtnRelatedProducts.click();
        continueShoppingBtn.shouldBe(visible);
        continueShoppingBtn.click();
    }
}
