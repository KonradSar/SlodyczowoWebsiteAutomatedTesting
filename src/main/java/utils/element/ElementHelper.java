package utils.element;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ElementHelper {
    @SneakyThrows
    public static void moveToElement(SelenideElement selenideElement) {
        actions().moveToElement(selenideElement).build().perform();
    }

    @SneakyThrows
    public static void moveToElementAndClick(SelenideElement selenideElement) {
        actions().moveToElement(selenideElement).click().build().perform();
    }

    @SneakyThrows
    public static void scrollToElementAndClick(SelenideElement selenideElement) {
        actions().scrollToElement(selenideElement).moveToElement(selenideElement).click().build().perform();
    }

    @SneakyThrows
    public static void forceClickOnElement(SelenideElement selenideElement) {
        org.openqa.selenium.WebDriver driver = getWebDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selenideElement);
    }
}
