package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APIPaginationPageTests extends BaseAPITest {

    private static Logger logger = LogManager.getLogger(APIPaginationPageTests.class);

    @Test
    public void When_YouClickOnDisplaySecondPageOfBarProductsResults_Expect_SecondPageOfBarsResultsIsDisplayed() {
        // When
        Response response = given()
                .when()
                .get(testData.getBarsResults2ndSite().getBars2ndSiteResultsUrl());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Second page of bar's products is displayed properly");
        }
    }
}
