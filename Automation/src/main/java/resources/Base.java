package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	public WebDriver driver ;
	public Properties pro;
public WebDriver initializeDriver() throws IOException
{

pro = new Properties();
FileInputStream fis = new FileInputStream("C:\\Eclipse\\E2EProject\\src\\main\\java\\resources\\data.properties");
pro.load(fis);
String browserName = pro.getProperty("browser");

if(browserName.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	 driver = new ChromeDriver();
}
else if(browserName.equals("firefox"))
{
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	 driver = new ChromeDriver();
}
else
{
	System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
     driver = new InternetExplorerDriver();
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}
	public void getScreenShotpath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationfile ));
	}
	
}
