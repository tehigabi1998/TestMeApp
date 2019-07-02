package seleniumdemo01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo5 {
	
	WebDriver driver;
	private int flag;
	
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("userName")).sendKeys("Admin");
	  driver.findElement(By.id("password")).sendKeys("Password456");
	  driver.findElement(By.name("Login")).click();
	  
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[4]/button")).click();
	  WebElement category = driver.findElement(By.xpath("//*[@id=\"categorydropid\"]"));
	  
	  Select s=new Select(category);
	  List<WebElement> values= s.getOptions();
	  for(WebElement e:values)
	  {
		  String options=getText();
		  if(options.equals("Electronics"))
		  {
			  s.selectByVisibleText(options);
			  flag=1;
			  break;
		  }
	  }
	  if (flag==1)
	  {
		  WebElement subCategory = driver.findElement(By.xpath())
	  }
	  
	  
	  
  }


private String getText() {
	// TODO Auto-generated method stub
	return null;
}
}
