package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethodImpl implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		WebDriverFactory.localchrome.get().quit();

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumJava\\chromedriver.exe");
		WebDriverFactory.localchrome.set(new ChromeDriver());
		WebDriverFactory.localchrome.get().manage().window().maximize();
		WebDriverFactory.localchrome.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		

	}
	
	
	

}
