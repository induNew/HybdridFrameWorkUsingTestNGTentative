package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Flib;
import pagePackage.LoginPage;

public class TestActiTimeInvalidLogin extends BaseTest {
	
	
	@Test
	public void actiTimeInvalidLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		int rc = flib.getTheRowCount(EXCEL_PATH, "invalidcredentials");
		for(int i=1;i<=rc;i++)
		{
		String un = flib.readExcelData(EXCEL_PATH, "invalidcredentials", i, 0);
		String pwd = flib.readExcelData(EXCEL_PATH, "invalidcredentials", i, 1);
		lp.actitimeinValidLogin(un, pwd);
		
		
		
		}
	}

}
