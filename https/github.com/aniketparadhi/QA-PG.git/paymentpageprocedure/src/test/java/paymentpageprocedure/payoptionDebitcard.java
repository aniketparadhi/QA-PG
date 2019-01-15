package paymentpageprocedure;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class payoptionDebitcard extends Paymentpageoptions
{
	@DataProvider(name = "init")
public String[][] createData1() throws InterruptedException 
{
String[][] retObjArr=null;
	try {
			retObjArr = dataobj("C:\\Users\\aniket.paradhi\\eclipse-workspace\\src\\Resources\\Testingdata.xls","datasheet1");
		} 
	catch (Exception e) 
		{
			System.out.println("Exception occured while reading the excel");
			e.getMessage();
		}
return (retObjArr);
}	
  @Test(dataProvider="init", priority=1)
  public void debitcard(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String dcard, String date, String cvv) 
  {
	  PageFactory.initElements(driver, objectpagemodulecc.class);
	  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
	  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
	  payoptionlist.get(1).click();	
	  objectpagemodulecc.CC1.clear();
	  objectpagemodulecc.CC1.sendKeys(dcard);
	  objectpagemodulecc.expdate1.clear();
	  objectpagemodulecc.expdate1.sendKeys(date);
	  objectpagemodulecc.Cvv1.clear();
	  objectpagemodulecc.Cvv1.sendKeys(cvv);
	  objectpagemodulecc.subtn1.click();
  }
}