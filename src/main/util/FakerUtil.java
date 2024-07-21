package main.util;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public final class FakerUtil {
    private FakerUtil(){}

    private static Faker faker = new Faker();
    private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

    public static String getRandomFirstname(){
        return faker.name().firstName();
    }
    public static String getRandomLastname(){
        return faker.name().lastName();
    }
    public static String getRandomEmail(){
        String email = fakeValuesService.bothify("??#???#??#?#?@gmail.com");
        return email;
    }
    public static String getRandomPassword(){
        String password = fakeValuesService.bothify("??#?#?#?#???#?#?##?#?!!");
        return password;
    }
}
