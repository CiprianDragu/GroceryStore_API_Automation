import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BaseApiTest {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = Constants.BASE_URL;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/Json")
                .build();


    }


    @Test
    public void getAPITest() {
        RestAssured.when().get("/status")
                .then().statusCode(200)
                .log()
                .all();
    }
}
