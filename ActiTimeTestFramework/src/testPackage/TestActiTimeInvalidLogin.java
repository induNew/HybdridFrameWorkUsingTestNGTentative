package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import pagePackage.LoginPage;
@Listeners(CustomListner.class)
public class TestActiTimeInvalidLogin extends BaseTest {
	
	
	@Test
	public void actiTimeInvalidLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		int rc = flib.getTheRowCount(EXCEL_PATH, "invalidcredentials");
		for(int i=1;i<=rc;i++)
		{
		String un = flib.readExcelData(EXCEL_PATH, "invalidcredentials", i, 0);//reading the invalid username
		String pwd = flib.readExcelData(EXCEL_PATH, "invalidcredentials", i, 1);//reading the invalid password
		lp.actitimeinValidLogin(un, pwd);

		String currentTitle = WebDriverCommonLib.getTheTitleOfTheWebPage("current");
		
		Assert.assertEquals(currentTitle, "actiTIME - Login");
		flib.writeExcelData(EXCEL_PATH, "invalidcredentials", i, 2, "pass");//write the data in excel file
		

		
	
		
		}
	}

}
