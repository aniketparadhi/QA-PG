package paymentpageprocedure;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class objectpagemoduleinit extends init
{
	/*--------------------------loginform------------------------ */
	  @FindBy(how = How.ID, using = "buyerEmail")
	  static WebElement email;
	  @FindBy(how = How.ID, using = "buyerPhone")
	  static WebElement phone;
	  @FindBy(how = How.ID, using = "buyerFirstName")
	  static WebElement frstname;
	  @FindBy(how = How.ID, using = "buyerLastName")
	  static WebElement lstname;
	  @FindBy(how = How.ID, using = "buyerPinCode")
	  static WebElement pincode;
	  @FindBy(how = How.ID, using = "orderid")
	  static WebElement orderid;
	  @FindBy(how = How.ID, using = "amount")
	  static WebElement amount;
	  @FindBy(how = How.CLASS_NAME, using = "btn")
	  static WebElement btnsbmt;
  /*--------------------------loginform------------------------ */
}
