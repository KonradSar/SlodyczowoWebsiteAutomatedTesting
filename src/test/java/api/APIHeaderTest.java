package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.config.Requests;

public class APIHeaderTest extends BaseAPITest {

    @Test
    public void When_SupplyIconIsClicked_Expect_SupplyDetailPageIsDisplayed() {
        // When
        Requests requests = new Requests();

        // Then
        Assertions.assertEquals(200, requests.getSupplyDetailsPage().statusCode());
    }
}
