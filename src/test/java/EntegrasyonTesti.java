import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EntegrasyonTesti {

    @Test
    public void validateStatusCode (){
        given()
                .baseUri("http://generator.swagger.io").
        when().
                get("/api/swagger.json")
        .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
    //@Test
    public Response get_Request(String baseURL, String endpoint, String pathVariables) {

        Response response = given().filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .when()
                .get(baseURL+endpoint+pathVariables)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;

    }
}
