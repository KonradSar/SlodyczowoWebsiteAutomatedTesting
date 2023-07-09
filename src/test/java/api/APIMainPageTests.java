package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.objects.MainPage;

import static io.restassured.RestAssured.given;

public class APIMainPageTests extends BaseAPITest {
    private static Logger logger = LogManager.getLogger(MainPage.class);

    @Test
    public void When_BaseURLIsLoaded_Expect_SlodyczowoMainPageIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getMainPageSource().getBaseURL());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Main page is successfully displayed");
        }
    }

    @Test
    public void When_YouClickOnJapanProducts_Expect_JapanProductsPAgeIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getJapanCandies().getJapansCandyCategoryUrl());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Japan products page is successfully displayed");
        }
    }

    @Test
    public void When_YouClickOnTajlandProducts_Expect_TajlandProductsPAgeIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getTajlandCandies().getTajlandsCandyCategoryUrl());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Tajland products page is successfully displayed");
        }
    }

    @Test
    public void When_YouClickOnDisplayBarsProductsAsAList_Expect_BarsAreDisplayedAsAList() {
        Response response = given()
                .when()
                .get(testDataReader.getBarsResults1stSite().getBars1stSiteResultsUrl());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Bars are displayed as a list properly");
        }
    }

    @Test
    public void When_YouClickOnDisplayJapanProductsAsDescendingPrice_Expect_JapanPrpductsAreDisplayedAsDescendingPrice() {
        Response response = given()
                .when()
                .get(testDataReader.getJapanCandiesDescendingPriceResults().getJapansCandy4thSiteResults());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Descending price filter for Japan products is successfully applied");
        }
    }

    @Test
    public void When_YouClickOnDisplaySecondPageOfBarProductsResults_Expect_SecondPageOfBarsResultsIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getBarsResults2ndSite().getBars2ndSiteResultsUrl());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
            logger.log(Level.INFO, "Second page of bar's products is displayed properly");
        }
    }

}
