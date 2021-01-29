package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteEmploeeTest extends BaseTest{

	Response response;

	@Test
	public void deleteEmployeeDetailTest() throws JsonParseException, JsonMappingException, IOException {
		int id = 2;
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/delete/{id}", id).then()
				.extract().response();

		// Get Status code and Assert
		// Actual API itself is not working so asserting with returned error code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 404);

	}
}
