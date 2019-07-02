package seleniumdemo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class excel1 
{
	WebDriver driver;
  @Test
  public void readExcelSetofdata() throws IOException 
  {
	  File src=new File("C:\\Users\\a08019dirp_c2x.08.05\\Desktop\\Excel1.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  String Data1=sheet1.getRow(0).getCell(0).getStringCellValue();
	  String Data2=sheet1.getRow(0).getCell(1).getStringCellValue();
	  
	  System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys(Data1);
	  driver.findElement(By.name("password")).sendKeys(Data2);
	  driver.findElement(By.name("Login")).click();
	  
	  
	  
	 
	  
	  
	  
	  
  }
}
