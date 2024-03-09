import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class APIOrdersTest extends BaseApiTest {

    @Test
    public void createAnOrder() {
        RestAssured.given()
                .header("Authorization", Constants.ACCES_CODE)
                .body(
                        """
                                {
                                "cartId":"T9IIxq-7rbI78ERRcuhZQ",
                                "customerName":"Postman on Mihai computer",
                                  "comment":"Pick up between 19:30 and 20:00"
                                  }     
                                       """
                ).when().post("/orders")
                .then().statusCode(400)
                .log()
                .all();


    }

    @Test
    public void getAllOrders() {
        RestAssured.given()
                .header("Authorization", Constants.ACCES_CODE)
                .when().get("/orders")
                .then().statusCode(200)
                .log()
                .all();
    }

    @Test
    public void updateAnOrder() {
        RestAssured.given()
                .header("Authorization", Constants.ACCES_CODE)
                .body(
                        """
                                {
                                "comment":"Change the pickup time between 19:30 and 20:00, to new time  10:00 Am"
                                }      
                                       """
                ).when().patch("/orders/qjwAfvR99zelA9SR4W143")
                .then().statusCode(204)
                .log()
                .all();
    }
}
