package test.data.model;

import java.util.Properties;

public class User {
    protected final String userName;
    protected final String userSurname;
    protected final String userContactNumber;
    protected final String userEmailAddress;

    public User(Properties properties) {
        userName = properties.getProperty("user.name");
        userSurname = properties.getProperty("user.surname");
        userContactNumber = properties.getProperty("user.phone");
        userEmailAddress = properties.getProperty("user.email");
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }
}
