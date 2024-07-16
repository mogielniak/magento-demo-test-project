package test;

import com.fasterxml.jackson.databind.JsonNode;
import main.config.JSONreader;
import main.helpers.webDriver.browserType;
import main.helpers.webDriver.driverUtil;
import main.pages.MenJacket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static main.config.JSONreader.basicConfig;

import static main.util.PageUtil.gotoSite;
import static org.testng.Assert.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopTest{                                  //to do: make it work for one browser
                                                        //it used to work like that but yeah idk.. im tired bye

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriver driver = browserType.createBrowser();
        driverUtil.setWebDriver(driver);}
    @AfterEach
    public void tearDown(){
        driver = driverUtil.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }


    static Stream<Object[]> yellowMenJacket() throws IOException {
        JsonNode rootNode = JSONreader.readConfig(basicConfig);
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
        return arguments.stream();
    }
    static Stream<Object[]> buyALL() throws IOException {
        JsonNode rootNode = JSONreader.readConfig(basicConfig);
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
        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource("yellowMenJacket")
    void testAddYellowMenJacketToCart(int productId, String size){
        gotoSite("menJacket");
        MenJacket menJacket = new MenJacket();
        menJacket.addProductToCart(productId,size,"yellow");
    }

}

