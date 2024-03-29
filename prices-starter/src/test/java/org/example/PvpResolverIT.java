package org.example;

import io.restassured.RestAssured;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PvpResolverIT {
  @LocalServerPort private int port;

  @Test
  void contextLoads() {}

  @Test
  void testOne() {
    final String path = getPath(LocalDateTime.of(2020, 6, 14, 10, 0, 0));

    RestAssured.given()
        .accept(String.valueOf(MediaType.APPLICATION_JSON))
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .get(path)
        .then()
        .statusCode(200)
        .assertThat()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-14T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("currency", Matchers.equalTo("EUR"))
        .body("price", Matchers.equalTo(35.5F));
  }

  @Test
  void testTwo() {
    String path = getPath(LocalDateTime.of(2020, 6, 14, 16, 0, 0));

    RestAssured.given()
        .accept(String.valueOf(MediaType.APPLICATION_JSON))
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .get(path)
        .then()
        .statusCode(200)
        .assertThat()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-14T15:00:00"))
        .body("endDate", Matchers.equalTo("2020-06-14T18:30:00"))
        .body("currency", Matchers.equalTo("EUR"))
        .body("price", Matchers.equalTo(25.45F));
  }

  @Test
  void testThree() {
    String path = getPath(LocalDateTime.of(2020, 6, 14, 21, 0, 0));

    RestAssured.given()
        .accept(String.valueOf(MediaType.APPLICATION_JSON))
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .get(path)
        .then()
        .statusCode(200)
        .assertThat()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-14T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("currency", Matchers.equalTo("EUR"))
        .body("price", Matchers.equalTo(35.5F));
  }

  @Test
  void testFour() {
    String path = getPath(LocalDateTime.of(2020, 6, 15, 10, 0, 0));

    RestAssured.given()
        .accept(String.valueOf(MediaType.APPLICATION_JSON))
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .get(path)
        .then()
        .statusCode(200)
        .assertThat()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-15T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-06-15T11:00:00"))
        .body("currency", Matchers.equalTo("EUR"))
        .body("price", Matchers.equalTo(30.5F));
  }

  @Test
  void testFive() {
    String path = getPath(LocalDateTime.of(2020, 6, 16, 21, 0, 0));

    RestAssured.given()
        .accept(String.valueOf(MediaType.APPLICATION_JSON))
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .get(path)
        .then()
        .statusCode(200)
        .assertThat()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-15T16:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("currency", Matchers.equalTo("EUR"))
        .body("price", Matchers.equalTo(38.95F));
  }

  private String getPath(LocalDateTime time) {
    return "http://localhost:%s/prices/pvp?productId=35455&brandId=1&date=%s".formatted(port, time);
  }
}
