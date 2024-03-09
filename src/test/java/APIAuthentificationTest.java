import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class APIAuthentificationTest extends BaseApiTest {
    @Test
    public void registerANewApiClient() {
        RestAssured.given()
                .body(
                        """
                                {
                                   "clientName": "Postman on Mihai computer",
                                   "clientEmail": "mihai@gmail.com"
                                }        
                                """
                )
                .when().post("/api-clients")
                .then()
                .statusCode(201)
                .log()
                .all();


    }
}
