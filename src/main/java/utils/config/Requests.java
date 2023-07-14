package utils.config;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class Requests extends BasicEndpointConfiguration {
    private final String supplyDetailsPageEndpoint = "pl/i/Czas-realizacji-zamowienia-i-koszty-dostawy/4";
    private final String loginPageEndpoint = "pl/login";
    private final String mainPageEndpoint = "";

    public Response getLoginPage() {
        return lastResponse = get(loginPageEndpoint);
    }

    public Response getSupplyDetailsPage() {
        return lastResponse = get(supplyDetailsPageEndpoint);
    }

}
