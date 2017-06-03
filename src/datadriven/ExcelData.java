package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData
{
	
    WebDriver driver;
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
	Assert.assertTrue(driver.getTitle().contains("Dashbord"),"User is not able to login-invalid credentials");
	System.out.println("Page Title verified-User is able to login successfully");
	
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	//@DataProvider(name="wordpress")
//	public <ExcelDataConfig> Object [] [] passData()
//	
//	{
//		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\samsung\\New folder\\Data_Driven\\TestData\\InputData.xlsx");
//		int rows=Config.getRowCount(0);
//		Object [][] data=new Object[rows][2];
//		
//		for(int i=0;i<rows;i++)
//		{
//			data[i][0]=config.getData(0 , i , 0);
//			data[i][1]=config.getData(0 , i , 1);
//		}
//		
//		return data;
//		
//		
//	
//	}
//	
//	
//	
//	
//
//
//
//
//		
	}

