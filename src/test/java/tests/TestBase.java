package tests;

import com.codeborne.selenide.Configuration;
import config.Config;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = Config.getConfig().browserSize();
        // Здесь можно указать другие конфигурации по необходимости, а так же условие через if для запуска тестов на сервере
        // Вроде if(jenkins){} else {}
    }
    MainPage mainPage = new MainPage();
}
