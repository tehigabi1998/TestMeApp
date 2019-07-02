package seleniumdemo01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoSwitchTo {
	WebDriver driver;
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://localhost:8090/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	  String alertmessage=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  System.out.print(alertmessage);
	  driver.close();
  }
}
