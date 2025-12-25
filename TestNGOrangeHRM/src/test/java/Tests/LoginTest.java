package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import Base.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	
	//Verify URL
	@Test(priority=1)
	public void VerifyURL() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			wait.until(ExpectedConditions.titleContains("login"));
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("login"),"URL not contains");
	}
	
	//Verify Logo is visible
	@Test(priority=2)
	public void Verify_LogoIsVisible_in_login() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"orangehrm-login-branding\"]")));
		}catch(Exception e) {
			e.getStackTrace();
		}
			
	}
	
	//Verify Login Valid Credentials
	@Test(priority=3)
	public void Login_ValidCredentials() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		lp.Enter_Username("Admin");
		Thread.sleep(1000);
		
		lp.Enter_password("admin123");
		Thread.sleep(1000);

		lp.Click_Login_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Dashboard"), "This page does not contains Dashboard.");
		
		
		lp.Click_Profile_Button();
		Thread.sleep(1000);
		
		lp.Click_Logout_Button();
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	
	//Verify Login InValid Credentials
	@Test(priority=4)
	public void Login_InValidCredentials() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		lp.Enter_Username("Admin");
		Thread.sleep(1000);
		
		lp.Enter_password("admin12223");
		Thread.sleep(1000);

		lp.Click_Login_btn();
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String error = lp.Get_Error_Message();
		Assert.assertTrue(error.contains("Invalid credentials"),
		        "Does not contain Invalid credentials");
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		

	}
	
	
	//Verify Login Empty Credentials
	@Test(priority=5)
	public void Login_EmptyCredentials() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.Click_Login_btn();
		Thread.sleep(1000);
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Required"),"Does not contains Required.");
	}
	
	//Verify Forgot password link
	@Test(priority=6)
	public void Verify_Forgot_password_link() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		lp.Click_Forgot_password_link();
		Thread.sleep(1000);
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("requestPasswordResetCode"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Reset Password"),"The page does not contains Reset Password.");				
	
	}
	
}



