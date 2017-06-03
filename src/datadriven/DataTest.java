package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest 
{
	@Test(dataProvider="wordpress")
public void loginwordpree(String username,String password) throws InterruptedException
{
    System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Webdriver\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(4000);
	driver.get("https://wordpress.com/wp-login.php");
	driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys(username);
	driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
	driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
	Thread.sleep(4000);
	System.out.println(driver.getTitle());
	driver.quit();
	
}
	@DataProvider(name="wordpress")
	public Object [] [] passData()
	{
		Object [][] data=new Object[3][2];
		
		data[0][0]="admin1";
		data[0][1]="demo1";
		
		data[1][0]="admin";
		data[1][1]="demo123";
		
		data[2][0]="admin2";
		data[2][1]="demo1234";
		
		return data;
		
		
	
	}
	
	
	
	
}

