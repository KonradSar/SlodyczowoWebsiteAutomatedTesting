package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.config.Requests;

public class APIHeaderTests extends BaseAPITest {

    private static Logger logger = LogManager.getLogger(APIHeaderTests.class);

    @Test
    public void When_SupplyIconIsClicked_Expect_SupplyDetailPageIsDisplayed() {
        // When
        Requests requests = new Requests();

        // Then
        Assertions.assertEquals(200, requests.getSupplyDetailsPage().statusCode());
    }
}
