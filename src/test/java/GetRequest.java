import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class GetRequest {
    public static void main(String[] args) {

        // Response interface
        Response response =
                RestAssured
                        .given()
                        .baseUri("https://reqres.in")
                        .basePath("/api/users/2")
                        .when()
                        .get();

        // Pretty Print Response Body:
        response.prettyPrint();

        // Assertion on Status Code:
        response.then().statusCode(200);

//        response.then().statusCode(200).and().statusLine("HTTP/1.1 200 OK");

        // Assertion on Status Line:
        response.then().statusLine("HTTP/1.1 200 OK");

        // Assertion on Response Body Parameters   Matchers:
        response.then().body("data.first_name", Matchers.equalTo("Janet"));


        RestAssured
                .given()
                .baseUri("https://reqres.in/api/users/2")
                .when()
                .get()
                .prettyPrint();
    }
}