package testPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagePackage.HomePage;
import pagePackage.LoginPage;

@Listeners(CustomListner.class)// to make the Customlistner class listen to our test script
public class TestActiTimeValidLogin extends BaseTest {
	
	@Test
	public void testActiTimeValidLogin() throws IOException, InterruptedException
	{
	
		
		Flib flib = new Flib();	
		LoginPage lp = new LoginPage(driver);
	    WebDriverCommonLib.verifyTheTitle("actiTIME - Login", "login Page");
		
		lp.actitimeValidLogin(flib.readPropertyData(PROP_PATH, "username"), flib.readPropertyData(PROP_PATH, "password"));
		String actualHomePageTitle = WebDriverCommonLib.getTheTitleOfTheWebPage("current");
		Assert.assertEquals(actualHomePageTitle, "actiTIME - Enter Time-Track");
		
		
		
		HomePage hp = new HomePage(driver);
		WebElement element = hp.getEnterTimeTrack();
		
		boolean statusOfEnterTimeTrack = element.isDisplayed();
		if(statusOfEnterTimeTrack)
		{
			flib.writeExcelData(EXCEL_PATH, "validcredentials", 1, 2, "pass");
			
		}
		
		else
		{
			flib.writeExcelData(EXCEL_PATH, "validcredentials", 1, 2, "fail");
		}
	
		
		
		
	}
	
	

}
