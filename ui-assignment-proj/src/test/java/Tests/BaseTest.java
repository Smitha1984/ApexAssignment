package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.BasePage;

public class BaseTest {

	
	public static WebDriver driver;

	@BeforeSuite
	public void init() throws IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Smitha\\Desktop\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		BasePage.driver = driver;

		driver.get("https://www.amazon.com/");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
	
}
