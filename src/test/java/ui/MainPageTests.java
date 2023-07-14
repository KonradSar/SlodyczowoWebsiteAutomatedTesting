package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.*;
import utils.cookie.CookieHelper;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTests extends BaseTest {

    MainPage mainPage;
    Searcher searcher;
    LogingPage logingPage;
    Header header;
    Footer footer;
    ProductDetailsPage productDetails;
    RelatedProducts relatedProducts;
    BlogPage blogPage;
    CheckoutPage checkoutPage;
    NavigationPage navigationPage;
    PaginationPage paginationPage;
    ProductOfferPage productOfferPage;
    CartPage cartPage;

    @AfterEach
    public void quit() {
        closeWebDriver();
    }

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage();
        searcher = new Searcher();
        logingPage = new LogingPage();
        header = new Header();
        footer = new Footer();
        productDetails = new ProductDetailsPage();
        relatedProducts = new RelatedProducts();
        blogPage = new BlogPage();
        checkoutPage = new CheckoutPage();
        navigationPage = new NavigationPage();
        paginationPage = new PaginationPage();
        productOfferPage = new ProductOfferPage();
        cartPage = new CartPage();
        mainPage.openPage();
        mainPage.acceptConsent();
        CookieHelper.addCloseNewsletterCookie(testData);
    }

    @Test
    public void makeACocaColaOrderWithNoConfirm() {
        // Given
        cartPage.addTwoCocaColaToCart();
        header.goToShoppingCartView();
        checkoutPage.selectDeliveryWay();
        checkoutPage.selectPaymentMethod();
        checkoutPage.fillInClientsInformationForm(testData);

        // When
        checkoutPage.acceptRegulations();

        // Then
        assertTrue(header.isNumberOfProductsInCartUpdated());
        assertTrue(checkoutPage.isPlaceAnOrderPageDisplayed(testData));
    }

    @Test
    public void addToCartCrackersUsingInformationModal() {
        //When
        cartPage.addKFlaminHot43gtoCart();

        //Then
        assertTrue(cartPage.isAddingKFlamingHot43gAccomplished());
    }

    @Test
    public void displayProductsAsAList() {
        //When
        productOfferPage.selectListOfProductsFilterActive();

        //Then
        assertTrue(productOfferPage.isFullListOfProductsDisplayed(testData));
    }

    @Test
    public void displaySecondSideOfSearchResults() {
        //When
        paginationPage.goToSecondListOfBarsUsingPaginationBar();

        //Then
        assertTrue(productOfferPage.isSecondListOfBarsDisplayed(testData));
    }

    @Test
    public void displayDescendingPriceProducts() {
        //When
        productOfferPage.selectDescendingPriceFilterForJapanProducts();

        //Then
        assertTrue(productOfferPage.isDescendingPriceFilterOn(testData));
    }

    @Test
    public void displayJapanProducts() {
        //When
        navigationPage.displayJapanProducts();

        //Then
        assertTrue(navigationPage.areJapanProductsDisplayed(testData));
    }

    @Test
    public void displayTajlandProducts() {
        //When
        navigationPage.displayTajlandProducts();

        //Then
        assertTrue(navigationPage.areTajlandProductsDisplayed(testData));
    }

    @Test
    public void scrollToWebPageTop() {

        //When
        footer.moveToBlogIcon();
        mainPage.clickOnArrowUpFab();

        //Then
        assertTrue(mainPage.isArrowUpHidden());
    }

    @Test
    public void signUpForProductAvailabilityAlert() {
        // When
        searcher.searchFruitJellyFromDropDown();
        mainPage.turnOnAvailabilityNotifications();

        // Then
        assertTrue(mainPage.isOkBtnForShopInformationModalVisible());
    }

//    @Test
//    public void logIntoAccount() {
//        // When
//        header.goToLogingPage();
//
//        // Then
//        logingPage.fillInCredentialsForm();
//    }

    @Test
    public void openBubbleTeaRecipeBlog() {
        // When
        footer.moveToBlogIcon();
        blogPage.openBubbleTeaBlog();

        // Then
        assertTrue(blogPage.isBlogPageDisplayed());
    }

    @Test
    public void addToCart3DoritosSalsaDipAnd1RelatedProduct() {
        // When
        productDetails.goToSalsaDipDetails();
        productDetails.addProductToCart();
        assertTrue(header.isCartCounterProper(3));
        assertTrue(productDetails.isProductDetailsDisplayed(testData));
        relatedProducts.addRelatedProductToCartAndContinueShopping();

        // Then
        assertTrue(header.isCartCounterProper(4));
    }
}
