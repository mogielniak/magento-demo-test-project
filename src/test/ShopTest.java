package test;

import com.fasterxml.jackson.databind.JsonNode;
import main.config.JSONreader;
import main.helpers.WebDriverHelper;
import main.pages.Login;
import main.pages.MenJacket;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import main.helpers.WebDriverHelper;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static main.config.PropertyReader.getProperty;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopTest extends BlankTest {

    @BeforeEach
    public void setUp(){
        if(driver==null){
            driver = WebDriverHelper.getDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
    static Stream<Object[]> yellowMenJacket() throws IOException {
        JsonNode rootNode = JSONreader.readConfig();
        JsonNode productsNode = rootNode.path("products").path("men").path("tops").path("jackets");

        List<Object[]> arguments = new ArrayList<>();

        for (JsonNode product : productsNode) {
            JsonNode colorsNode = product.path("colors");
            for (JsonNode color : colorsNode) {
                if ("Yellow".equalsIgnoreCase(color.asText())) {
                    for (String size : new String[]{"XS", "S", "M", "L", "XL"}) {
                        arguments.add(new Object[]{product.path("id").asInt(), size});
                    }
                    break;
                }
            }
        }

        if (arguments.isEmpty()) {
            System.out.println("No yellow jackets found.");
        } else {
            System.out.println("Found yellow jackets: " + arguments);
        }

        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource("yellowMenJacket")
    void testAddYellowMenJacketToCart(int productId, String size){
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("L_pass"));
        gotoSite("menJacket");
        MenJacket menJacket = new MenJacket(driver);
        menJacket.addProductToCart(productId,size,"yellow");
    }
}

