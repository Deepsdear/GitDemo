package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponenets.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
   WebDriver driver;// loacal variable declaired

   public LandingPage(WebDriver driver)// here we have called driver from StandAloneTest class, this driver scope is upto this method only
   { //initialization, this method is first thing to execute
	   super(driver);// here we are sending sriver from child class to parent class 
	   //LandingPage= childClass
	   //AbstractComponent= parent class
	   this.driver = driver;// this.driver means loacal variable driver, transferring driver to this.driver, thats why we transfering here
	   PageFactory.initElements(driver, this);// it will provide driver to findby webelements
	   //initElements = this method trigger to initialize the elements
   }
	
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(id ="userEmail")// this is taking driver from pagefactory argument driver
	WebElement userEmail;
	
	@FindBy(id ="userPassword")
	WebElement passwordEle;
	
	@FindBy(id ="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);// after login we are going to product catalogue page that why this object is retuen here
		return productCatalogue;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
