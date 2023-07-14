package utils.config;

import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

public abstract class BasicEndpointConfiguration {
    protected static String baseURL = "https://slodyczowo.pl/";
    protected Response lastResponse;
    public BasicEndpointConfiguration() {
        baseURI = baseURL;
    }
}
