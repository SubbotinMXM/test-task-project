package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Применяется синглтон, для создания единственно инстанса на проект и чтения конфигурации через AppConfig
 */

public class Config {
    private static AppConfig instance;

    private Config(){}

    public static AppConfig getConfig() {
        if(instance == null){
            synchronized (Config.class){
                if (instance == null){
                    instance = ConfigFactory.newInstance().create(AppConfig.class, System.getProperties());
                }
            }
        }
        return instance;
    }
}
