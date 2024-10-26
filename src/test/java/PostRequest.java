import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class PostRequest {
    public static void main(String[] args) {
      Response response= RestAssured
                .given()
                .baseUri("https://reqres.in/api/users")
//                .contentType("application/json")
                .header( "Content-Type","application/json")
                .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
                .request()
                .when()
                .post();

      response.prettyPrint();
      response.then().statusCode(201);
      response.then().statusLine("HTTP/1.1 201 Created");
      response.then().body("name", Matchers.equalTo("morpheus"));
    }
}







