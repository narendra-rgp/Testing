package nari.framework;

import org.openqa.selenium.By;


public class paytmData extends BaseClass{
	
	public static final String url="https://paytm.com/";
	public static final By frame=By.xpath("//*[@title='Close']/following-sibling::div/following::iframe");
	
	public static final By signin=By.xpath("//*[text()='Log In/Sign Up']");
	
	public static final By  frame_signin=By.xpath("//*[text()='Login/Signup with mobile number and password']");
	
	public static final By mobile_number=By.xpath("//*[@name='username']");
	
	public static final By password=By.xpath("//*[@name='password']");
	
	public static final By login_btn=By.xpath("//*[@class='md-raised md-primary btn-new mt-20 login-btn md-button ng-scope md-default-theme']");
	
	public static final By verify =By.xpath("//*[@type='submit']");
	
	public static final By mob_prepaid =By.xpath("//*[text()='Mobile Prepaid']");
	
	public static final By mob_number =By.xpath("//*[@type='tel']");
	
	public static final By mob_amount=By.xpath("(//*[@type='text'])[3]");
	
	public static final By mob_rech_button = By.xpath("//*[text()='Proceed to Recharge']");
	
	public static final By pr_rech_button = By.xpath("//li/button");

}
