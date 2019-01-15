package paymentpageprocedure;

import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.maven.surefire.shade.common.org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class init 
{
  public static Logger Log = Logger.getLogger(org.apache.commons.logging.Log.class.getName());
  static ExtentTest test;
  static ExtentReports report;
  static WebDriver driver;
  @BeforeSuite
  public void beforeSuite() throws IOException 
  {
		String exepath="C:\\Users\\support\\eclipse-workspace\\login\\src\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exepath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  @AfterSuite
  public static void afterSuite() throws IOException 
  {
	//driver.quit();
  }
   static void getScreenShot() throws IOException{
      DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
      Date date = new Date();
      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("C:\\Users\\aniket.paradhi\\eclipse-workspace\\src\\Resources\\SS\\"+dateFormat.format(date)+".png"));
  }
  public static String[][] dataobj(String Filepath, String SheetName) throws IOException
  {	 
	 File file=new File(Filepath); 
	 FileInputStream fs=new FileInputStream(file);
	 HSSFWorkbook wb=new HSSFWorkbook(fs);
	 Sheet sh=wb.getSheet(SheetName);
	 Row row = null;
	 DataFormatter df=new DataFormatter();
	 String col=null;
	 int rowcount=sh.getPhysicalNumberOfRows();
	 int colcount=sh.getRow(0).getLastCellNum();
	 String[][] Arraytable=new String[rowcount][colcount];
	 for (int i = 0; i <rowcount; i++) 
	    {
	       row = sh.getRow(i);
	       for (int j = 0; j < row.getLastCellNum(); j++) 
	        {
	        	col=df.formatCellValue(row.getCell(j));
	        	Arraytable[i][j]=col;
	        }
	    }
	 return Arraytable;
  }
}