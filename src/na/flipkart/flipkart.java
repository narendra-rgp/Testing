package na.flipkart;


import java.io.IOException;

import org.testng.annotations.Test;

import nari.framework.CommonMethods;
import nari.framework.Data;
import nari.framework.Data_Utils;
import nari.framework.EventMethods;
import nari.framework.BaseClass;
import nari.framework.flipkartData;

public class flipkart  extends BaseClass{
	
	@Test(enabled = true)
	public static void add_cart() throws IOException, InterruptedException {
		
		CommonMethods.launch_Application("firefox",flipkartData.Url);
		Data_Utils.Excel(System.getProperty("user.dir")+"\\Test-Data\\Sample.xlsx","Sheet1", "TC_01");
		Thread.sleep(3000);
		
		//EventMethods.clickButton(flipkartData.login_click, 30);
		EventMethods.enterValue(flipkartData.user_name, Data.hm.get("UserName"), 60);
		EventMethods.enterValue(flipkartData.password, Data.hm.get("Password"), 50);
		EventMethods.clickButton(flipkartData.login_btn, 30);
		Thread.sleep(3000);
		writeLog("pass", "Login", "Login Sucessfully");
		writeLog("fail", "Login", "Login UnSucessfully");
		EventMethods.enterValue(flipkartData.search_box, Data.hm.get("Search_Item"), 50);
		EventMethods.clickButton(flipkartData.sub_search, 50);
		EventMethods.list_value(flipkartData.search_list, Data.hm.get("Color")+", "+Data.hm.get("Size") , 40);
		//EventMethods.switch_Window();
		//EventMethods.clickButton(flipkartData.add_to_cart, 20);
		Thread.sleep(3000);
		//EventMethods.clickButton(flipkartData.place_order, 50);
		//writeLog("pass", "Place Order", "Your item Sucessfully Placeed..!");
		
	}
	@Test
	public static void remove_item() throws InterruptedException, IOException {
		CommonMethods.launch_Application("chrome",flipkartData.Url);
		Data_Utils.Excel(System.getProperty("user.dir")+"\\Test-Data\\Sample.xlsx","Sheet1", "TC_01");
		Thread.sleep(3000);
		
		//EventMethods.clickButton(flipkartData.login_click, 30);
		EventMethods.enterValue(flipkartData.user_name, Data.hm.get("UserName"), 60);
		EventMethods.enterValue(flipkartData.password, Data.hm.get("Password"), 50);
		EventMethods.clickButton(flipkartData.login_btn, 30);
		Thread.sleep(3000);
		EventMethods.clickButton(flipkartData.cart, 20);
		//EventMethods.clickButton(flipkartData.remove_btn, 20);
	}
}
