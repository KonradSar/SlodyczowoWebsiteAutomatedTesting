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

# Requirements:

It is required to add some dependencies to pom.xml file and install:
</br> <ol><li>***Oracle OpenJDK version 18.0.2***</li><li>***IntelliJ IDEA 2022.2.1***</li></ol>

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>org.example</groupId>
<artifactId>shopTest</artifactId>
<version>1.0-SNAPSHOT</version>
<properties>
<maven.compiler.source>18</maven.compiler.source>
<maven.compiler.target>18</maven.compiler.target>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
<name>shopTest Maven Webapp</name>
<url>http://maven.apache.org</url>
<dependencies>
<dependency>
<groupId>com.codeborne</groupId>
<artifactId>selenide</artifactId>
<version>6.14.0</version>
</dependency>
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-api</artifactId>
<version>2.6.1</version>
</dependency>
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-core</artifactId>
<version>2.6.1</version>
</dependency>
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.12</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.18.24</version>
<scope>compile</scope>
</dependency>
<dependency>
<groupId>org.jetbrains</groupId>
<artifactId>annotations</artifactId>
<version>RELEASE</version>
<scope>compile</scope>
</dependency>
<dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-api</artifactId>
<version>5.9.2</version>
</dependency>
<dependency>
<groupId>org.awaitility</groupId>
<artifactId>awaitility</artifactId>
<version>4.2.0</version>
</dependency>
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>4.5.1</version>
</dependency>
</dependencies>
</project>

```

# Some part's of the code below:

#### Setting TEST_DATA_LOCATION:

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
