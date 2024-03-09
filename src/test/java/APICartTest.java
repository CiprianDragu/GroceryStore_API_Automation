import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class APICartTest extends BaseApiTest {
    @Test
    public void createANewCart() {
        RestAssured.when().post("/carts")
                .then().statusCode(201)
                .log()
                .all();
    }

    @Test
    public void getACart() {
        RestAssured.when().get("/carts/"+Constants.CART_ID)
                .then().statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addAnItemToTheCart() {
        RestAssured.given()
                .body(
                        """
                                {
                                   "productId":5478,
                                   "guantity":3
                                }
                                """
                ).when().post("/carts/"+Constants.CART_ID+"/items")
                .then().statusCode(201)
                .log()
                .all();
    }

    @Test
    public void modifyAnItemInTheCart() {
        RestAssured.given()
                .body(
                        """
                                {
                                "quantity":2
                                }      
                                      """
                ).when().patch("/carts/"+Constants.CART_ID+"/items/285607687")
                .then().statusCode(204)
                .log()
                .all();
    }

    @Test
    public void replaceAnItemInTheCart() {
        RestAssured.given()
                .body(
                        """
                                {
                                "quantity":1
                                }
                                """
                ).when().patch("/carts/"+Constants.CART_ID+"/items/285607687")
                .then().statusCode(204)
                .log()
                .all();
    }

    @Test
    public void getCartItems() {
        RestAssured.given()
                .when().get("/carts/"+Constants.CART_ID+"/items")
                .then().statusCode(200)
                .log()
                .all();

    }

    @Test
    public void deleteAnItemFromTheCart() {
        RestAssured.given()
                .when().delete("/carts/"+Constants.CART_ID+"/items/810028314")
                .then().statusCode(404)
                .log()
                .all();
    }
}
