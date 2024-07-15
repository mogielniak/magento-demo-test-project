package test;

import com.fasterxml.jackson.databind.JsonNode;
import main.config.JSONreader;
import org.junit.Before;
import io.restassured.RestAssured;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static main.config.PropertyReader.getProperty;
import static main.util.NavigationUtil.mergePage;
import static org.hamcrest.CoreMatchers.notNullValue;

public class APITest {
    private static JsonNode rootNode;
    @Before
    public void setup() throws IOException{
        RestAssured.baseURI = mergePage("api_page");
        rootNode = JSONreader.readConfig(JSONreader.apiConfig); //change email value to diffenret to receive all notifications (use unique email everytime to make it work)
    }
    @Test
    public void testCreateCustomer(){
        String requestBody = rootNode.get("createCustomer").toString();

        given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + getProperty("accessToken"))
                .body(requestBody)
                .log().all()
                .when()
                .post(mergePage("endpoint"))
                .then()
                .log().all()
                .statusCode(200)
                .body("id", notNullValue());
    }
}
