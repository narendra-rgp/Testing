package nari.framework;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Data {
	public static ThreadLocal< WebDriver> th = new ThreadLocal<>();
	public static void set(WebDriver driver) {
		th.set(driver);
	}
	public static WebDriver get() {
		return th.get();
	}
	public static  WebDriver driver=null;
	
	public static HashMap<String , String>	hm;
	
	public static final String URL="https://www.primevideo.com/";
	
	public static final By amazon_sign_in=By.xpath("//span/a[text()='Sign In']");
	public static final By a_create_button=By.xpath("//span/a[@id='createAccountSubmit']");
	public static final By a_enter_name=By.xpath("//*[@name='customerName']");
	public static final By a_email_id=By.xpath("//*[@name='email']");
	public static final By a_password=By.xpath("//*[@name='password']");
	public static final By a_rpassword=By.xpath("//*[@name='passwordCheck']");
	public static final By a_signIn_button=By.xpath("//*[@type='submit']");
	public static final By a_rsidnIn_button=By.xpath("//*[@id='continue']");
	public static final By a_otp_button=By.xpath("//*[@type='submit']/following-sibling::span[text()='Create your Amazon account']");
	
	
	

}
