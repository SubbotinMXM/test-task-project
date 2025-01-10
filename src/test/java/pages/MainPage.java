package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    SelenideElement pageTitle = $x("//div[text()='Swag Labs']");

    ElementsCollection products = $$x("//div[@data-test='inventory-item-name']");

    private final List<Integer> usedIndices = new ArrayList<>(); // Хранит индексы уже добавленных товаров

    @Step("Проверка загрузки главной страницы")
    public MainPage checkPageLoaded(){
        pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Добавление в корзину случайного товара")
    public String addRandomProductToCart(){
        if (usedIndices.size() >= products.size()) {
            throw new IllegalStateException("Все товары уже добавлены в корзину");
        }
        int randomIndex;

        do {
            randomIndex = (int) (Math.random() * products.size());
        } while (usedIndices.contains(randomIndex));

        usedIndices.add(randomIndex);

        SelenideElement randomProduct = products.get(randomIndex);
        String productName = randomProduct.text();
        randomProduct.$x("../../..//button[text()='Add to cart']").click();

        return productName;
    }
}
