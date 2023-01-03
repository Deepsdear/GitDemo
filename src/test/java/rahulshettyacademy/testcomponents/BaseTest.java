package rahulshettyacademy.testcomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		//properties class present in java.util package
		Properties prop = new Properties();// object of class Properties
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");// object of Class(from java.io package) FileInputStream
		//GlobalData file path in argument, here it is converting file into input stream object, this is how properties object is reading GlobalData file
		//System.getProperty("user.dir") it will make path dynamic 
		prop.load(fis);// laod method expecting input stream object
		String browserName = prop.getProperty("browser");// to get the properties of browser from GlobalData file
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();// with step chrome driver can automatically downloaded in ur system no need to give path to chromedriver
		driver = new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox code
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge code
			System.setProperty("webdriver.edge.driver", "edge.exe");	
			 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		 driver = initializeDriver();
		landingPage = new LandingPage(driver);// created object here to transfer driver in LandingPage
		landingPage.goTo();// this will land to ecommerce website
		return landingPage;
			
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
