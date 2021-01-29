package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
	
	@FindBy(xpath = "(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")
	WebElement price;
	
	@FindBy(id = "hlb-ptc-btn-native")
	WebElement proceedToCheckOutBtn;
	
	public String getPrice() {
		return price.getText();
	}
	
	public LoginPage clickProceedToCheckout() {
		proceedToCheckOutBtn.click();
		return new LoginPage();
		
	}
	
	public boolean verifyPageTitle() {
		String expectedTitle = "Amazon.com Shopping Cart";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle.equals(expectedTitle);
	}

}
