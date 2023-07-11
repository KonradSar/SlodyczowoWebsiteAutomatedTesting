package page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import condition.LocationCondition;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.data.TestData;
import utils.cookie.CookieHelper;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage extends BasePage {

    private final static String EMAIL_INPUT = ".one-step_address div:nth-child(3) input[name='e-mail']";
    private final static String NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Imię']";
    private final static String SURNAME_INPUT = ".one-step_address div:nth-child(3) input[name='Nazwisko']";
    private final static String STREET_NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Ulica i numer']";
    private final static String POSTAL_CODE_INPUT = ".one-step_address div:nth-child(3) input[name='Kod pocztowy']";
    private final static String CITY_NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Miasto']";
    SelenideElement drinksMenuItem = $(By.id("headlink35"));
    SelenideElement candysMenuItem = $(By.cssSelector("a#headlink39"));
    SelenideElement barsSubMenuCategory = $(By.cssSelector("#hcategory_2 a"));
    SelenideElement paginationElementsContainer = $(By.cssSelector(".innerbox div.floatcenterwrap"));
    SelenideElement goToSecondProductListIcon = $(By.cssSelector(".innerbox div.floatcenterwrap .last a"));
    SelenideElement goToThirdProductListIcon = $(By.cssSelector(".innerbox div.floatcenterwrap li:nth-child(6) a"));
    SelenideElement saucesSubMenuCategory = $(By.id("hcategory_120"));
    SelenideElement groceryMenuItem = $(By.id("headlink36"));
    SelenideElement fizzyDrinksSubMenuCategory = $(By.id("headercategory104"));
    SelenideElement saltySnacksMenuItem = $(By.cssSelector("a#headlink34"));
    SelenideElement crackersSubMenuCategory = $(By.cssSelector("#hcategory_82 a"));
    SelenideElement productLabelinformationIcon = $(By.cssSelector("a[data-id='2992']"));
    SelenideElement informationModal = $(By.cssSelector("div.modal-visible"));
    SelenideElement displayListOfProductsIconSwitchedOn = $(By.cssSelector("li[class='full selected']"));
    SelenideElement displayListOfProductsIconSwitchedOff = $(By.cssSelector("li.full a"));
    SelenideElement buyMeInformationModalButton = $(By.cssSelector("div.modal-visible button.btn-red"));
    SelenideElement successAlert = $(By.cssSelector("div.alert-success"));
    SelenideElement closeButtonSuccessAlert = $(By.cssSelector("div.alert-success button.close"));
    SelenideElement notFoundAnyElementsAlert = $(By.cssSelector("div.alert-info"));
    SelenideElement cocaColaTitleLabel = $(By.cssSelector("a[href='/Coca-Cola-Cherry-Vanilla-USA']"));
    SelenideElement plusBtnProductLabelDetails = $(By.cssSelector("div[data-product-id='1135'] span.plus"));
    SelenideElement buyMeProductDetails = $(By.cssSelector("div[data-product-id=\"1135\"] .buttons .addtobasket"));
    SelenideElement continueShoppingConfirmationModalBtn = $(By.cssSelector(".modal-visible a.left"));
    SelenideElement cartsCounterLabel = $(By.cssSelector(".countlabel .count>span"));
    SelenideElement dhlRadioBtn = $(By.cssSelector(".el-radio-group .shipping_22 .el-radio__input"));
    SelenideElement selectYourBankBtn = $(By.cssSelector(".selectYourBank>button"));
    SelenideElement millenniumBankLabel = $(By.cssSelector("img[src='https://platnosci.bm.pl/pomoc/grafika/1807.png']"));
    SelenideElement checkboxAcceptRegulations = $(By.id("additional_field_2"));
    SelenideElement placeAnOrderBtn = $(By.cssSelector(".el-button--success"));
    SelenideElement telephoneInputText = $(By.cssSelector(".one-step_address div:nth-child(3) input[name='Telefon']"));
    SelenideElement informMeAboutProductAvailabilityBtn = $(By.cssSelector(".availability-notifier-btn"));
    SelenideElement informMeAboutProductAvailabilityModal = $(By.cssSelector("div[class='modal modal-visible']"));
    SelenideElement productsImage = $(By.cssSelector("a[href='/Art-spozywcze/Sosy/Doritos-Salsa-Epicee-Dip-paprykowo-pomidorowy']"));
    SelenideElement productsDetailIncrementNumberOfProductsBtn = $(By.cssSelector("span.increment"));
    SelenideElement displayedProductsNameLabel = $(By.cssSelector("#box_mainproducts .category-name"));
    SelenideElement countrysMenuItem = $(By.cssSelector("a#headlink9"));
    SelenideElement japanProductsLabel = $(By.cssSelector("a#headercategory18"));
    SelenideElement filterCategories = $(By.cssSelector("select.gotourl"));
    SelenideElement availabilityModalTextInput = $(By.cssSelector("form.availability_notify_form input"));
    SelenideElement signUpMeProductAvailabilityModalBtn = $(By.cssSelector("form.availability_notify_form .btn"));
    SelenideElement shopInformationModal = $(By.cssSelector("div.modal-alert"));
    SelenideElement shopInformationModalOKBtn = $(By.cssSelector("div.modal-alert .btn"));
    SelenideElement asiaProductsLabel = $(By.cssSelector("a#headercategory19"));
    SelenideElement tajlandProductsLabel = $(By.cssSelector("#hcategory_19 a#headercategory168"));
    SelenideElement arrowUp = $(By.cssSelector("div.up"));
    static final String charRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    protected WebDriver driver;

    protected CookieHelper cookieHelper;

    private static Logger logger = LogManager.getLogger(MainPage.class);

    public void selectDescendingPriceFilterForJapanProducts() {
        displayJapanProducts();
        Select categoriesDropdown = new Select(filterCategories);
        categoriesDropdown.selectByIndex(4);
        List<WebElement> selectedOptionsFromDropDownMenu = categoriesDropdown.getAllSelectedOptions();
        assertEquals(1, selectedOptionsFromDropDownMenu.size());
    }

    @SneakyThrows
    public boolean isDescendingPriceFilterOn(TestData testData) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getJapanCandiesDescendingPriceResults().getJapansCandy4thSiteResults());
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findElement(String locator) {
        $(By.cssSelector(locator)).shouldBe(visible);
    }

    public void selectDeliveryWay() {
        actions().scrollToElement(dhlRadioBtn).moveToElement(dhlRadioBtn).click().build().perform();
    }

    public String generateRandomString(int lenght) {
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            sb.append(charRange.charAt(rnd.nextInt(charRange.length())));
        return sb.toString();
    }

    public void fillInAndConfirmAvailabilityModal() {
        if (informMeAboutProductAvailabilityBtn.is(visible)) {
            informMeAboutProductAvailabilityBtn.shouldBe(visible).click();
            informMeAboutProductAvailabilityModal.shouldBe(visible);
            availabilityModalTextInput.sendKeys(generateRandomString(8) + "@gmail.com");
            signUpMeProductAvailabilityModalBtn.click();
            shopInformationModal.shouldBe(visible);
            shopInformationModalOKBtn.click();
        } else {
            if (goToSecondProductListIcon.is(visible)) {
                goToSecondPaginationPageForAnyProduct();
                if (informMeAboutProductAvailabilityBtn.is(visible)) {
                    informMeAboutProductAvailabilityBtn.shouldBe(visible).click();
                    informMeAboutProductAvailabilityModal.shouldBe(visible);
                    availabilityModalTextInput.sendKeys(generateRandomString(8) + "@gmail.com");
                    signUpMeProductAvailabilityModalBtn.click();
                    shopInformationModal.shouldBe(visible);
                    shopInformationModalOKBtn.click();
                } else {
                    if (goToThirdProductListIcon.is(visible)) {
                        goToThirdPaginationPageForAnyProduct();
                        informMeAboutProductAvailabilityBtn.shouldBe(visible).click();
                        informMeAboutProductAvailabilityModal.shouldBe(visible);
                        availabilityModalTextInput.sendKeys(generateRandomString(8) + "@gmail.com");
                        signUpMeProductAvailabilityModalBtn.click();
                        shopInformationModal.shouldBe(visible);
                        shopInformationModalOKBtn.click();
                    }
                }
            }
        }

    }


    public boolean isOkBtnForShopInformationModalVisible() {
        if (!shopInformationModalOKBtn.is(visible)) {
            logger.error("Confirmation OK button for Information Modal is not displayed");
        }
        return shopInformationModalOKBtn.is(visible);
    }

    public void selectListOfProductsFilterActive() {
        actions().moveToElement(candysMenuItem).build().perform();
        actions().moveToElement(barsSubMenuCategory).click().build().perform();
        actions().moveToElement(displayListOfProductsIconSwitchedOff).click().build().perform();
        displayListOfProductsIconSwitchedOn.shouldBe(visible);
    }

    @SneakyThrows
    public boolean isFullListOfProductsDisplayed(TestData testData) {
        if (!displayListOfProductsIconSwitchedOn.is(visible)) {
            logger.error("The icon for displaying products as a list is not active");
        }
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getBarsResults1stSite().getBars1stSiteResultsUrl());
    }

    public void displayJapanProducts() {
        actions().moveToElement(countrysMenuItem).build().perform();
        japanProductsLabel.click();
        assertEquals("JAPONIA", displayedProductsNameLabel.getText());
    }

    public void clickOnArrowUpFab() {
        arrowUp.click();
    }

    public boolean isArrowUpHidden() {
        arrowUp.shouldHave(LocationCondition.locationY(609));
        return arrowUp.has(Condition.attribute("Style", "bottom: -38px;"));
    }

    public void displayTajlandProducts() {
        actions().moveToElement(countrysMenuItem).build().perform();
        actions().moveToElement(asiaProductsLabel).build().perform();
        tajlandProductsLabel.click();
    }

    @SneakyThrows
    public boolean areJapanProductsDisplayed(TestData testData) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getJapanCandies().getJapansCandyCategoryUrl());
    }

    @SneakyThrows
    public boolean areTajlandProductsDisplayed(TestData testData) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getTajlandCandies().getTajlandsCandyCategoryUrl());
    }

    public void goToSecondListOfBarsUsingPaginationBar() {
        actions().moveToElement(candysMenuItem).build().perform();
        actions().moveToElement(barsSubMenuCategory).click().build().perform();
        actions().moveToElement(paginationElementsContainer).build().perform();
        goToSecondProductListIcon.shouldBe(visible).click();
    }

    public void goToSecondPaginationPageForAnyProduct() {
        actions().moveToElement(paginationElementsContainer).build().perform();
        goToSecondProductListIcon.click();
    }

    public void goToThirdPaginationPageForAnyProduct() {
        actions().moveToElement(paginationElementsContainer).build().perform();
        goToThirdProductListIcon.click();
    }

    public void openPage() {
        open("https://slodyczowo.pl/");
        getWebDriver().manage().window().maximize();
    }

    public void acceptConsent() {
        $(By.className("js__accept-all-consents")).click();
    }

    @SneakyThrows
    public boolean isSecondListOfBarsDisplayed(TestData testData) {
        if (!goToSecondProductListIcon.is(visible)) {
            logger.error("'Icon: '+'Go to product's second resuts page'+'is not displayed'");
        }
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getBarsResults2ndSite().getBars2ndSiteResultsUrl());
    }

    public void goToSalsaDipDetails() {
        actions().moveToElement(groceryMenuItem).build().perform();
        actions().moveToElement(saucesSubMenuCategory).click().build().perform();
        productsImage.click();
        productsDetailIncrementNumberOfProductsBtn.click();
    }

    public boolean isProductDetailsDisplayed(TestData testData) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getSalsaDipDetails().getSalsaDipDetailsUrl());
    }

    public boolean isNoSearchResultsAlertDisplayed() {
        if (!notFoundAnyElementsAlert.is(visible)) {
            logger.error("The information about no results found is not displayed");
        }
        return notFoundAnyElementsAlert.is(visible);
    }

    public void acceptRegulations() {
        org.openqa.selenium.WebDriver driver = getWebDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                checkboxAcceptRegulations, "class", "el-checkbox__input is-checked");
    }

    @SneakyThrows
    public boolean isPlaceAnOrderPageDisplayed(TestData testData) {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(testData.getBasket()
                .getBasketSiteUrl());
    }

    public void addToCartKFlaminHot43g() {
        actions().moveToElement(saltySnacksMenuItem).build().perform();
        actions().moveToElement(crackersSubMenuCategory).click().build().perform();
        actions().moveToElement(productLabelinformationIcon).click().build().perform();
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

    public void selectPaymentMethod() {
        org.openqa.selenium.WebDriver driver = getWebDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", selectYourBankBtn);
        millenniumBankLabel.shouldBe(visible);
        actions().moveToElement(millenniumBankLabel).click().build().perform();
    }

    public void addTwoCocaColaToCart() {
        actions().moveToElement(drinksMenuItem).build().perform();
        actions().moveToElement(fizzyDrinksSubMenuCategory).click().build().perform();
        findElement("a[href='/Coca-Cola-Cherry-Vanilla-USA']");
        actions().moveToElement(cocaColaTitleLabel).build().perform();
        actions().moveToElement(plusBtnProductLabelDetails).click().build().perform();
        actions().moveToElement(buyMeProductDetails).click().build().perform();
        continueShoppingConfirmationModalBtn.shouldBe(visible);
        actions().moveToElement(continueShoppingConfirmationModalBtn).click().build().perform();
        String cartCounter = String.valueOf(2);
        assertEquals(cartsCounterLabel.getText(), cartCounter);
    }

    @SneakyThrows
    public void fillInClientsInformationForm(TestData testData) {
        telephoneInputText.setValue(testData.getPhone().getUserContactNumber());
        actions().scrollToElement(telephoneInputText).moveToElement(telephoneInputText).click().build().perform();
        $(By.cssSelector(EMAIL_INPUT)).setValue(testData.getEmail().getUserEmailAddress());
        $(By.cssSelector(NAME_INPUT)).setValue(testData.getName().getUserName());
        $(By.cssSelector(SURNAME_INPUT)).setValue(testData.getSurname().getUserSurname());
        $(By.cssSelector(STREET_NAME_INPUT)).setValue(testData.getStreet().getStreetName());
        $(By.cssSelector(POSTAL_CODE_INPUT)).setValue(testData.getPostalCode().getPostaLCode());
        $(By.cssSelector(CITY_NAME_INPUT)).setValue(testData.getCity().getCityName());
    }
}