package datadriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGData
{
	public static WebDriver driver;
	@Test (priority=1)
public void launcebrowser()
{
		 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Webdriver\\geckodriver.exe");
			 driver =new FirefoxDriver();
			
}
	@Test (priority=2)
	public void verifyTitle()
	{
		driver.get("https://www.google.com");
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Google", pageTitle);
	}
	@Test (priority=3)
	public void yahootitle()
	{
		driver.get("https://www.yahoo.com/");
		String pageTitle2=driver.getTitle();
		Assert.assertEquals("Yahoo", pageTitle2);
		
		
	}
	
	@Test (priority=4)
	
	public void closeBrowser()
	{
		
		driver.quit();
	}
}
