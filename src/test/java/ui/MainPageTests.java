package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.objects.*;
import utils.cookie.CookieHelper;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTests extends BaseTest {

    MainPage mainPage;
    Searcher searcher;
    LogingPage logingPage;
    Header header;
    Footer footer;
    ProductDetails productDetails;
    RelatedProducts relatedProducts;
    BlogPage blogPage;
    CookieHelper cookieHelper;

    @AfterEach
    public void quit() {
        closeWebDriver();
    }

    @Test
    public void findElement(String locator) {
        $(By.cssSelector(locator)).shouldBe(visible);
    }

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
        searcher = new Searcher(driver);
        logingPage = new LogingPage(driver);
        header = new Header(driver);
        footer = new Footer(driver);
        productDetails = new ProductDetails(driver);
        relatedProducts = new RelatedProducts(driver);
        blogPage = new BlogPage(driver);
        cookieHelper = new CookieHelper(driver);
    }

    @Test
    public void makeACocaColaOrderWithNoOrdering() {
        //Given
        mainPage.addTwoCocaColaToCart();
        header.goToShoppingCartView();
        mainPage.selectDeliveryWay();
        mainPage.selectPaymentMethod();
        mainPage.fillInClientsInformationForm();

        //When
        mainPage.acceptRegulations();

        //Then
        assertTrue(mainPage.isPlaceAnOrderPageDisplayed());
    }

    @Test
    public void addToCartCrackersUsingInformationModal() {
        //When
        mainPage.addToCartKFlaminHot43g();

        //Then
        assertTrue(mainPage.isAddingKFlamingHot43gAccomplished());
    }

    @Test
    public void displayProductsAsAList() {
        //When
        mainPage.selectListOfProductsFilterActive();

        //Then
        assertTrue(mainPage.isFullListOfProductsDisplayed());
    }

    @Test
    public void displaySecondSideOfSearchResults() {
        //When
        mainPage.goToSecondListOfBarsUsingPaginationBar();

        //Then
        assertTrue(mainPage.isSecondListOfBarsDisplayed());
    }

    @Test
    public void displayDescendingPriceProducts() {
        //When
        mainPage.selectDescendingPriceFilterForJapanProducts();

        //Then
        assertTrue(mainPage.isDescendingPriceFilterOn());
    }

    @Test
    public void displayJapanProducts() {
        //When
        mainPage.displayJapanProducts();

        //Then
        assertTrue(mainPage.areJapanProductsDisplayed());
    }

    @Test
    public void displayTajlandProducts() {
        //When
        mainPage.displayTajlandProducts();

        //Then
        assertTrue(mainPage.areTajlandProductsDisplayed());
    }

    @Test
    public void scrollToWebPageTop() {
        //Given
        mainPage.setUpOperations();
        cookieHelper.loadCookies();

        //When
        footer.moveToBlogIcon();
        mainPage.clickOnArrowUpFab();

        //Then
        assertTrue(mainPage.isArrowUpHidden());
    }

    @Test
    public void signUpForProductAvailabilityAlert() {
        //When
        searcher.searchFruitJellyFromDropDown();
        mainPage.fillInAndConfirmAvailabilityModal();

        //Then
        assertTrue(mainPage.isOkBtnForShopInformationModalVisible());
    }

    @Test
    public void logIntoAccount() {
        //Given
        mainPage.setUpOperations();
        cookieHelper.loadCookies();

        //When
        header.goToLogingPage();

        //Then
        logingPage.fillInCredentialsForm();
    }

    @Test
    public void openBubbleTeaRecipeBlog() {
        //Given
        mainPage.setUpOperations();
        cookieHelper.loadCookies();

        //When
        footer.moveToBlogIcon();
        blogPage.openBubbleTeaBlog();

        //Then
        assertTrue(blogPage.isBlogPageDisplayed());
    }

    @Test
    public void addToCart3DoritosSalsaDipAnd1RelatedProduct() {
        //Given
        mainPage.setUpOperations();
        cookieHelper.loadCookies();

        //When
        mainPage.goToSalsaDipDetails();
        productDetails.addProductToCart();
        assertTrue(header.isCartCounterProper(3));
        assertTrue(mainPage.isProductDetailsDisplayed());
        relatedProducts.addRelatedProductToCartAndContinueShopping();

        //Then
        assertTrue(header.isCartCounterProper(4));
    }
}
