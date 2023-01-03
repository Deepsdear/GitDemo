package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class StepDefinitionsImplimentation extends BaseTest{

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page ")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage =  launchApplication();
	}
	
	@ Given ("^Logged in with username (.+) and password (.+)$")  // (.+) this represent any character or any values which are dynamic
	//Start with ^ and end with $ this represent that entire string is regular expression
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username,password); 
	}
	
	  @When ("^I add product (.+) to cart$")
	   public void i_add_product_to_cart(String productName) throws InterruptedException
	   {
		  List<WebElement> products = productCatalogue.getProductList();
		  productCatalogue.addProductToCart(productName);
	   }
	   
	  @When ("^Checkout (.+) and submit the order$")
	  public void checkout_submit_order(String productName)
	  {
		  CartPage cartpage = productCatalogue.goToCartPage();
			
			Boolean match = cartpage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutpage = cartpage.goToCheckout();
			checkoutpage.selectCountry("India");
			confirmationPage = checkoutpage.submitOrder();
	  }
	 
	  @Then("{string}message is displayed on ConfirmationPage")// becoz it is expecting static data
	  public void message_displayed_confirmationPage(String string)
	  {
		  String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	  }
}
