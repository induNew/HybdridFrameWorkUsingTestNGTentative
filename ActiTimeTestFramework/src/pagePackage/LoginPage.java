package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	//declaration

	@FindBy(name="username") private WebElement usn;
	@FindBy(name="pwd") private WebElement pass;
	@FindBy(id="loginButton") private WebElement loginBtn;
	@FindBy(xpath="//img[contains(@src,'timer')]") private WebElement logo;


	//Initialization
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	
	//utilization

	public WebElement getUsn() {
		return usn;
	}


	public WebElement getPass() {
		return pass;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public WebElement getLogo() {
		return logo;
	}
	
	
	//generic reusable method
	
	public void actitimeValidLogin(String validUsername,String validPassword) throws InterruptedException
	{
		usn.sendKeys(validUsername);
		pass.sendKeys(validPassword);
		Thread.sleep(2000);
		loginBtn.click();
		
		
	}
	
	public void actitimeinValidLogin(String invalidUsername,String invalidPassword) throws InterruptedException
	{
		usn.sendKeys(invalidUsername);
		pass.sendKeys(invalidPassword);
		Thread.sleep(4000);
		
		loginBtn.click();
		Thread.sleep(2000);
		usn.clear();
		
		
	}

	
	






}
