package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Footer {
    SelenideElement blogIcon = $(By.xpath(".//li[@id='footgroup7']//a[@id='footlink24']"));

    protected WebDriver driver;

    public void moveToBlogIcon() {
        actions().moveToElement(blogIcon).build().perform();
    }
}
