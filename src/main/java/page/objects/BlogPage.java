package page.objects;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class BlogPage {

    SelenideElement bubbleTeaImage = $(By.cssSelector("img[src='/userdata/public/news/images/24.jpg']"));
    private static Logger logger = LogManager.getLogger(BlogPage.class);

    protected WebDriver driver;

    public void openBubbleTeaBlog() {
        bubbleTeaImage.shouldBe(visible);
        actions().moveToElement(bubbleTeaImage).click().build().perform();
    }

    public boolean isBlogPageDisplayed() {
        logger.log(Level.INFO, "checking if current URL's loaded");
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals("https://slodyczowo.pl/Jak-zrobic-herbate-bubble-tea-z-kuleczkami-tapioki");
    }
}
