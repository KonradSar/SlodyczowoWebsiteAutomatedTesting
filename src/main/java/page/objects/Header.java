package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Header {

    SelenideElement logInBtn = $(By.cssSelector("a[href='/pl/login'][title='Zaloguj się'][class='login']"));
    SelenideElement slodyczowoShopIcon = $(By.cssSelector("img[src='/skins/user/rwd_shoper_33/images/logo.svg']"));
    SelenideElement cartIcon = $(By.cssSelector("a[href='/pl/basket'][title='Koszyk'][class='count']"));
    SelenideElement spanValue = $(By.cssSelector(".countlabel .count>span"));

    protected WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void goToShoppingCartView() {
        actions().moveToElement(cartIcon).click().build().perform();
    }

    public void goToLogingPage() {
        actions().moveToElement(logInBtn).click().build().perform();
    }

    public boolean isCartCounterProper(int expectedValue) {
        spanValue.shouldBe(Condition.visible);
        return spanValue.getText().equals(String.valueOf(expectedValue));
    }

    public void clickOnShopMainIogo() {
        slodyczowoShopIcon.click();
    }
}
