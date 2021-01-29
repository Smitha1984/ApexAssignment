package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> serchResults;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement priceWhole;

	@FindBy(xpath = "(//span[@class='a-price-decimal'])[1]")
	WebElement priceDecimal;

	@FindBy(xpath = "(//span[@class='a-price-fraction'])[1]")
	WebElement priceFraction;

	public void seachForItem(String searchItem) {
		searchBox.sendKeys(searchItem);
		searchBtn.click();
	}

	public String getPrice() {
		String price = "$"+priceWhole.getText() + "." + priceFraction.getText();
		return price;
	}

	public ItemDetailsPage clickFirstItem_SearhResult() {
		serchResults.get(0).click();
		return new ItemDetailsPage();
	}
	
	public boolean verifyPageTitle() {
		String expectedTitle = "Amazon.com : qa testing for beginners";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle.equals(expectedTitle);
	}

}
