import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.equalTo;

public class GetRequest_Query {
    public static void main(String[] args) {

        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in/api/users")
                .queryParam("page", "2")
                .when()
                .get();

        response.prettyPrint();

        response.then().statusLine("HTTP/1.1 200 OK");
        response.then().body("data[0].email",Matchers.equalTo("michael.lawson@reqres.in"));


//        response.then().statusCode(200)
//                .and().statusLine("HTTP/1.1 200 OK")
//                .and().body("data[0].email",Matchers.equalTo("michael.lawson@reqres.in"));
    }
}

