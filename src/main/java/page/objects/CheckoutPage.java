package page.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import test.data.TestData;
import utils.element.ElementHelper;
import utils.url.CurrentUrlHelper;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPage {
    SelenideElement dhlRadioBtn = $(By.cssSelector(".el-radio-group .shipping_22 .el-radio__input"));
    SelenideElement selectYourBankBtn = $(By.cssSelector(".selectYourBank>button"));
    SelenideElement millenniumBankLabel = $(By.cssSelector("img[src='https://platnosci.bm.pl/pomoc/grafika/1807.png']"));
    SelenideElement telephoneInputText = $(By.cssSelector(".one-step_address div:nth-child(3) input[name='Telefon']"));
    private final static String EMAIL_INPUT = ".one-step_address div:nth-child(3) input[name='e-mail']";
    private final static String NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Imię']";
    private final static String SURNAME_INPUT = ".one-step_address div:nth-child(3) input[name='Nazwisko']";
    private final static String STREET_NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Ulica i numer']";
    private final static String POSTAL_CODE_INPUT = ".one-step_address div:nth-child(3) input[name='Kod pocztowy']";
    private final static String CITY_NAME_INPUT = ".one-step_address div:nth-child(3) input[name='Miasto']";
    List<SelenideElement> checkBoxes = $$(By.cssSelector(".el-checkbox__input"));
    public void selectDeliveryWay() {
        ElementHelper.scrollToElementAndClick(dhlRadioBtn);
    }
    public void selectPaymentMethod() {
        ElementHelper.forceClickOnElement(selectYourBankBtn);
        millenniumBankLabel.shouldBe(visible);
        ElementHelper.moveToElementAndClick(millenniumBankLabel);
    }
    public void fillInClientsInformationForm(TestData testData) {
        telephoneInputText.setValue(testData.getPhone().getUserContactNumber());
        ElementHelper.scrollToElementAndClick(telephoneInputText);
        $(By.cssSelector(EMAIL_INPUT)).setValue(testData.getEmail().getUserEmailAddress());
        $(By.cssSelector(NAME_INPUT)).setValue(testData.getName().getUserName());
        $(By.cssSelector(SURNAME_INPUT)).setValue(testData.getSurname().getUserSurname());
        $(By.cssSelector(STREET_NAME_INPUT)).setValue(testData.getStreet().getStreetName());
        $(By.cssSelector(POSTAL_CODE_INPUT)).setValue(testData.getPostalCode().getPostaLCode());
        $(By.cssSelector(CITY_NAME_INPUT)).setValue(testData.getCity().getCityName());
    }

    public void acceptRegulations() {
        for (int i = 1; i < 3; i++) {
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled()) {
                ElementHelper.forceClickOnCheckboxElement(checkBoxes.get(i));
            }
        }
    }
    public boolean isPlaceAnOrderPageDisplayed(TestData testData) {
        return CurrentUrlHelper.compareWithCurrentUrl(testData.getBasket()
                .getBasketSiteUrl());
    }
}
