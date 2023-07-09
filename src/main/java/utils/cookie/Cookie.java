package utils.cookie;

import java.util.Properties;

public class Cookie {
    protected final String cookieName;
    protected final String cookieAttribute;

    public Cookie(Properties properties) {
        cookieName = properties.getProperty("cookie.cookieValue");
        cookieAttribute = properties.getProperty("cookie.attributeValue");
    }

    public String getCookieAttribute() {
        return cookieAttribute;
    }

    public String getCookieName() {
        return cookieName;
    }
}
