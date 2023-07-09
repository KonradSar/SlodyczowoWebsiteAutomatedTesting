package page.objects;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import test.data.TestDataReader;
import test.data.model.Address;
import test.data.model.Credentials;
import test.data.model.Url;
import test.data.model.User;
import utils.cookie.Cookie;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BasePage {
    protected static TestDataReader testDataReader;
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";
    protected WebDriver driver;

    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(TEST_DATA_LOCATION), StandardCharsets.UTF_8));
        testDataReader = new TestDataReader(new Cookie(properties), new Cookie(properties), new User(properties),
                new User(properties), new User(properties), new User(properties), new Address(properties),
                new Address(properties), new Address(properties), new Url(properties), new Url(properties),
                new Url(properties), new Url(properties), new Url(properties), new Url(properties), new Url(properties),
                new Url(properties), new Credentials(properties), new Credentials(properties));
    }
}
