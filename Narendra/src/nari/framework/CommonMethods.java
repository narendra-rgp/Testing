package nari.framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class CommonMethods  {
	
	public static void launch_Application(String browsername,String Url) {
		switch (browsername.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			Data.driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			Data.driver = new FirefoxDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"Drivers\\MicrosoftWebDriver.exe");
			Data.driver = new EdgeDriver();
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"Drivers\\IEDriverServer.exe");
			Data.driver = new InternetExplorerDriver();
		default:
			Assert.assertTrue(false, "Your Enter the In Valid Browser Name:");
			break;
		}
		Data.driver.get(Url);
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	public static void take_ScreenShot(String fileName) throws IOException {
		File f=((TakesScreenshot)Data.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName+".png") );
	}
	

}
