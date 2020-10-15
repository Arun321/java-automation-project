package ddt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.exceldataconfig;

public class register {
	
	WebDriver driver;
	
	@Test(dataProvider="shaadiData")
	public void registerToShaadi(String email,String password) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Java_Selenium\\dataexcel\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.marathishaadi.com/");
		
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[1]/div[2]/div/div/form/div/div[3]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[7]/form/div[2]/div[1]/input")).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[7]/form/div[2]/div[2]/input")).sendKeys(password);
			//Thread.sleep(2000);
			
			//Select from DropDown
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//*[@id=\"___gatsby\"]/div/div[7]/form/div[2]/div[3]/div/div/div[1]")).click();
		    Thread.sleep(3000);
		 	
			Assert.assertTrue(driver.getTitle().contains("Marathi Matrimony & Matrimonial site | Marathi Shaadi.com"),"User is not able to register");
			System.out.println("User is able to register");
			Thread.sleep(3000);	
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@DataProvider (name="shaadiData")
	public Object[][] passData()
	{
		exceldataconfig config = new exceldataconfig("C:\\Users\\user\\Desktop\\Java_Selenium\\dataexcel\\TestData\\InputData.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data = new Object[rows][2];
		
		for(int i=0 ; i<rows ; i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			
		}
		
		return data;
	}
}
