package ui;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import test.data.TestData;
import test.data.TestDataReader;

public class BaseTest {
    protected static TestData testData;

    protected WebDriver driver;

    @BeforeAll
    public static void loadConfig() {
        testData = TestDataReader.loadTestData();
    }

}
