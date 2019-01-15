package paymentpageprocedure;

import java.io.IOException;
import java.util.List;
import paymentpageprocedure.paymentpageform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Paymentpageoptions extends paymentpageform
{
  @Test(priority=2)
  public static void paymentpagelogo() throws IOException
  {
	  WebElement logo=driver.findElement(By.className("logo"));
	  String logotxt=logo.findElement(By.className("mer-logo-txt")).getText();
	  System.out.println("--------------------------------------------------------");
	  System.out.println(logotxt+" is the text logo.");
	  System.out.println("--------------------------------------------------------");
  }
  @Test(priority=3)
  public static void paymentpageoptionlist() throws InterruptedException
  {
	  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
	  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
	  for(int i=0; i<payoptionlist.size();i++)
	  {
		  Thread.sleep(3000);
		  String val=payoptionlist.get(i).getText();
		  String value=payoptionlist.get(i).findElement(By.className("menu-link")).getText();
		  if(val.equalsIgnoreCase(value))
		  {
			  System.out.println("--------------------------------------------------------");
			  System.out.println(val+" is correct in sequence, to verify the payment options.");
			  System.out.println("--------------------------------------------------------");
		  }
	  }
  }
}