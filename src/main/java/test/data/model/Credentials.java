package test.data.model;

import java.util.Properties;

public class Credentials {
    protected final String eMailAddress;
    protected final String password;

    public Credentials(Properties properties) {
        eMailAddress = properties.getProperty("credentials.eMailAddress");
        password = properties.getProperty("credentials.password");
    }

    public String getPassword() {
        return password;
    }
}
