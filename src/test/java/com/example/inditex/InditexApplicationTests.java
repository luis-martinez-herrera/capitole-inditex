package com.example.inditex;


import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;


import java.time.LocalDateTime;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InditexApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Test
    void testOne(){
        String path = "http://localhost:" + port + "/prices/pvp?productId=35455&brandId=1&date="+ LocalDateTime.of(2020, 6, 14, 10, 0, 0) ;

        RestAssured.given()
                .accept(String.valueOf(MediaType.APPLICATION_JSON))
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .get(path).then().statusCode(200).assertThat()
                .body("productId", Matchers.equalTo(35455))
                .body("price", Matchers.equalTo(35.5F));
    }

    @Test
    void testTwo(){
        String path = "http://localhost:" + port + "/prices/pvp?productId=35455&brandId=1&date="+ LocalDateTime.of(2020, 6, 14, 16, 0, 0) ;

        RestAssured.given()
                .accept(String.valueOf(MediaType.APPLICATION_JSON))
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .get(path).then().statusCode(200).assertThat()
                .body("productId", Matchers.equalTo(35455))
                .body("price", Matchers.equalTo(25.45F));
    }

    @Test
    void testThree(){
        String path = "http://localhost:" + port + "/prices/pvp?productId=35455&brandId=1&date="+ LocalDateTime.of(2020, 6, 14, 21, 0, 0) ;

        RestAssured.given()
                .accept(String.valueOf(MediaType.APPLICATION_JSON))
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .get(path).then().statusCode(200).assertThat()
                .body("productId", Matchers.equalTo(35455))
                .body("price", Matchers.equalTo(35.5F));
    }

    @Test
    void testFour(){
        String path = "http://localhost:" + port + "/prices/pvp?productId=35455&brandId=1&date="+ LocalDateTime.of(2020, 6, 15, 10, 0, 0) ;

        RestAssured.given()
                .accept(String.valueOf(MediaType.APPLICATION_JSON))
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .get(path).then().statusCode(200).assertThat()
                .body("productId", Matchers.equalTo(35455))
                .body("price", Matchers.equalTo(30.5F));
    }

    @Test
    void testFive(){
        String path = "http://localhost:" + port + "/prices/pvp?productId=35455&brandId=1&date="+ LocalDateTime.of(2020, 6, 16, 21, 0, 0) ;

        RestAssured.given()
                .accept(String.valueOf(MediaType.APPLICATION_JSON))
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .get(path).then().statusCode(200).assertThat()
                .body("productId", Matchers.equalTo(35455))
                .body("price", Matchers.equalTo(38.95F));
    }
}
