package seleniumdemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewTest {
 String ExpectedResult="selenium - Google Search";
 WebDriver driver;
 @Test
  public void login()
  {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("q")).sendKeys("selenium");
	  driver.findElement(By.name("q")).submit();
	  Assert.assertEquals("ExpectedResult", driver.getTitle());
	  driver.close();
  }
  
 
  
}
