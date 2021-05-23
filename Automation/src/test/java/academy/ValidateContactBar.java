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

public class ValidateContactBar extends Base
{
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(pro.getProperty("url"));
		
	}

	@Test
	public void basePageNavigation() 
	{
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getContactbar().isDisplayed());
		Log.info("Contact bar displayed succesfully");
	}
		
	@AfterTest
	public void teardown()
	
		{
			driver.close();
			
		}
		
		
}

	

