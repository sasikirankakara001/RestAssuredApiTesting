package org.sasiguides.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo {
	@Test
	public void performPostFunction() throws Exception {
		/*baseURI="https://rahulshettyacademy.com"*/
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		/*For POST Method Code*/
		String res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}\r\n"
						+ "")
				.when().post("/maps/api/place/add/json").then().log().all().extract().response().asString();
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		String place_id = js.get("place_id");
		System.out.println(place_id);
		
		/*For GET Method Code*/
		String gets = given().queryParam("key", "qaclick123").queryParam("place_id", place_id)
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all()
				.extract().response().asString();
		System.out.println(gets);

	}

}
