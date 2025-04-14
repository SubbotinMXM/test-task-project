package tests;

import annotation.RandomUser;
import annotation.meta.WebTest;
import model.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static config.Config.getConfig;
import static data.Users.STANDART_USER;
import static navigation.Paths.CART_PATH;

@WebTest
@Tag("WebTests")
public class Tests extends TestBase {

    @Test
    @DisplayName("Тест авторизации")
    void successLoginTest() {
        open(getConfig().baseUrl(), LoginPage.class)
                .login(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD())
                .checkPageLoaded();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Тест добавления товаров в корзину")
    void successAddProductsToCartTest() {
        open(getConfig().baseUrl(), LoginPage.class)
                .login(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD());

        String product1 = mainPage.addRandomProductToCart();
        String product2 = mainPage.addRandomProductToCart();

        open(getConfig().baseUrl() + CART_PATH, CartPage.class)
                .checkProductInCart(product1)
                .checkProductInCart(product2);
    }

    @Test
    @DisplayName("Тест оформления заказа")
    void successOrderTest(@RandomUser UserData user) {
        open(getConfig().baseUrl(), LoginPage.class)
                .login(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD());

        String product1 = mainPage.addRandomProductToCart();
        String product2 = mainPage.addRandomProductToCart();

        open(getConfig().baseUrl() + CART_PATH, CartPage.class)
                .checkProductInCart(product1)
                .checkProductInCart(product2)
                .checkout()
                .fillData(user)
                .pressContinue()
                .finish()
                .checkOrderSucceed();
    }
}
