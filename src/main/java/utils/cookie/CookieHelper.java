package utils.cookie;

import com.codeborne.selenide.WebDriverRunner;
import lombok.SneakyThrows;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import page.objects.BasePage;

public class CookieHelper extends BasePage {

    protected WebDriver driver;

    public CookieHelper(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public static void loadCookies() {
        loadConfig();
        WebDriver driver = WebDriverRunner.getWebDriver();
        Cookie welcomePopup = new Cookie(testDataReader.getCookie().getCookieName(), testDataReader.getAttribute().getCookieAttribute());
        driver.manage().addCookie(welcomePopup);
        driver.navigate().refresh();
    }
}
