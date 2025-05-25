package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = Config.getConfig().browserSize();
        Configuration.browser = Config.getConfig().browser();
        Configuration.headless = Config.getConfig().isRemote();
    }
    MainPage mainPage = new MainPage();
}
