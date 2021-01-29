package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.GetEmployeeResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetEmployeeTest extends BaseTest {

	Response response;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getEmployeeDetailTest() throws JsonParseException, JsonMappingException, IOException {
		int id = 1;
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/employee/{id}", id).then()
				.extract().response();

		// Get Status code and Assert
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);

		System.out.println(response.getBody().asString());

		// Verify employee detail
		// Map Response to POJO and assert details
		GetEmployeeResponse getEmployeeResponse = mapper.readValue(response.getBody().asString(),
				GetEmployeeResponse.class);

		// Response assertions
		Assert.assertEquals("success", getEmployeeResponse.getStatus(), "Status match with expected data");
		Assert.assertEquals("Tiger Nixon", getEmployeeResponse.getData().getEmployee_name(),
				"The employee name doesnt match with expected data");
		Assert.assertEquals("320800", getEmployeeResponse.getData().getEmployee_salary(),
				"The employee salary doesnt match with expected data");
		Assert.assertEquals("61", getEmployeeResponse.getData().getEmployee_age(),
				"The employee age doesnt match with expected data");

	}

}
