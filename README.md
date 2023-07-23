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
<li>Maven <a href="https://maven.apache.org/guides/index.html">Docs</a></li>
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


#### Run some API Tests:
<ul>
<li>Run all API Tests</strong>:</li>
<ul>
<blockquote>
mvn test -Dtest=com.myrootpackage.myfirstlevelpackage.*
</blockquote>
</ul>
<li>Run a single Test</strong>:
</li>
<ul>
<blockquote>
mvn -Dtest=TEST_CLASS_NAME#METHOD_NAME test
</blockquote>
</ul>
</ul>

#### Run some UI Tests:

<ul>
<li>Run all UI Tests</strong>:</li>
<ul>
<blockquote>
mvn test -Dtest=com.myrootpackage.myfirstlevelpackage.*
</blockquote>
</ul>
<li>Run a single Test</strong>:
</li>
<ul>
<blockquote>
mvn -Dtest=TEST_CLASS_NAME#METHOD_NAME test
</blockquote>
</ul>
</ul>

# Generating test results using Allure:

<ol>
<li>Install Allure <a href="https://docs.qameta.io/allure/">Docs</a></li>
<li>Run tests</li>
<li>When tests are finished, generate Allure reports</li>
<blockquote>
allure serve target/allure-results
</blockquote>
<li>Report should be generated and opened in browser like <a href="https://www.google.pl/imgres?imgurl=https%3A%2F%2Fwebdriver.io%2Fassets%2Fimages%2Fallure-bb6c9b036b07594235a5aca5aff5ac43.png&tbnid=ZrGEZmz03JdTtM&vet=12ahUKEwiql4ym2qWAAxUaEBAIHdcyCFMQMygBegUIARCzAQ..i&imgrefurl=https%3A%2F%2Fwebdriver.io%2Fdocs%2Fallure-reporter%2F&docid=ZjIU2QyMA4d84M&w=1920&h=1080&q=allure%20results%20in%20browser&ved=2ahUKEwiql4ym2qWAAxUaEBAIHdcyCFMQMygBegUIARCzAQ">Here</a></li>
</ol>

