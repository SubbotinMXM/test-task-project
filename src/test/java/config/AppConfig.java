package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.DefaultValue;

/**
 * Интерфейс для чтения значений из properties файла
 */

@Config.Sources({
        "classpath:${env}.properties", // выбираем файл в зависимости от окружения. В ресурсах лежит dev.properties и
        // можно запустить тесты через gradle test -Denv=dev с содержимым пропертей именно оттуда. И таких проперти
        // файлов с разными окружениями может быть несколько
        "classpath:project.properties" // а читать с этого файла будем по умолчанию, если не передавать при запуске
        // никаких дополнительных аргументов. Просто вызвать gradle test
})
public interface AppConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("browserSize")
    String browserSize();

    @Key("password")
    String password();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();
}
