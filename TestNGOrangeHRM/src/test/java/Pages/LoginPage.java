package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Login
	By txt_username = By.xpath("//input[@name=\"username\"]");
	By txt_password = By.xpath("//input[@name=\"password\"]");
	By btn_Login = By.xpath("//button[text()=\" Login \"]");
	By error_msg = By.xpath("//p[text()=\"Invalid credentials\"]");
	By link_forgot_password = By.xpath("//p[text()=\"Forgot your password? \"]");
	
	//Profile button
	By btn_Profile = By.xpath("//span[@class=\"oxd-userdropdown-tab\"]");
	//Logout button
	By btn_Logout = By.xpath("//a[text()=\"Logout\"]");
	
	public void Enter_Username(String uname) {
		driver.findElement(txt_username).sendKeys(uname);
	}
	public void Enter_password(String pass) {
		driver.findElement(txt_password).sendKeys(pass);
	}
	public void Click_Login_btn() {
		driver.findElement(btn_Login).click();
	}
	public String Get_Error_Message() {
		return driver.findElement(error_msg).getText();
	}
	public void Click_Forgot_password_link() {
		driver.findElement(link_forgot_password).click();
	}
	//Profile Button
	public void Click_Profile_Button() {
		driver.findElement(btn_Profile).click();
	}
	//Logout Button
	public void Click_Logout_Button() {
		driver.findElement(btn_Logout).click();
	}
}
