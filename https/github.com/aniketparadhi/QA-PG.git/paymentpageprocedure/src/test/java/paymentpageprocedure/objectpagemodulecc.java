package paymentpageprocedure;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class objectpagemodulecc extends payoptionCreditcard
{
	  /*--------------------------Creditcard------------------------ */
	@FindBy(how = How.XPATH, using = "(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control cardNumber undefined-icon')])[1]")	
	static WebElement CC;
	@FindBy(how =How.XPATH, using ="(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control exp_date')])[1]")
		static WebElement expdate;
	@FindBy(how =How.XPATH, using ="(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control cvv')])[1]")
	static WebElement Cvv;
	@FindBy(how = How.XPATH, using="//input[@class='btn submit-credit-dtls']")
	static WebElement subtn;
	  /*--------------------------Creditcard------------------------ */
	@FindBy(how = How.XPATH, using = "(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control cardNumber undefined-icon')])[1]")
	  static WebElement CC1;
	@FindBy(how =How.XPATH, using ="(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control exp_date')])[1]")
		static WebElement expdate1;
	@FindBy(how =How.XPATH, using ="(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control cvv')])[1]")
	static WebElement Cvv1;
	@FindBy(how = How.XPATH, using="//input[@class='btn submit-debit-dtls']")
	static WebElement subtn1;
}