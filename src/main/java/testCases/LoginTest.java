package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSelenium;
import common.IInvokedMethodImpl;
import pages.LoginPage;

@Listeners(IInvokedMethodImpl.class)
public class LoginTest{
	@Test
	public void VerifyLoginSuccesfullwithValidUsernamePassword() {
		LoginPage lp = new LoginPage();
		lp.nevigateToOrangeHRMUrl()
		.loginMethod("Admin", "admin123")
		.display("Welcome poovarasuHector");

	}
}