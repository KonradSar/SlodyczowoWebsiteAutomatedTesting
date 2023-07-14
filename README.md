# Project description:

This project is prepared to execute and maintain tests connected with slodyczowo.pl website. Using this script user can find
out if basic functionalities work properly. It contains UI and also some API tests as well. The following features of
SŁODYCZOWO.PL website are covered by tests as below:
<ol>
<li>Functional tests of basic functionalities included:
<ul>
<li>searching phrases</li>
<li>displaying search history</li>
<li>searching for unavailable phrase</li>
<li>switching between modules</li>
<li>adding products to cart</li>
<li>displaying product's details</li>
<li>displaying related products</li>
<li>logging into account</li>
<li>scrolling and using FAB's</li>
<li>filtering search results</li>
<li>placing an order</li>
<li>displaying correct data and number of elements in dropDown's</li>
</ul>
</li>
<li>API tests includes:</li>
<ul>
<li>checking server response for selected modules displayed</li>
</ul>
</ol>

# Technology stack:
<ol>
<li>Libraries used in project:
<ul>
<li>Selenide <a href="https://selenide.org/documentation.html">Docs</a></li>
<li>REST Assured <a href="https://www.google.pl/search?q=restassured+documentation&source=hp&ei=8kOwZMGEKsiJ9u8Pk56JgA4&iflsig=AD69kcEAAAAAZLBSAteCy5GVHsXjf_O0czhhAvCxlyrc&oq=restassured+docu&gs_lcp=Cgdnd3Mtd2l6EAMYADIFCAAQgAQyBggAEBYQHjIGCAAQFhAeOgsIABCABBCxAxCDAToLCC4QgAQQsQMQgwE6EQguEIAEELEDEIMBEMcBENEDOgsILhCABBDHARCvAToICC4QgAQQsQM6BQguEIAEOhEILhCABBCxAxCDARDHARCvAToICAAQgAQQsQM6DgguEIAEEMkDEMcBEK8BOgQIABAeOgoIABAWEB4QDxAKUABY3xtgiSVoAHAAeACAAXaIAdYJkgEEMTUuMZgBAKABAQ&sclient=gws-wiz">Docs</a></li>
<li>JUnit <a href="https://junit.org/junit4/javadoc/latest/overview-summary.html">Docs</a></li>
<li>Log4J <a href="https://logging.apache.org/log4j/2.x/javadoc.html">Docs</a></li>
<li>Allure <a href="https://docs.qameta.io/allure/">Docs</a></li>
<li>Lombok <a href="http://anthonywhitford.com/lombok.maven/lombok-maven-plugin/plugin-info.html">Docs</a></li>
</ul>
</ol>

# Some part's of the code below:

#### Loading test data:


```java
public class TestDataReader {
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";
    @SneakyThrows
    public static TestData loadTestData(){
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(TEST_DATA_LOCATION),
                StandardCharsets.UTF_8));
        return new TestData(properties);
    }
}
```

#### Some UI tests:

```java
@Test
public void makeACocaColaOrderWithNoConfirm() {
        // Given
        cartPage.addTwoCocaColaToCart();
        header.goToShoppingCartView();
        checkoutPage.selectDeliveryWay();
        checkoutPage.selectPaymentMethod();
        checkoutPage.fillInClientsInformationForm(testData);

        // When
        checkoutPage.acceptRegulations();

        // Then
        assertTrue(header.isNumberOfProductsInCartUpdated());
        assertTrue(checkoutPage.isPlaceAnOrderPageDisplayed(testData));
        }
```

#### Some API class tests:
```java
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
```
```java
public class APIMainPageTests extends BaseAPITest {
    private static Logger logger = LogManager.getLogger(APIMainPageTests.class);

    @Test
    public void When_BaseURLIsLoaded_Expect_SlodyczowoMainPageIsDisplayed() {
        // When
        Response response = given()
                .when()
                .get(testData.getMainPageSource().getBaseURL());
        System.out.println(response.prettyPrint());

        // Then
        Assertions.assertEquals(200, response.getStatusCode());
        if (response.getStatusCode() == 200) {
            logger.log(Level.INFO, "Main page is successfully displayed");
        }
    }
}
```

# How to run some UI/API tests:


#### When there is only Intelijj installed please follow the way described below:
<ol>
<li>Run some <strong>API Tests</strong>:
<ul>
<li>open <em>java/api</em> package></li>
<li>select <strong>APIMainPageTests</strong>> class</li>
<li>click right on selected class and select "Run <em>class name</em>" </li>
</ul>
</li>
<li>Run some <strong>UI Tests:</strong>
<ul>
<li>open <em>java/ui</em> package</li>
<li>select <strong>MainPageTests</strong> or <strong>SearcherTests</strong></li>
<li>click right on selected class and select "Run <em>class name</em>" </li>
</ul>
</li>
</ol>
<strong>When there is maven/Allure installed please follow the way described below:</strong>
<ol>
<li>Run some Test using Allure
<ul>
<li>Add Allure dependencies and plugins to pom.xml</li>
<li>Add allure.properties file to resources</li>
<li>Add a line "allure.results.directory=target/allure-results" within already created allure.properties file</li>
<li>Add Scoop by <a href="https://scoop.sh">Scoop Docs</a> usnig PowerShel and adding to console: "iwr -useb get.scoop.sh | iex"</li>
<li>Install Allure by adding to console: "scoop install allure"</li>
<li>Create the path e.g. like "C:\Users\konrad\scoop\apps\allure\2.23.0\Java\POM\target\allure-report" by adding needed folders to finally create <strong>allure-reports</strong>> folder</li>
<li>Open Intelijj Treminal and type in command: allure serve + "<em>URL to your tests reports</em>" which look like e.g. "allure generate allure-results --clean -o allure-report"</li>
<li>Tap enter and wait until report is generated in target folder</li>
<li>you can also use maven by selecting from right corner side menu option named <strong><em>"test"</em></strong></li>
</ul>
</li>
</ol>