package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WebDriverFactory;
import cucumber.api.java.en.Then;

public class AddUserpage {
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement EmpName;
	@FindBy(id="systemUser_userName")
	private WebElement usename;
	@FindBy(id="systemUser_password")
	private WebElement password;
	@FindBy(id="systemUser_confirmPassword")
	private WebElement repassword;
	@FindBy(id="btnSave")
	private WebElement save;
	@FindBy(id="systemUser_userType")
	private WebElement userRole;
	
	private WebDriverWait wait;
	
	public 	AddUserpage() {
		PageFactory.initElements(WebDriverFactory.localchrome.get(), this);
		wait=new WebDriverWait(WebDriverFactory.localchrome.get(), 20);
	}
	@Then("user add admin user with employ name as {string},user name {string}, passord is {string} and confirmation password is {string}")
//	public void user_add_admin_user_with_employ_name_as_user_name_passord_is_and_confirmation_password_is(String string, String string2, String string3, String string4) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
//	}
	public AdminPage addusermethod(String emp,String user,String pass,String repass) {

		EmpName.sendKeys(emp);
		usename.sendKeys(user);
		password.sendKeys(pass);
		repassword.sendKeys(repass);
		save.click();
		return new AdminPage().isPageLoaded();
	}
	
	
	public AddUserpage isPageLoaded() {
		wait.until(ExpectedConditions.visibilityOf(EmpName));
		return this;
	}

}

