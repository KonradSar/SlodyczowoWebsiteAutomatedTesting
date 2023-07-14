package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APIProductOfferPageTests extends BaseAPITest {

    private static Logger logger = LogManager.getLogger(APINavigationPageTests.class);

    @Test
    public void When_YouClickOnDisplayJapanProductsAsDescendingPrice_Expect_JapanPrpductsAreDisplayedAsDescendingPrice() {
        // When
        Response response = given()
                .when()
                .get(testData.getJapanCandiesDescendingPriceResults().getJapansCandy4thSiteResults());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Descending price filter for Japan products is successfully applied");
        }
    }
    @Test
    public void When_YouClickOnDisplayBarsProductsAsAList_Expect_BarsAreDisplayedAsAList() {
        // When
        Response response = given()
                .when()
                .get(testData.getBarsResults1stSite().getBars1stSiteResultsUrl());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Bars are displayed as a list properly");
        }
    }
}
