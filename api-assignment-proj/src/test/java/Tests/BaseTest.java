package Tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BaseTest {

	@BeforeSuite
	public void beforeSuite() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	}

}
