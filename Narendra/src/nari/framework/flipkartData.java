package nari.framework;

import org.openqa.selenium.By;

public class flipkartData {
	
	public static final String Url="https://www.flipkart.com/";
	
	public static final By login_click =By.xpath("//*[text()='Login & Signup']");
	
	public static final By user_name=By.xpath("(//*[@type='text'])[2]");
	
	public static final By password=By.xpath("//*[@type='password']");
	
	public static final By login_btn=By.xpath("(//*[@type='submit'])[2]");
	
	public static final By search_box=By.xpath("//*[@title='Search for products, brands and more']");
	
	public static final By sub_search=By.xpath("(//*[@type='submit'])[1]");
	
	public static final By search_list=By.xpath("//*[@class='col col-7-12']");
	
	public static final By add_to_cart=By.xpath("//*[@class='row']/li/button");
	
	public static final By place_order=By.xpath("//form/button");
	
	public static final By cart= By.xpath("//a/span[text()='Cart']");
	
	public static final By remove_btn = By.xpath("//div[text()='Remove']");

}
