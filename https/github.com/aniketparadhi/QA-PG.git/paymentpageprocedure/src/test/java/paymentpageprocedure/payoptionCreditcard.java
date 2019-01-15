package paymentpageprocedure;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class payoptionCreditcard extends Paymentpageoptions
{	
  @Test(dataProvider="init", priority=1)
  public void Creditcard(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String ccard, String date, String cvv) 
  {
	  PageFactory.initElements(driver, objectpagemodulecc.class);
	  WebElement payoptionmenu=driver.findElement(By.className("menu-list"));
	  List<WebElement> payoptionlist=payoptionmenu.findElements(By.tagName("li"));
	  payoptionlist.get(0).click();
	  objectpagemodulecc.CC.clear();
	  objectpagemodulecc.CC.sendKeys(ccard);
	  objectpagemodulecc.expdate.clear();
	  objectpagemodulecc.expdate.sendKeys(date);
	  objectpagemodulecc.Cvv.clear();
	  objectpagemodulecc.Cvv.sendKeys(cvv);
	  objectpagemodulecc.subtn.click();
  }
}