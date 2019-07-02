package seleniumdemo01;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Demo6 {
	
	WebDriver driver;
	
	
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  WebElement about=driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/a/span"));
	  
	  Actions act1=new Actions(driver);
	  act1.moveToElement(about).click().build().perform();
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/ul/li/a/span"))).click().build().perform();
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\'menu3\']/li[3]/ul/li/ul/li[2]/a/span"))).click().build().perform();
	  
	  Set<String> set=driver.getWindowHandles();
	  for (String string : set) {
		  driver.switchTo().window(string);
	  }
	  
	  driver.switchTo().frame(driver.findElement(By.name("main_page")));
	  
	  String address=driver.findElement(By.tagName("address")).getText();
	  System.out.println(address);
	  
  }
}
