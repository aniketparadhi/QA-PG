	package paymentpageprocedure;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class netbank extends paymentpageform
{
  @Test(dataProvider="init",priority=2)
  public static void netbanks(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String ccard, String date, String cvv) throws InterruptedException, IOException 
  {
	  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
	  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
	  payoptionlist.get(2).click();
	  ppbank(URL, emailid, phn, fname, lname, pncde, amt, ccard, date, cvv);
	  banklisting(URL, emailid, phn, fname, lname, pncde, amt, ccard, date, cvv);
  }
  public static void ppbank(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String ccard, String date, String cvv) throws InterruptedException, IOException
  {
	  String ppbank1=driver.findElement(By.xpath("//div[@class='blockMain blockNetBanking net-banking-tab']//following-sibling::h3")).getText();
	  System.out.println("-------------------------------------------------------------");
	  System.out.println("Heading is " +"'"+ppbank1+"'");
	  System.out.println("-------------------------------------------------------------");
	  WebElement ppbankmenu=driver.findElement(By.xpath("//ul[@class='blocklist popularBanks']"));	
	  List <WebElement> ppbanklist=ppbankmenu.findElements(By.tagName("li"));
	  for(int i=0; i<ppbanklist.size(); i++)
	  {
		  ppbanklist.get(i).click(); 
		  driver.findElement(By.xpath("//div[@class='blockMain blockNetBanking net-banking-tab']//following::input[contains(@class,'btn')]")).click();
		  Thread.sleep(6000);	
		  getScreenShot();
		  if(driver.getCurrentUrl().equalsIgnoreCase("https://staging-payments.airpay.co.in/pay/index.php#"))
		  {
			  driver.findElement(By.xpath("//div[(@id='main-message')]//following-sibling::span"));
			  String errorquote=driver.findElement(By.xpath("//div[(@id='main-message')]//following-sibling::span")).getText();
			  System.out.println(errorquote);
			  getScreenShot();
			  driver.quit();
		  }
		  else
		  {
		  formfilling(URL, emailid, phn, fname, lname, pncde, amt, ccard, date, cvv);
		  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
		  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
		  payoptionlist.get(2).click();
		  ppbankmenu=driver.findElement(By.xpath("//ul[@class='blocklist popularBanks']"));
		  ppbanklist=ppbankmenu.findElements(By.tagName("li"));
		  }
	  }
  }
  public static void banklisting(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String ccard, String date, String cvv) throws InterruptedException, IOException
  {
	  WebElement banklist=driver.findElement(By.name("nbbank_select"));
	  Select so= new Select(banklist);
	  System.out.println(so.getOptions().size());
	  for(int i=1; i<so.getOptions().size();i++)
	  {
		  System.out.println("-------------------------------------------------------------");
		  so.getOptions().get(i).getText();
		  System.out.println(so.getOptions().get(i).getText());
		  so.getOptions().get(i).click();
		  driver.findElement(By.xpath("//div[@class='blockMain blockNetBanking net-banking-tab']//following::input[contains(@class,'btn')]")).click();
		  Thread.sleep(6000);	
		  getScreenShot();
		  if(driver.getCurrentUrl().equalsIgnoreCase("https://staging-payments.airpay.co.in/pay/index.php#"))
		  {
			  driver.findElement(By.xpath("//div[(@id='main-message')]//following-sibling::span"));
			  String errorquote=driver.findElement(By.xpath("//div[(@id='main-message')]//following-sibling::span")).getText();
			  System.out.println(errorquote);
			  getScreenShot();
			  driver.quit();
		  }
		  else 
		  {
		  System.out.println(driver.getCurrentUrl());
		  if(driver.getCurrentUrl().equalsIgnoreCase("https://payments.airpay.co.in/error.php"))
		  {
			  Thread.sleep(4500);
			  String error=driver.findElement(By.xpath("//span[(@class='alert alert-error')]")).getText();
			  System.out.println(error);
			  System.out.println("-------------------------------------------------------------");
			  System.out.println("-------------------------------------------------------------");
		  }
			  formfilling(URL, emailid, phn, fname, lname, pncde, amt, ccard, date, cvv);
			  Thread.sleep(4500);
			  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
			  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
			  payoptionlist.get(2).click();
			  banklist=driver.findElement(By.name("nbbank_select"));
			  so= new Select(banklist);
			  Thread.sleep(3500);
		 }
	  }
  }
}