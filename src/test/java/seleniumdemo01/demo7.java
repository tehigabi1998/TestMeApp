package seleniumdemo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class demo7 {
  @Test
  public void f() throws IOException 
  {
	  File src=new File("C:\\Users\\a08019dirp_c2x.08.05\\Desktop\\Excel1.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  
	  sheet1.getRow(0).createCell(0).setCellValue("Admin");
	  sheet1.getRow(0).createCell(0).setCellValue("Password456");
	  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\a08019dirp_c2x.08.05\\Desktop\\Excel1.xlsx"));
	  wb.write(fout);
	  fout.close();
	  
	  
	  
	  
  }
}
