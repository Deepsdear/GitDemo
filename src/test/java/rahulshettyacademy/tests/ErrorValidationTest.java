package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest{
	
	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		String productName =" ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("Deepika@gmail.com", "Deepika@1988"); // no need to create object of product catalogue here as we created in lading page
		
		
	}

}

/// add to cart is not working
