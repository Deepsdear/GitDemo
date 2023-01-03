package rahulshettyacademy.tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {
	public static void main(String[] args) {
	
		String productName =" ZARA COAT 3";
		WebDriverManager.chromedriver().setup();// with step chrome driver can automatically downloaded in ur system no need to give path to chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);// created object here to transfer driver in LandingPage
		driver.findElement(By.id("userEmail")).sendKeys("Deepika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Deepika@1988");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));// global explicit wait here to get the all products
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));//.classname
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		// tagname b
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();// class= card-body, tagname button, last of type means last type element
		// this will select add to card button it will check if it is equal to zara coat 3 then click on add to cart
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));// wait until visility of toast container it is interactive element meanss not on screen
		                                                                                              // #id = css
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));// wait till the loading is invisible
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();// to click on the cart  attribute= attribute value
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));// .classname space tagname / it will select the products in the cart section
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		//anyMatch = this method check the cart product if any match found it will returns true
		Assert.assertTrue(match);// this will accept only true
		driver.findElement(By.cssSelector(".totalRow button")).click();// .classname space tagname // to click on checkout button
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();// to select india in country section
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit ")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
		driver.close();
		
	}

}

/// add to cart is not working
