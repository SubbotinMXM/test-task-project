package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FinishOrderPage {

    SelenideElement
            finishBtn = $x("//button[@data-test='finish']"),
            orderSucceedHeader = $x("//h2[@data-test='complete-header']");

    @Step("Нажатие на кнопку 'Finish'")
    public FinishOrderPage finish(){
        finishBtn.click();
        return this;
    }

    @Step("Проверка, что заказ успешно оформлен")
    public FinishOrderPage checkOrderSucceed(){
        orderSucceedHeader.shouldBe(visible);
        return this;
    }
}
