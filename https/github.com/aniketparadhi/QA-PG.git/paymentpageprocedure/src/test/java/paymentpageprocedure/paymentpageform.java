package paymentpageprocedure;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.codec.language.bm.*;
import org.apache.commons.lang3.RandomStringUtils;

public class paymentpageform extends objectpagemoduleinit
{
	@DataProvider(name = "init")
	public String[][] createData1() throws InterruptedException 
{
	String[][] retObjArr=null;
	 
		try {
				retObjArr = dataobj("C:\\Users\\aniket.paradhi\\eclipse-workspace\\src\\Resources\\Testingdata.xls","datasheet");
			} 
		catch (Exception e) 
			{
				System.out.println("Exception occured while reading the excel");
				e.getMessage();
			}
	return (retObjArr);
}
  @Test(dataProvider = "init")
  public static void formfilling(String URL, String emailid, String phn, String fname, String lname, String pncde, String amt, String ccard, String date, String cvv)
  {
	  PageFactory.initElements(driver, objectpagemoduleinit.class);
	  driver.get(URL);
	  Assert.assertEquals(URL, URL, "URL is Proper...");
	  email.sendKeys(emailid);
	  phone.sendKeys(phn);
	  frstname.sendKeys(fname);
	  lstname.sendKeys(lname);
	  pincode.sendKeys(pncde);
	  String s = RandomStringUtils.randomAlphanumeric(8);
	  orderid.sendKeys(s);
	  amount.clear();
	  amount.sendKeys(amt);
	  btnsbmt.click();
  }
}