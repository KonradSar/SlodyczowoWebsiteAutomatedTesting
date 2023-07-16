package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import condition.LocationCondition;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage extends PaginationPage {
    SelenideElement goToSecondProductListIcon = $(By.cssSelector(".innerbox div.floatcenterwrap .last a"));
    SelenideElement goToThirdProductListIcon = $(By.xpath(".//div[@class='floatcenterwrap']/ul//a[@href='/Slodycze/Zelki-owocowe/3']"));
    SelenideElement notFoundAnyElementsAlert = $(By.cssSelector("div.alert-info"));
    SelenideElement informMeAboutProductAvailabilityBtn = $(By.cssSelector(".availability-notifier-btn"));
    SelenideElement informMeAboutProductAvailabilityModal = $(By.cssSelector("div[class='modal modal-visible']"));
    SelenideElement availabilityModalTextInput = $(By.cssSelector("form.availability_notify_form input"));
    SelenideElement signUpMeProductAvailabilityModalBtn = $(By.cssSelector("form.availability_notify_form .btn"));
    SelenideElement shopInformationModal = $(By.cssSelector("div.modal-alert"));
    SelenideElement shopInformationModalOKBtn = $(By.cssSelector("div.modal-alert .btn"));
    SelenideElement arrowUp = $(By.cssSelector("div.up"));
    private static Logger logger = LogManager.getLogger(MainPage.class);

    protected WebDriver driver;

    public void openPage() {
        open("https://slodyczowo.pl/");
        getWebDriver().manage().window().maximize();
    }

    public void acceptConsent() {
        $(By.className("js__accept-all-consents")).click();
    }

    public void clickOnArrowUpFab() {
        arrowUp.click();
    }

    public boolean isArrowUpHidden() {
        arrowUp.shouldHave(LocationCondition.locationY(609));
        return arrowUp.has(Condition.attribute("Style", "bottom: -38px;"));
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public boolean isOkBtnForShopInformationModalVisible() {
        if (!shopInformationModalOKBtn.is(visible)) {
            logger.error("Confirmation OK button for Information Modal is not displayed");
        }
        return shopInformationModalOKBtn.is(visible);
    }

    public void confirmAvailabilityModal() {
        informMeAboutProductAvailabilityBtn.shouldBe(visible).click();
        informMeAboutProductAvailabilityModal.shouldBe(visible);
        availabilityModalTextInput.sendKeys(generateRandomString(8) + "@gmail.com");
        signUpMeProductAvailabilityModalBtn.click();
        shopInformationModal.shouldBe(visible);
        shopInformationModalOKBtn.click();
    }

    public boolean isNoSearchResultsAlertDisplayed() {
        if (!notFoundAnyElementsAlert.is(visible)) {
            logger.error("The information about no results found is not displayed");
        }
        return notFoundAnyElementsAlert.is(visible);
    }

    public void turnOnAvailabilityNotifications() {
        if (informMeAboutProductAvailabilityBtn.is(visible)) {
            confirmAvailabilityModal();
        } else {
            if (goToSecondProductListIcon.is(visible)) {
                goToSecondPaginationPageForAnyProduct();
                if (informMeAboutProductAvailabilityBtn.is(visible)) {
                    confirmAvailabilityModal();
                } else {
                    if (goToThirdProductListIcon.is(visible)) {
                        goToThirdPaginationPageForAnyProduct();
                        confirmAvailabilityModal();
                    }
                }
            }
        }
    }
}