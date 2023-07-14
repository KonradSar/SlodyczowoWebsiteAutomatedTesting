package utils.url;

import lombok.SneakyThrows;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CurrentUrlHelper {
    @SneakyThrows
    public static boolean compareWithCurrentUrl(String url) {
        return getWebDriver().getCurrentUrl().equals(url);
    }
}
