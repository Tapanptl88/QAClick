package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.LandingPage;
import PageObjects.SignUpPage;
import Resources.Base;









public class HomePageTest extends Base {
	
	
public String url ;

public static Logger log = LogManager.getLogger(HomePageTest.class.getName()); 

public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver= initializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
		
	}



	@AfterMethod
	public void tearDown() {
		driver.close();
	}


	@Test()
	
	public void basePageNavigation() throws IOException, InterruptedException
	{
		
		LandingPage lp = new LandingPage(driver);
		SignUpPage sp =lp.getLogin();
		//sp.getfirstName().sendKeys(prop.getProperty("firstname1"));
		sp.getlastName().sendKeys(prop.getProperty("lastname1"));
		sp.getemail().sendKeys(prop.getProperty("email1"));
		sp.getpassword().sendKeys(prop.getProperty("password1"));
		Select m = new Select(sp.getMonth());
		m.selectByVisibleText(prop.getProperty("month"));
		Thread.sleep(2000);
		Select d = new Select(sp.getDay());
		d.selectByVisibleText(prop.getProperty("day"));
		Thread.sleep(2000);
		Select y = new Select(sp.getYear());
		y.selectByVisibleText(prop.getProperty("year"));
		log.info(sp.getGender().get(0).getText());
		log.info(sp.getGender().get(1).getText());
		log.info(sp.getGender().get(2).getText());
		log.info(sp.getGender().size());
		for(int i=0;i<sp.getGender().size();i++)
		{
		if(sp.getGender().get(i).getText().equals(prop.getProperty("gender")))
			sp.getGender().get(i).click();
		}
		
		sp.getwebSubmit().click();
		Assert.assertEquals(sp.geterror_FirstName().get(1).getText(), "What’s your name?");
		
		
	}
	
	
//@Test
	
	public void pageAssertion() throws IOException
	{
		
		LandingPage lp = new LandingPage(driver);
		SignUpPage sp =lp.getLogin();		
		sp.getfirstName().sendKeys(prop.getProperty("firstname1"));
		sp.getlastName().sendKeys(prop.getProperty("lastname1"));
		sp.getemail().sendKeys(prop.getProperty("email1"));
		sp.getpassword().sendKeys(prop.getProperty("password1"));
		Assert.assertEquals(4<3, "Assert failed");
		sp.getwebSubmit().click();
		
	}
}
