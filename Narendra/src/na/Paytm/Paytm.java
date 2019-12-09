package na.Paytm;

import org.testng.annotations.Test;

import nari.framework.CommonMethods;
import nari.framework.EventMethods;
import nari.framework.BaseClass;
import nari.framework.paytmData;

public class Paytm extends BaseClass{
	@Test
	public static void paytm_recharge() throws InterruptedException {
		
		
		CommonMethods.launch_Application("chrome", paytmData.url);
		EventMethods.clickButton(paytmData.signin, 20);
		
		Thread.sleep(10000);
		EventMethods.switchToFrame(paytmData.frame, 20);
		
		EventMethods.clickButton(paytmData.frame_signin, 2);
		EventMethods.enterValue(paytmData.mobile_number, "9704919828", 20);
		EventMethods.enterValue(paytmData.password, "narendra999", 20);
		EventMethods.clickButton(paytmData.login_btn, 20);
		Thread.sleep(30000);
		EventMethods.clickButton(paytmData.verify, 20);
		Thread.sleep(2000);
		EventMethods.clickButton(paytmData.mob_prepaid, 20);
		EventMethods.enterValue(paytmData.mob_number, "9704919828", 20);
		Thread.sleep(20000);
		EventMethods.enterValue(paytmData.mob_amount, "399", 20);
		EventMethods.clickButton(paytmData.mob_rech_button, 20);
		EventMethods.clickButton(paytmData.pr_rech_button, 20);
	}

}
