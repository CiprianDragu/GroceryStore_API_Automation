import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class APIProductsTest extends BaseApiTest {
    @Test
    public void getAllProducts() {
        RestAssured.when().get("/products")
                .then().statusCode(200)
                .log()
                .all();
    }

    @Test
    public void getAnProduct() {
        RestAssured.given()
                .when().get("/products/1709")
                .then().statusCode(200)
                .log()
                .all();

    }

    @Test
    public void checkProductName() {
        Response response = RestAssured.get("/products/1709");
        System.out.println(response.asPrettyString());
        String expectedName = "Beef Choice Angus Ribeye Steak";
        String actualName = response.jsonPath().getString("name");
        Assertions.assertEquals(expectedName, actualName, "The name is not correct!");
    }

    @Test
    public void checkProductPrice() {
        Response response = RestAssured.get("/products/1709");
        double expectedPrice = 14.95;
        double actualPrice = response.jsonPath().getDouble("price");
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void checkIfProductIsInStock() {
        Response response = RestAssured.get("/products/1709");
        boolean expectedMessage = true;
        boolean actualMessage = response.jsonPath().getBoolean("inStock");
        Assertions.assertEquals(expectedMessage, actualMessage, "Check if The inStock key its right");
    }
}
