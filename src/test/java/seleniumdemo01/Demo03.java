package seleniumdemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo03 {
	String ExpectedResult="Admin Home";
	WebDriver driver;
	
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("userName")).sendKeys("Admin");
	  driver.findElement(By.id("password")).sendKeys("Password456");
	  driver.findElement(By.name("Login")).submit();
	  
	  Assert.assertEquals(ExpectedResult,driver.getTitle());
	  String message=driver.findElement(By.xpath("/html/body/header/div/b")).getText();
	  Assert.assertEquals(message,"Hi, Admin    SignOut");
	  
	 
	  
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();
	  driver.findElement(By.xpath("//*[@id='catgName']")).sendKeys("Holidays"); 
	  driver.findElement(By.xpath("//*[@id='catgDesc']")).sendKeys("Bags"); 
	  driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).click();
	  driver.close();
  }
}
