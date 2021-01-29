package Pages;

public class LoginPage extends BasePage {
	
	public boolean verifyPageTitle() {
		String expectedTitle = "Amazon Sign-In";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle.equals(expectedTitle);
	}

}
