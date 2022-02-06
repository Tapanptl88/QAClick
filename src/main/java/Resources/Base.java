package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	
	private static final Duration Duration = null;
	public  WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		
		 prop = new Properties();
		 String filePath = System.getProperty("user.dir")+"/src/main/java/Resources/data.properties";
		FileInputStream file = new FileInputStream(filePath);
		
		prop.load(file);
		String browserName = System.getProperty("browser");
		
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			 driver = new ChromeDriver(options);
			
		}else if(browserName.contains("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe"); 
			FirefoxOptions options = new FirefoxOptions();
			if(browserName.contains("headless"))
					options.setHeadless(true);
			 driver = new FirefoxDriver(options);
			
		}else
		{
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumJars\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}

	
	
	public String getScreenShot(String TestMethodName,WebDriver driver) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		//String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestMethodName+" "+formater.format(calendar.getTime())+".png";
		FileHandler.copy(source,new File(destinationFile));
		return destinationFile;
		
		
	}
	
	
}
