package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.Header;
import page.objects.MainPage;
import page.objects.Searcher;
import utils.cookie.CookieHelper;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearcherTests extends BaseTest {
    private final static String PROPER_SEARCH_INPUT_VALUE = "ThePhraseForSearch";
    private final static String WRONG_SEARCH_INPUT_VALUE = "Bentley";
    MainPage mainPage;
    Searcher searcher;
    Header header;

    @AfterEach
    public void quit() {
        closeWebDriver();
    }

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage();
        searcher = new Searcher();
        header = new Header();
        mainPage.openPage();
        mainPage.acceptConsent();
        CookieHelper.addCloseNewsletterCookie(testData);
    }

    @Test
    public void displaySearchHistoryForSearcher() {
        searcher.findResultsForPhrase(PROPER_SEARCH_INPUT_VALUE);
        header.clickOnShopMainIogo();
        assertTrue(searcher.checkIfHistoryIsDisplayed());
    }

    @Test
    public void checkWhenTheresNoSearchFound() {
        searcher.findResultsForPhrase(WRONG_SEARCH_INPUT_VALUE);
        assertTrue(mainPage.isNoSearchResultsAlertDisplayed());
    }
}
