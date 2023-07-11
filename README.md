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

// TODO: dodać odnośniki do docs dla użytych bilbiotek
# Some part's of the code below:

#### Loading test data:
// TODO: podmienić śmierdziuszka nowym plikiem

```java
public class BaseAPITest {
    protected static TestDataReader testDataReader;
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";

    @BeforeAll
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
```

#### Some UI tests:

```java
@Test
public void makeACocaColaOrderWithNoOrdering() {
        //Given
        mainPage.addTwoCocaColaToCart();
        header.goToShoppingCartView();
        mainPage.selectDeliveryWay();
        mainPage.selectPaymentMethod();
        mainPage.fillInClientsInformationForm();

        //When
        mainPage.acceptRegulations();

        //Then
        assertTrue(mainPage.isPlaceAnOrderPageDisplayed());
        }
```
// TODO: sformatować kod, usunąć sysOutPrntln, zmień na "log.INFO"
#### Some API tests:
```java
 @Test
public void When_YouClickOnJapanProducts_Expect_JapanProductsPAgeIsDisplayed() {
        Response response = given()
        .when()
        .get(testDataReader.getJapanCandies().getJapansCandyCategoryUrl());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.getStatusCode());
        if(response.getStatusCode()==200){
        logger.log(Level.INFO, "Japan products page is successfully displayed");
        }
}
```

# How to run some UI/API tests:
// TODO: opisać uruchamianie testów z konsoli za pomocą maven'a

#### It is required to follow the way described below:
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
<li>Run some Test using maven/Allure
<ul>
<li>open Intelijj Treminal and type in command: allure serve + "<em>URL to your tests reports</em>"</li>
<li>tap enter and wait until report is displayed</li>
<li>you can also use maven by selecting from right corner side menu option named <strong><em>"test"</em></strong></li>
</ul>
</li>
</ol>
