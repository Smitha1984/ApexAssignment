package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailsPage extends BasePage{
	
	@FindBy(xpath = "(//span[@class='a-size-base mediaTab_subtitle'])[1]")
	WebElement price;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartBtn;
	
	public String getPrice() {
		return price.getText();
	}
	
	public ShoppingCartPage clickAddToCart() {
		addToCartBtn.click();
		return new ShoppingCartPage();
	}
	
	public boolean verifyPageTitle() {
		String expectedTitle = "Unit Testing Principles, Practices, and Patterns: Effective testing styles, patterns, and reliable automation for unit testing, mocking, and integration testing with examples in C#: Khorikov, Vladimir: 9781617296277: Amazon.com: Books";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle.equals(expectedTitle);
	}
	 
}

