package condition;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;

public class LocationCondition {
    public static Condition locationY(int expectedValue) {
        return new Condition(String.format("value '%s' in locationY", expectedValue)) {
            @Override      @Nonnull
            public CheckResult check(Driver driver, WebElement element) {
                int currentYCoordinateValue = element.getLocation().getY();
                return new CheckResult(currentYCoordinateValue==expectedValue, currentYCoordinateValue);
            }
        };
    }
}
