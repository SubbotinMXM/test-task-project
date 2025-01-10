package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    SelenideElement checkoutBtn = $x("//button[@data-test='checkout']");

    @Step("Проверка, что товар {product} отображается в корзине")
    public CartPage checkProductInCart(String product){
        $x("//div[text()='" + product + "']").shouldBe(visible);
        return this;
    }

    @Step("Переход на страницу ввода данных для оформления заказа")
    public CustomerDataPage checkout(){
        checkoutBtn.click();
        return new CustomerDataPage();
    }
}
