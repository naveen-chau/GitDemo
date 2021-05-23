package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base
{	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver =initializeDriver();
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password,String text)
	{
		driver.get(pro.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();	
		Log.info("succesfully entered login link ");
		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		Log.info(text);
		lp.getLogin().click(); 
		Log.info("succesfully tested credentials ");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3]; 
		data[0][0] = "nonrestrictreduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "Non restrcicted user";
		
		data[1][0] = "restrictreduser@qw.com";
		data[1][1] = "012345";
		data[1][2] = "restricted user";
		
		return data;
			
	}
	
	
}
