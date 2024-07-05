package EZEN.brandcon;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void 상품목록조회() {
        RestAssured.when()
                .get("/products")
                .then()
                .statusCode(200);
    }

    @Test
    void 브랜드목록조회() {
        RestAssured.when()
                .get("/brands?categoryId=323")
                .then()
                .statusCode(200);
    }

    @Test
    void 상품조회() {
        RestAssured.when()
                .get("/products/{productId}", 3)
                .then()
                .statusCode(200);
    }

    @Test
    void 카테고리목록조회() {
        RestAssured.when()
                .get("/categories")
                .then()
                .statusCode(200);
    }
}
