package com.mohammadeko.postman.restassured.twentytwo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPut {

    String endpoint = "https://mern-backend-8881.herokuapp.com/products/6306405fcd2ff4d2fcd68b83";

    @Test
    public void testPutProductId() {
        JSONObject request = new JSONObject();
        request.put("name", "Mohammad Eko Nur Fauzi");
        request.put("category", "Bootcamp SQA");
        request.put("price", 10000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put(endpoint)
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testValidasiPut() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("name", equalTo("Mohammad Eko"))
                .body("category", equalTo("Bootcamp"))
                .body("price", equalTo(9000));
    }
}
