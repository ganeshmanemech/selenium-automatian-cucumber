package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginPage {
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement submit;
	
	@FindBy(id="spanMessage")
	private WebElement worning;
	
	private WebDriverWait wait;
	
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.localchrome.get(), this);
		wait=new WebDriverWait(WebDriverFactory.localchrome.get(), 30);
	}
	
	@Given("user navigate to orange hrm URL")
	public LoginPage nevigateToOrangeHRMUrl() {
		WebDriverFactory.localchrome.get().get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		return this;
	}
	@When("uses enters user name as {string} and password as {string} and click on login button")
	public HomePage loginMethod(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return new HomePage().ispageLoded();
	}
	
	
	public LoginPage loginFailedMethod(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		return this.isPageLoaded();
	}
	
	public void loginWorning(String erromsg) {
		Assert.assertEquals(worning.getText(), erromsg, "Worning msg is diffrent");
		
	}
	
	public LoginPage isPageLoaded() {
		wait.until(ExpectedConditions.visibilityOf(password));
		wait.until(ExpectedConditions.visibilityOf(username));
		return this;
	}
	

}
