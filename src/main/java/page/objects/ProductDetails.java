package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetails {
    SelenideElement addToCartBtnProductsDetail = $(By.cssSelector(".button_wrap button.addtobasket"));
    SelenideElement continueShoppingBtn = $(By.cssSelector(".modal-visible a.left"));
    SelenideElement incrementBtnProductsDetail = $(By.cssSelector("span.increment"));

    protected WebDriver driver;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        incrementBtnProductsDetail.click();
        addToCartBtnProductsDetail.click();
        continueShoppingBtn.shouldBe(visible);
        continueShoppingBtn.click();
    }
}
