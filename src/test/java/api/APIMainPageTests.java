package api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APIMainPageTests extends BaseAPITest {
    private static Logger logger = LogManager.getLogger(APIMainPageTests.class);

    @Test
    public void When_BaseURLIsLoaded_Expect_SlodyczowoMainPageIsDisplayed() {
        // When
        Response response = given()
                .when()
                .get(testData.getMainPageSource().getBaseURL());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Main page is successfully displayed");
        }
    }
}
