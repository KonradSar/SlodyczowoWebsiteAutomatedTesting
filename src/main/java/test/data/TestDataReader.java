package test.data;

import test.data.model.Address;
import test.data.model.Credentials;
import test.data.model.Url;
import test.data.model.User;
import utils.cookie.Cookie;

public class TestDataReader {
    private Cookie cookie;
    private Cookie attribute;
    private User name;
    private User surname;
    private User phone;
    private User email;
    private Address street;
    private Address postalCode;
    private Address city;
    private Url japanCandiesDescendingPrice;
    private Url barsResults2ndSite;
    private Url barsResults1stSite;
    private Url japanCandies;
    private Url tajlandCandies;
    private Url salsaDipDetails;
    private Url basket;
    private Url mainPageSource;
    private Credentials eMail;
    private Credentials password;

    public TestDataReader(Cookie cookieName, Cookie cookieAttribute, User name, User surname,
                          User phone, User email, Address city, Address street, Address postalCode,
                          Url japanCandiesResults4thSite, Url barsResults2ndSite, Url barsResults1stSite,
                          Url japanCandies, Url tajlandCandies, Url salsaDipDetails, Url basketSite,
                          Url baseURL, Credentials eMail, Credentials password) {
        this.cookie = cookieName;
        this.attribute = cookieAttribute;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.japanCandiesDescendingPrice = japanCandiesResults4thSite;
        this.barsResults2ndSite = barsResults2ndSite;
        this.barsResults1stSite = barsResults1stSite;
        this.japanCandies = japanCandies;
        this.tajlandCandies = tajlandCandies;
        this.salsaDipDetails = salsaDipDetails;
        this.basket = basketSite;
        this.mainPageSource = baseURL;
        this.eMail = eMail;
        this.password = password;
    }

    public Cookie getAttribute() {
        return attribute;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public User getName() {
        return name;
    }

    public User getSurname() {
        return surname;
    }

    public User getPhone() {
        return phone;
    }

    public User getEmail() {
        return email;
    }

    public Address getStreet() {
        return street;
    }

    public Address getPostalCode() {
        return postalCode;
    }

    public Address getCity() {
        return city;
    }

    public Url getJapanCandiesDescendingPriceResults() {
        return japanCandiesDescendingPrice;
    }

    public Url getBarsResults2ndSite() {
        return barsResults2ndSite;
    }

    public Url getBarsResults1stSite() {
        return barsResults1stSite;
    }

    public Url getJapanCandies() {
        return japanCandies;
    }

    public Url getTajlandCandies() {
        return tajlandCandies;
    }

    public Url getSalsaDipDetails() {
        return salsaDipDetails;
    }

    public Url getBasket() {
        return basket;
    }

    public Url getMainPageSource() {
        return mainPageSource;
    }

    public Credentials geteMail() {
        return eMail;
    }

    public Credentials getPassword() {
        return password;
    }
}
