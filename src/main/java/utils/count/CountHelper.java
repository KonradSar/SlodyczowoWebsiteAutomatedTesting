package utils.count;

import com.codeborne.selenide.SelenideElement;

public class CountHelper {
    public static boolean cartCountComparison(SelenideElement selenideElement, int numberOfProducts){
        return selenideElement.getText().equals(String.valueOf(numberOfProducts));
    }
}
