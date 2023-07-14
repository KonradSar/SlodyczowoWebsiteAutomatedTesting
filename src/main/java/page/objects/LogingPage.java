package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class LogingPage {

    SelenideElement checkboxCaptcha = $(By.cssSelector("span.recaptcha-checkbox"));
    SelenideElement loginBtn2 = $(By.cssSelector("button.login"));
    SelenideElement captchaPopupAcceptBtn = $(By.cssSelector("div[class='modal modal-alert modal-visible'] .btn"));
    SelenideElement pickUpPicturesDialogAgainstRobots = $(By.xpath(".//iframe[contains(@title, 'Test reCAPTCHA')]"));
    private static Logger logger = LogManager.getLogger(LogingPage.class);

    protected WebDriver driver;

    public void fillInCredentialsForm() {
        $(By.cssSelector("input[type='text'][name='mail']")).setValue("konradsar2015@gmail.com");
        $(By.cssSelector("input[type='password'][name='pass']")).setValue("Slodycze90");
        switchTo().frame(1);
        actions().moveToElement(checkboxCaptcha).click().build().perform();
        switchTo().defaultContent();
        actions().moveToElement(loginBtn2).click().build().perform();
        if (pickUpPicturesDialogAgainstRobots.is(Condition.visible)) {
            logger.error("The captcha picture picker was displayed and interrupted actions");
        } else {
            captchaPopupAcceptBtn.click();
            actions().moveToElement(loginBtn2).click().build().perform();
        }
    }
}
