package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class RestAssuredTest {

	// Base URL
	String baseUrl = "https://api.restful-api.dev/objects";

	@Test
	public void testAddNewDevice() {
		// Create the request body
		String requestBody = "{\n" +
				"\"name\": \"Apple Max Pro 1TB\",\n" +
				"\"data\": {\n" +
				"\"year\": 2023,\n" +
				"\"price\": 7999.99,\n" +
				"\"CPU model\": \"Apple ARM A7\",\n" +
				"\"Hard disk size\": \"1 TB\"\n" +
				"}\n" +
				"}";
		
		// Send POST request
		Response response = RestAssured.given()
				 .contentType(ContentType.JSON)
				 .body(requestBody)
				 .post(baseUrl);

		// Validate the response contains the expected fields and values
		response.then().body("name", equalTo("Apple Max Pro 1TB"));
		response.then().body("data.year", equalTo(2023));
		response.then().body("data.price", equalTo(7999.99f)); // float check
		response.then().body("data.\"CPU model\"", equalTo("Apple ARM A7"));
		response.then().body("data.\"Hard disk size\"", equalTo("1 TB"));

		// Validate id and createdAt are not null
		response.then().body("id", notNullValue());
		response.then().body("createdAt", notNullValue());
	}
}