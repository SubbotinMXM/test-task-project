package data;

import config.Config;
import lombok.Getter;

/**
 * Имена юзеров использую сразу здесь без чтения из конфига, тк это не чувствительная информация, а при необходимости
 * можно имя поменять здесь и использовать в любом месте проекта через геттер
 *
 * Пароль считываю из конфига. Он в открытом виде не сможет лежать в репозитории и уже в properties
 * файле по хорошему должен шифроваться
 */

@Getter
public enum Users {
    STANDART_USER("standard_user", Config.getConfig().password()),
    LOCKED_OUT_USER("locked_out_user", Config.getConfig().password()),
    PROBLEM_USER("problem_user", Config.getConfig().password()),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", Config.getConfig().password()),
    ERROR_USER("error_user", Config.getConfig().password()),
    VISUAL_USER("visual_user", Config.getConfig().password());

    private final String LOGIN;

    private final String PASSWORD;

    Users(String login, String password) {
        LOGIN = login;
        PASSWORD = password;
    }
}
