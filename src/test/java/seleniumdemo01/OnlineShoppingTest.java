package seleniumdemo01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OnlineShoppingTest {
	
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest logger;

       @BeforeTest
	public void startReportBeforeTest()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		htmlreporter=new ExtentHtmlReporter(path);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);

        extent.setSystemInfo("host name", "GFT TESTING");
		extent.setSystemInfo("environment", "SELENIUM");
		extent.setSystemInfo("user name", "TEAM_3");
		
		htmlreporter.config().setDocumentTitle("TITLE OF THE REPORT");
		htmlreporter.config().setReportName("Test Me App Report");
	    htmlreporter.config().setTheme(Theme.DARK);
		}
	
	@BeforeClass
	public void beforeclass()
	{
		System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		
		}
	
	
//	 @Test
//	    public void pass1()
//	    {
//	    	logger=extent.createTest("passTest");
//			logger.log(Status.INFO,"pass test started");
//			driver.findElement(By.name("userName")).sendKeys("Lalitha");
//			driver.findElement(By.id("password")).sendKeys("Password");
//			driver.findElement(By.name("Login")).click();
//			Assert.assertTrue(true);
	    	
	    //}
	
	@Test
    public void fail1()
    {
    	logger=extent.createTest("Fail Test");
    	logger.log(Status.INFO,"fail test started");
    	driver.findElement(By.name("userName")).sendKeys("gabitehi2");
		driver.findElement(By.id("pass")).sendKeys("aishnikk");
		driver.findElement(By.name("Login")).click();
		Assert.assertTrue(false);
    	
     }
       @Test(priority=2)
	public void testLogin()  
	{
        logger=extent.createTest("passTest");
		logger.log(Status.INFO,"pass test started");
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
	    Assert.assertTrue(true);
		
	}
	@Test(priority=3)
	public void testCart()
	{
                
        logger=extent.createTest("passTest");
		logger.log(Status.INFO,"pass test started");
        
		driver.findElement(By.xpath("//*[@id=\"myInput\"]")).sendKeys("carpet");
		driver.findElement(By.xpath("/html/body/div[1]/form/input")).click(); //finddetails click
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click(); //addtocart click
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")).click(); //cart button
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		Assert.assertTrue(true);
	}
	@Test(priority=4)
	public void testPayment()
	{
      logger=extent.createTest("passTest");
	  logger.log(Status.INFO,"pass test started");
      driver.findElement(By.xpath("//*[@id=\'header\']/div[1]/div/div/div[2]/div/a[2]")).click();//clicking cart option
	  driver.findElement(By.xpath("//*[@id=\'cart\']/tfoot/tr[2]/td[5]/a")).click();//checkout 
	  driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();//proceed to pay
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //wait statement
	  driver.findElement(By.xpath("//*[@id=\'swit\']/div[2]/div/label/i")).click();//bank selection
	  driver.findElement(By.xpath("//*[@id=\'btn\']")).click();//continue option
	  driver.findElement(By.name("username")).sendKeys("gabitehi2");
	  driver.findElement(By.name("password")).sendKeys("aishnikk");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	}
    @Test(priority=1)
    public void testRegistration()
    {
          
      logger=extent.createTest("passTest");
	  logger.log(Status.INFO,"pass test started");
      driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
	  driver.findElement(By.name("firstName")).sendKeys("lalitha");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  String a= driver.findElement(By.xpath("//*[@id=\"err\"]")).getText(); 
	  if(a.equals("Available"))
	  {
	  
	  driver.findElement(By.name("lastName")).sendKeys("lalitha");
	  driver.findElement(By.name("password")).sendKeys("Password123");
      driver.findElement(By.name("confirmPassword")).sendKeys("Password123");
	  driver.findElement(By.xpath("//*[@id=\"gender\"]")).click();
	  driver.findElement(By.name("emailAddress")).sendKeys("lalitha@gmail.com");
	  driver.findElement(By.name("mobileNumber")).sendKeys("1234567898");
	  driver.findElement(By.name("dob")).sendKeys("09/05/1997");
	  driver.findElement(By.name("address")).sendKeys("fghfhrytyrwtp");
	  WebElement qstn=driver.findElement(By.id("securityQuestion"));
	  Select s=new Select(qstn);
	   List <WebElement> values=s.getOptions();
	   for(WebElement e:values)
	   {
	    String  option = e.getText();
	    if (option.equals("What is your favour color?"))
	    {
	    s.selectByVisibleText(option);
	  		    break;
	    }
	   }
	   driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("Black");
	   
	   driver.findElement(By.name("Submit")).click();
	   Assert.assertTrue(true);

	  
	  }
	  else
	  {
		  
		 driver.findElement(By.name("userName")).sendKeys("gabitehi3"); 
		 driver.findElement(By.name("firstName")).sendKeys("aish"); 
		 driver.findElement(By.name("lastName")).sendKeys("nikkhat");
		 driver.findElement(By.name("password")).sendKeys("aishnikk");
		 driver.findElement(By.name("confirmPassword")).sendKeys("aishnikk");
		 driver.findElement(By.xpath("//*[@id='gender']")).click();
		 
		 driver.findElement(By.xpath("//*[@id=\'emailAddress\']")).sendKeys("aish@gmail.com");
		 driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9791693258");
		 driver.findElement(By.name("dob")).sendKeys("10/02/1997");
		 driver.findElement(By.name("address")).sendKeys("bsdkufgsighsiadahsdhfi");
		 driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
		  WebElement qstn=driver.findElement(By.id("securityQuestion"));
		  Select s=new Select(qstn);
		   List <WebElement> values=s.getOptions();
		   for(WebElement e:values)
		   {
		    String  option = e.getText();
		    if (option.equals("What is your favour color?"))
		    {
		    s.selectByVisibleText(option);
		  		    break;
		    }
		   }
		   driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("Black");
		   
		   driver.findElement(By.name("Submit")).click();
		   Assert.assertTrue(true);
    	
    }
    }
	
    @AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,"THE TEST IS FAILED");
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			String imagepath=System.getProperty("user.dir")+"/extent-reports/images/"+
							result.getMethod().getMethodName()+".png";
			
			try {
				FileUtils.copyFile(srcFile, new File(imagepath));
				logger.log(Status.INFO,result.getThrowable());
				logger.addScreenCaptureFromPath(imagepath,"fail test image");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"THE TEST IS PASSED");
			logger.log(Status.INFO,MarkupHelper.createLabel("THE TEST IS PASSED",ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP,"THE TEST IS SKIPPED");
		}
	}
	
	@AfterTest
	public void endReportAfterTest()
	{
	extent.flush();
	}
	
} 
    
