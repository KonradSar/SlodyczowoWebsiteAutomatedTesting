package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.config.Requests;

public class APILogingPageTests extends BaseAPITest {

    private static Logger logger = LogManager.getLogger(APILogingPageTests.class);

    @Test
    public void When_LoginIconIsClicked_Expect_LoginPageIsDisplayed() {
        // When
        Requests requests = new Requests();

        // Then
        Assertions.assertEquals(200, requests.getLoginPage().statusCode());
    }
}
