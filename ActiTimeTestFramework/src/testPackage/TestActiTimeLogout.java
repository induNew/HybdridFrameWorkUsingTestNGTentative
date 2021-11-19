package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;

public class TestActiTimeLogout extends BaseTest{
	
	//to test the logout feature
	
	@Test
	public void testActiTimeLogout() throws InterruptedException, IOException
	{
		Flib flib = new Flib();	
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.actitimeValidLogin(flib.readPropertyData(PROP_PATH, "username"), flib.readPropertyData(PROP_PATH, "password"));
	
		hp.logoutActiTime();
		
		
	}

}
