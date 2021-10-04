package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverFactory;
import cucumber.api.java.en.Then;

public class HomePage {
	@FindBy(id="welcome")
	WebElement welcome;

	@FindBy(id="menu_admin_viewAdminModule") 
	WebElement admin;
	
	private WebDriverWait wait;

		
 public HomePage() {
		PageFactory.initElements(WebDriverFactory.localchrome.get(), this);
		wait=new WebDriverWait(WebDriverFactory.localchrome.get(), 20);
	}
 
   @Then("user should be able to see {string} message")
	public HomePage display(String welc) {
		Assert.assertEquals(welcome.getText(), welc, "welcome not display");

		return this.ispageLoded();
	}
	
   @Then("user nevigate to admin page")
	public AdminPage adminguid() {
		admin.click();
		return new AdminPage();
	}
	
	public HomePage ispageLoded() {
		wait.until(ExpectedConditions.visibilityOf(admin));
		return this;
	}

}
