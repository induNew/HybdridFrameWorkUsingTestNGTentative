package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//declaration
	@FindBy(xpath="//a[.='Logout']") private WebElement logout;


	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Utilization
	public WebElement getLogout() {
		return logout;
	}
	
	public void logoutActiTime() throws InterruptedException
	{
		Thread.sleep(2000);
		logout.click();
	}
	
	

}
