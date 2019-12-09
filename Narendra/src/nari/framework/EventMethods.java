package nari.framework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventMethods {
	
	private static WebElement getElement(By by,int timesout) {
		WebElement e;
		try {
			WebDriverWait w = new WebDriverWait(Data.driver, timesout);
			w.pollingEvery(Duration.ofMillis(200));
			e = w.until(ExpectedConditions.presenceOfElementLocated(by));
		}catch(NoSuchElementException nse){
			e = null;
		}
		return e;
	}
	
	private static boolean isVisable(WebElement element,int timesout) {
		boolean isVisable = false;
		try {
			WebDriverWait w = new WebDriverWait(Data.driver, timesout);
			w.pollingEvery(Duration.ofMillis(200));
			w.until(ExpectedConditions.visibilityOf(element));
			isVisable = true;
		} catch (Exception e) {
			isVisable = false;
			// TODO: handle exception
		}
		return isVisable;
	}
	private static boolean isEnable(WebElement element,int timesout) {
		boolean isEnable = false;
		try {
			WebDriverWait w = new WebDriverWait(Data.driver, timesout);
			w.pollingEvery(Duration.ofMillis(200));
			w.until(ExpectedConditions.elementToBeClickable(element));
			isEnable = true;
		} catch (Exception e) {
			isEnable = false;
			// TODO: handle exception
		}
		return isEnable;
	}
	
	
	public static void clickButton(By by,int timesout) {
		WebElement e = getElement(by, timesout);
		if(e  != null) {
			
			if(isEnable(e, timesout)) {
				
				if (isVisable(e, timesout)) {
					e.click();
				}else {
					Assert.assertTrue(false, "Unable to click "+e.toString()+"is not visable for after waiting"+timesout);
				}
				
			}else {
				Assert.assertTrue(false, "Unable to click button "+e.toString()+" is not enable for after waiting"+timesout);
			}
			
		}else {
			
			Assert.assertTrue(false, "Unable to button not clickble"+e.toString()+"is not find after waiting"+timesout);
		}
	}
	
	@SuppressWarnings("null")
	public static void enterValue(By by,String message,int timesout) {
		WebElement e = getElement(by, timesout);
		
		if(e != null) {
			
			if(isVisable(e, timesout)) {
				
				if(isEnable(e, timesout)) {
					e.clear();
					e.sendKeys(message);
				}
			}else {
				Assert.assertTrue(false, "Unable to enter the value"+e.toString()+"is not visable afte waiting"+timesout);
			}
			
		}else {
			Assert.assertTrue(false, "Unable to enter the value"+e.toString()+"is not find after waiting"+timesout);
		}
	}
	
	
	public static void switchToFrame(String str,int timeout) {
		WebDriverWait w =new WebDriverWait(Data.driver,timeout );
		w.pollingEvery(Duration.ofMillis(200));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(str));
				
	}
	public static void switchToFrame(int i,int timeout) {
		WebDriverWait w =new WebDriverWait(Data.driver,timeout );
		w.pollingEvery(Duration.ofMillis(200));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(i));
				
	}
	public static void switchToFrame(By by,int timeout) {
		WebDriverWait w =new WebDriverWait(Data.driver,timeout );
		w.pollingEvery(Duration.ofMillis(200));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
				
	}
	
	public static void list_value(By by,String str,int timeout) {
		boolean flagClicked = false;
		List<WebElement> l=Data.driver.findElements(by);
		for(WebElement e:l) {
			if(e.getText().contains(str)) {
				e.click();
				flagClicked = true;
				break;
			}
		}
		if(flagClicked==true) {
			System.out.println("Clicked on element");
		}else {
			Assert.assertTrue(false, "Unable to find the your given word");
		}
			
				
	}
	
	public static void switch_Window() {
		
		Set<String> windows=Data.driver.getWindowHandles();
		for(String s: windows) {
			if(!s.equalsIgnoreCase(Data.driver.getWindowHandle())) {
				Data.driver.switchTo().window(s);
			}
		}
		
	}
	

}
