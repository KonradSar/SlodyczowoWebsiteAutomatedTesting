package api;

import org.junit.jupiter.api.BeforeAll;
import test.data.TestData;
import test.data.TestDataReader;

public class BaseAPITest {
    protected static TestData testData;

    @BeforeAll
    public static void loadConfig() {
        testData = TestDataReader.loadTestData();
    }
}
