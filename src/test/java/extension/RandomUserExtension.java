package extension;

import annotation.RandomUser;
import com.github.javafaker.Faker;
import model.UserData;
import org.junit.jupiter.api.extension.*;

import java.util.Random;

public class RandomUserExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(RandomUser.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (type.equals(UserData.class)) {
            Random random = new Random();
            Faker faker = new Faker();
            return UserData.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .zipcode(random.nextInt(1, 999999))
                    .build();
        }
        throw new ParameterResolutionException("Пользователь не был сгенерирован");
    }
}
