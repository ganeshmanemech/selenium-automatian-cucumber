package common;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
//	public WebDriver chrome;
	public static ThreadLocal<WebDriver>localchrome=new ThreadLocal<>();

}
