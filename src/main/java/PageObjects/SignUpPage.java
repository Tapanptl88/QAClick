package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	public WebDriver driver;
	
	@FindBy(name="firstname")
	public WebElement firstName;
	
	@FindBy(name="lastname")
	public WebElement lastName;
	
	@FindBy(name="reg_email__")
	public WebElement email;
	
	@FindBy(id="password_step_input")
	public WebElement password;
	
	@FindBy(name="websubmit")
	public WebElement webSubmit;
	
	@FindBy(id="month")
	public WebElement month;
	
	@FindBy(id="day")
	public WebElement day;
	
	@FindBy(id="year")
	public WebElement year;
	
	@FindBy(xpath = "//span[@class='_5k_2 _5dba']")
	public List<WebElement> gender;
	
	@FindBy(xpath="//div[@class='_5v-0 _53im']/div[1]")
	public List<WebElement> error_FirstName;
	
	
	public SignUpPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}

	public WebElement getfirstName()
	{
		return firstName;
		
	}
	
	public WebElement getlastName()
	{
		return lastName;
	}
	
	public WebElement getemail()
	{
		return email;
	}
	
	public WebElement getpassword()
	{
		return password;
	}
	
	public WebElement getwebSubmit()
	{
		return webSubmit;
	}
	
	
	public WebElement getMonth()
	{
		return month;
	}

	public WebElement getDay()
	{
		return day;
	}

	public WebElement getYear()
	{
		return year;
	}

	public List<WebElement> getGender()
	{
		return gender;
	}

	public List<WebElement> geterror_FirstName()
	{
		return error_FirstName;
	}

	
}
