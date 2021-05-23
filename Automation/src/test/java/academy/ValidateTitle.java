package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base
{
	public WebDriver driver;
 public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		driver.get(pro.getProperty("url"));
		Log.info("Navigated to homepage");
	}
	@Test
	public void basePageNavigation() 
	{
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.gettitle().getText(), "FEATURED132COURSES");
		Log.info("Succcessfully validated text message");
	}
	@AfterTest
	public void teardown()
	{
	driver.close();	
		
	}
}
