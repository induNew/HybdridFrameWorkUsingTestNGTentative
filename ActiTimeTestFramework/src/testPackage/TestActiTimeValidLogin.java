package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Flib;

import pagePackage.LoginPage;

public class TestActiTimeValidLogin extends BaseTest {
	
	@Test
	public void testActiTimeValidLogin() throws IOException, InterruptedException
	{
	
		Flib flib = new Flib();	
		LoginPage lp = new LoginPage(driver);
		lp.actitimeValidLogin(flib.readPropertyData(PROP_PATH, "username"), flib.readPropertyData(PROP_PATH, "password"));
	
		
	}
	
	

}
