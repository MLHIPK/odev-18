import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class CustomApiTest {
    HashMap<Integer, String> metin = new HashMap<>();

    @BeforeClass
    public static void data(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getUsersTest() {
        given()
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .log().body();
    }

    @Test
    public void getSingleUserTest() {
        given()
            .when()
            .get("/users/1")
            .then()
            .statusCode(200)
            .body("name",equalTo("Leanne Graham"))
            .time(lessThan(2000L));
    }

    @Test
    public void createUserTest() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Mesude İpek");
        data.put("username", "mesudeipek");
        data.put("email", "pekm.3366@gmail.com");

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("/users")
        .then()
            .statusCode(201);
    }

    @Test
    public void updateUserTest() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Meliha");
        data.put("job", "uzman");
        data.put("email", "pekm.3366@gmail.com");

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .put("/users/1")
        .then()
            .statusCode(200)
            .log().body();
    }
}
