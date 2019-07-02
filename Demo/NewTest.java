package Demo;

import org.testng.annotations.Test;

public class NewTest {
	
WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
   driver=new ChromeDriver();
  }
}
