package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = Config.getInstance().browserSize();
        // Здесь можно указать другие конфигурации по необходимости, а так же условие через if для запуска тестов на сервере
        // Вроде if(jenkins){} else {}
    }
    MainPage mainPage = new MainPage();
}
