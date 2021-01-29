package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ItemDetailsPage;
import Pages.LoginPage;
import Pages.SearchResultsPage;
import Pages.ShoppingCartPage;

public class SearchTest extends BaseTest {

	HomePage homepage;
	SearchResultsPage searchResultsPage;
	ItemDetailsPage itemDetailsPage;
	ShoppingCartPage shoppingCartPage;
	LoginPage loginPage;
	String priceFromSearchpage;

	@Test(priority = 1)
	public void searchItem() {
		homepage = new HomePage();
		homepage.seachForItem("qa testing for beginners");

		// Verify page title
		Assert.assertTrue(homepage.verifyPageTitle());

		// Storing price in variable to assert in further steps
		priceFromSearchpage = homepage.getPrice();

	}

	@Test(priority = 2)
	public void clickFirstSeachResult() {
		// Click on the first item
		itemDetailsPage = homepage.clickFirstItem_SearhResult();

		// Get the PRICE on the page
		String actualPrice = itemDetailsPage.getPrice();

		// Assert price with value captured in search page
		Assert.assertEquals(actualPrice, priceFromSearchpage, "Expected price does not match with actual price");

	}

	@Test(priority = 3)
	public void addItemToCart() {
		// Click on add to cart button
		shoppingCartPage = itemDetailsPage.clickAddToCart();

		// Verify page title
		Assert.assertTrue(shoppingCartPage.verifyPageTitle());

		// Get the PRICE on the page
		String actualPrice = shoppingCartPage.getPrice();

		// Assert price with value captured in search page
		Assert.assertEquals(actualPrice, priceFromSearchpage, "Expected price does not match with actual price");

	}

	@Test(priority = 4)
	public void proceedToCheckout() {

		loginPage = shoppingCartPage.clickProceedToCheckout();
		// User is redirected to Login page. So stopping test here
		
		// Verify page title
		Assert.assertTrue(loginPage.verifyPageTitle());

	}

}
