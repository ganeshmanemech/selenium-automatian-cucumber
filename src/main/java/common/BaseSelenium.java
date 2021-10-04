package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSelenium {
	
	@Before
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumJava\\chromedriver.exe");
		WebDriverFactory.localchrome.set(new ChromeDriver());
		WebDriverFactory.localchrome.get().manage().window().maximize();
		WebDriverFactory.localchrome.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@After
	public void afterTest() {
		WebDriverFactory.localchrome.get().quit();
	}
}
