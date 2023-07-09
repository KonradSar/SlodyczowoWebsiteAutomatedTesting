package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Footer {
    SelenideElement blogIcon = $(By.cssSelector("li[id='footgroup7'] li:nth-child(5)"));

    protected WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToBlogIcon() {
        actions().moveToElement(blogIcon).build().perform();
    }
}
