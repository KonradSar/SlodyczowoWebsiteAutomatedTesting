package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.element.ElementHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement drinksMenuItem = $(By.id("headlink35"));
    SelenideElement fizzyDrinksSubMenuCategory = $(By.id("headercategory104"));
    SelenideElement cocaColaTitleLabel = $(By.cssSelector("a[href='/Coca-Cola-Cherry-Vanilla-USA']"));
    SelenideElement plusBtnProductLabelDetails = $(By.cssSelector("div[data-product-id='1135'] span.plus"));
    SelenideElement buyMeProductDetails = $(By.cssSelector("div[data-product-id=\"1135\"] .buttons .addtobasket"));
    SelenideElement continueShoppingConfirmationModalBtn = $(By.cssSelector(".modal-visible a.left"));
    SelenideElement cartsCounterLabel = $(By.cssSelector(".countlabel .count>span"));
    SelenideElement saltySnacksMenuItem = $(By.cssSelector("a#headlink34"));
    SelenideElement crackersSubMenuCategory = $(By.cssSelector("#hcategory_82 a"));
    SelenideElement productLabelinformationIcon = $(By.cssSelector("a[data-id='2992']"));
    SelenideElement informationModal = $(By.cssSelector("div.modal-visible"));
    SelenideElement buyMeInformationModalButton = $(By.cssSelector("div.modal-visible button.btn-red"));
    SelenideElement successAlert = $(By.cssSelector("div.alert-success"));
    SelenideElement closeButtonSuccessAlert = $(By.cssSelector("div.alert-success button.close"));
    private static Logger logger = LogManager.getLogger(CartPage.class);

    public void addKFlaminHot43gtoCart() {
        ElementHelper.moveToElement(saltySnacksMenuItem);
        ElementHelper.moveToElementAndClick(crackersSubMenuCategory);
        ElementHelper.moveToElementAndClick(productLabelinformationIcon);
        informationModal.shouldBe(visible);
        buyMeInformationModalButton.shouldBe(visible).click();
        if (successAlert.is(visible)) {
            closeButtonSuccessAlert.click();
        } else {
            logger.error("The Success Alert Modal has been not displayed. The product may not be available for now");
        }
    }

    public boolean isAddingKFlamingHot43gAccomplished() {
        return cartsCounterLabel.getText().equals(String.valueOf(1));
    }

    public void addTwoCocaColaToCart() {
        ElementHelper.moveToElement(drinksMenuItem);
        ElementHelper.moveToElementAndClick(fizzyDrinksSubMenuCategory);
        cocaColaTitleLabel.shouldBe(visible);
        ElementHelper.moveToElement(cocaColaTitleLabel);
        ElementHelper.moveToElementAndClick(plusBtnProductLabelDetails);
        ElementHelper.moveToElementAndClick(buyMeProductDetails);
        continueShoppingConfirmationModalBtn.shouldBe(visible);
        ElementHelper.moveToElementAndClick(continueShoppingConfirmationModalBtn);
    }
}
