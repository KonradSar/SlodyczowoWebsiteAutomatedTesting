package test.data.model;

import java.util.Properties;

public class Url {
    protected final String japansCandy4thSiteResults;
    protected final String bars1stSiteResultsUrl;
    protected final String bars2ndSiteResultsUrl;
    protected final String japansCandyCategoryUrl;
    protected final String tajlandsCandyCategoryUrl;
    protected final String salsaDipDetailsUrl;
    protected final String basketSiteUrl;
    protected final String baseURL;

    public Url(Properties properties) {
        japansCandy4thSiteResults = properties.getProperty("url.japansCandyResultsPage4th");
        bars1stSiteResultsUrl = properties.getProperty("url.barsResultsPage1st");
        bars2ndSiteResultsUrl = properties.getProperty("url.barsResultsPage2nd");
        japansCandyCategoryUrl = properties.getProperty("url.japansCandyMainCategory");
        tajlandsCandyCategoryUrl = properties.getProperty("url.tajlandCandyAndSnacksMainCategory");
        salsaDipDetailsUrl = properties.getProperty("url.salsaDipDetails");
        basketSiteUrl = properties.getProperty("url.basketsSite");
        baseURL = properties.getProperty("url.baseURL");
    }

    public String getJapansCandy4thSiteResults() {
        return japansCandy4thSiteResults;
    }

    public String getBars1stSiteResultsUrl() {
        return bars1stSiteResultsUrl;
    }

    public String getBars2ndSiteResultsUrl() {
        return bars2ndSiteResultsUrl;
    }

    public String getJapansCandyCategoryUrl() {
        return japansCandyCategoryUrl;
    }

    public String getTajlandsCandyCategoryUrl() {
        return tajlandsCandyCategoryUrl;
    }

    public String getSalsaDipDetailsUrl() {
        return salsaDipDetailsUrl;
    }

    public String getBasketSiteUrl() {
        return basketSiteUrl;
    }

    public String getBaseURL() {
        return baseURL;
    }
}
