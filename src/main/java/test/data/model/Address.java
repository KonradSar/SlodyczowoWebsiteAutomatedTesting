package test.data.model;

import java.util.Properties;

public class Address {
    private final String cityName;
    private final String postaLCode;
    private final String streetName;

    public Address(Properties properties) {
        cityName = properties.getProperty("address.city");
        postaLCode = properties.getProperty("address.postal");
        streetName = properties.getProperty("address.street");
    }

    public String getCityName() {
        return cityName;
    }

    public String getPostaLCode() {
        return postaLCode;
    }

    public String getStreetName() {
        return streetName;
    }
}
