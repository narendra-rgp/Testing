package na.flipkart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import nari.framework.BaseClass;
import nari.framework.CommonMethods;
import nari.framework.Data;

public class Sam extends BaseClass{
	
	@Test
	public static void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		Data.driver = new ChromeDriver();
		Data.driver.get("https://www.google.com/");
		Thread.sleep(5000);
		Data.driver.get("https://www.google.com/");
		Thread.sleep(5000);
		Data.driver.navigate().to("https://www.fb.com/");
	}

}
