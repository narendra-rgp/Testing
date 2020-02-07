package na.Prime;


import nari.framework.CommonMethods;
import nari.framework.Data;
import nari.framework.EventMethods;
import nari.framework.BaseClass;

public class amazonPrime extends BaseClass {
	
	public static void new_User() throws InterruptedException {
		CommonMethods.launch_Application("chrome", Data.URL);
		EventMethods.clickButton(Data.amazon_sign_in, 20);
		EventMethods.clickButton(Data.a_create_button, 20);
		EventMethods.enterValue(Data.a_enter_name, "narendra", 20);
		EventMethods.enterValue(Data.a_email_id, "n@gmail.com", 20);
		EventMethods.enterValue(Data.a_password, "123456", 20);
		EventMethods.enterValue(Data.a_rpassword, "123456", 20);
		EventMethods.clickButton(Data.a_signIn_button, 20);
		Thread.sleep(50000);
		EventMethods.clickButton(Data.a_rsidnIn_button, 20);
		Thread.sleep(500000);
		EventMethods.clickButton(Data.a_otp_button, 20);
		
		
	}

}
