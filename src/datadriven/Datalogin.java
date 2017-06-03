package datadriven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datalogin {
	WebDriver driver;
	@Test(dataProvider="wordpress")
	public void loginwordpree(String username,String password) throws InterruptedException
	{
	    System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Webdriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		 driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		Thread.sleep(4000);
		
		String msg = driver.findElement(By.xpath(".//*[@id='u_0_4']/div[1]/div[1]/div/a/span")).getText();
		
		Assert.assertTrue(msg.equalsIgnoreCase("Proshanta"));
		
	//	Assert.assertEquals("proshanta mallik ayon", "proshanta mallik ayon");
   //	Assert.assertTrue(driver.getTitle().contains(""), "User is not able to login");
		System.out.println("Page title verified.User is able to login succesfully");
	}
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	@DataProvider(name="wordpress")
	public Object [] [] passData() throws IOException
	{
		
		String str = "C:\\Users\\samsung\\Desktop\\alldata\\Book1.xlsx";
		
		ExcelDataConfig config= new ExcelDataConfig ();
		Sheet sht = config.getSheetObject(str);
		int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();
		
		Object [] [] data=new Object [4] [2];
		
		for (int i = 0; i < rowCount+1; i++)
		{

	        Row row = sht.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++)
	        {

	            //Print Excel data in console

	            data[i][j]=row.getCell(j).getStringCellValue();

	        }
	        
		}		
				return data;
				
	}
		

}
