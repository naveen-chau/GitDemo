package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
public WebDriver driver;
By signin = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
By title = By.xpath("(//div[@class='text-center'])[1]");
By contactBar = By.xpath("//a[.='Contact']");


public LandingPage(WebDriver driver)
{
this.driver = driver;	
}


public WebElement getLogin()
{
	System.out.println("github");
	System.out.println("github 123");
	return driver.findElement(signin);
}
public  WebElement gettitle()
{
	System.out.println("gi4234243");
	System.out.println("gi4234444444243");
	return driver.findElement(title);
}
public  WebElement getContactbar()
{

	return driver.findElement(contactBar);
}
}