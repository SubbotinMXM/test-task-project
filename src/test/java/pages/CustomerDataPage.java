package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.UserData;

import static com.codeborne.selenide.Selenide.$x;

public class CustomerDataPage {

    SelenideElement
            firstNameInput = $x("//input[@data-test='firstName']"),
            lastNameInput = $x("//input[@data-test='lastName']"),
            postalCodeInput = $x("//input[@data-test='postalCode']"),
            continueBtn = $x("//input[@data-test='continue']");

    @Step("Заполнение данных покупателя")
    public CustomerDataPage fillData(UserData user){
        firstNameInput.setValue(user.getFirstName());
        lastNameInput.setValue(user.getLastName());
        postalCodeInput.setValue(user.getZipcode().toString());
        return this;
    }

    @Step("Нажатие на кнопку 'Continue'")
    public FinishOrderPage pressContinue(){
        continueBtn.click();
        return new FinishOrderPage();
    }
}
