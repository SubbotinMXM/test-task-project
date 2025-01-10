package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для чтения значений из properties файла
 */

@Config.Sources({"classpath:project.properties"})
public interface AppConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("browserSize")
    String browserSize();

    @Key("password")
    String password();
}
