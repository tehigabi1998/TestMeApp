package seleniumdemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {
	String ExpectedResult="Home";
	WebDriver driver;
	
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
	  driver.findElement(By.name("password")).sendKeys("Password123");
	  driver.findElement(By.name("Login")).submit();
	  Assert.assertEquals(ExpectedResult, driver.getTitle());
	  driver.findElement(By.linkText("SignOut")).click();

	  
	  
  }
}
