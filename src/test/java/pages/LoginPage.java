package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    SelenideElement
            usernameInput = $x("//input[@data-test='username']"),
            passwordInput = $x("//input[@data-test='password']"),
            loginBtn = $x("//input[@data-test='login-button']");

    @Step("Логинимся пользователем {login}")
    public MainPage login(String login, String password){
        usernameInput.setValue(login);
        passwordInput.setValue(password);
        loginBtn.click();
        return new MainPage();
    }
}
