package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APINavigationPageTests extends BaseAPITest {

    private static Logger logger = LogManager.getLogger(APINavigationPageTests.class);

    @Test
    public void When_YouClickOnJapanProducts_Expect_JapanProductsPAgeIsDisplayed() {
        // When
        Response response = given()
                .when()
                .get(testData.getJapanCandies().getJapansCandyCategoryUrl());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Japan products page is successfully displayed");
        }
    }

    @Test
    public void When_YouClickOnTajlandProducts_Expect_TajlandProductsPAgeIsDisplayed() {
        // When
        Response response = given()
                .when()
                .get(testData.getTajlandCandies().getTajlandsCandyCategoryUrl());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Tajland products page is successfully displayed");
        }
    }
}
