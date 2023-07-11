package utils.cookie;

import com.codeborne.selenide.WebDriverRunner;
import lombok.SneakyThrows;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import test.data.TestData;

public class CookieHelper {

    @SneakyThrows
    public static void addCloseNewsletterCookie(TestData testData) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Cookie welcomePopup = new Cookie(testData.getCookie().getCookieName(), testData.getAttribute().getCookieAttribute());
        driver.manage().addCookie(welcomePopup);
        driver.navigate().refresh();
    }
}
