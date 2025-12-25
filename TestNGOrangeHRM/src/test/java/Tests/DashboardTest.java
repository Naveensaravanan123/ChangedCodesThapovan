package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardTest extends BaseTest {
	
	@Test(priority=1)
	public void Verify_Valid_Login_Credentials() throws InterruptedException {
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
	}
	
	
	//Verify page Title
	@Test(priority = 2)
	public void Verify_PageTitle() throws InterruptedException {		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "This page title does not contains OrangeHRM.");
		
		
	}
	
	//Verify Logo is visible
	@Test(priority = 3)
	public void Verify_LogoIsVisible() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"oxd-brand\"]")));
		}catch(Exception e) {
			e.getStackTrace();
		}
				
	}
	
	
	//Verify the Upgrade button is displayed in the navigation bar
	@Test(priority=4)
	public void Verify_Upgrade_button() throws InterruptedException {

		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement Upgrade_btn = driver.findElement(By.xpath("//button[text()=\" Upgrade\"]"));
		Assert.assertTrue(Upgrade_btn.isDisplayed(), "The Upgrade button is not displayed.");
	}
	
	//Verify the Profile button is displayed in the navigation bar
	@Test(priority=5)
	public void Verify_Profile_button() throws InterruptedException {

		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement profile_btn = driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]"));
		Assert.assertTrue(profile_btn.isDisplayed(), "The Update button is not displayed.");
	}
	
	//Verify Logged in username is displayed
	@Test(priority = 6)
	public void Verify_LoggedIn_Username_Display() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Expected Username
		String expected_username = "Admin";
		
		WebElement username_Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")));
		
		String actual_username = username_Element.getText();
		
		Assert.assertEquals(actual_username, expected_username,"Logged-in username is NOT Displayed correctly.");
			
	}
	
	
	//Verify Menus are displayed in the dashboard page are not
	@Test(priority=7)
	public void Verify_Menus_are_displayed() throws InterruptedException {

		
		//Expected Menus
		String[] expected_menus = {"Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard",
					"Directory","Maintenance","Buzz"};
		
		//Actual Menus
		List<WebElement> menu_elements = driver.findElements(By.xpath("//li[@class=\"oxd-main-menu-item-wrapper\"]"));
		
		
		List<String> actual_menus =new java.util.ArrayList<>();
		
		for(WebElement menus : menu_elements) {
			actual_menus.add(menus.getText().trim());
			System.out.println(menus.getText());		
		}
		
		//Assertion
		for(String expected_menu : expected_menus) {
			Assert.assertTrue(actual_menus.contains(expected_menu),expected_menu+"Menu is Not Displayed.");
		}
		
	}
	
	
	
	//Verify Admin page is visible after clicking Admin option in the menu bar
	@Test(priority = 8)
	public void Verify_Clicking_Admin_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Admin_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("admin"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Admin"), "Admin does not contains in the page.");
		
	}
	
	//Verify PIM page is visible after clicking PIM option in the menu bar
	@Test(priority = 9)
	public void Verify_Clicking_PIM_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_PIM_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("pim"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("PIM"), "PIM does not contains in the page.");
	}
	
	//Verify Leave page is visible after clicking Leave option in the menu bar
	@Test(priority = 10)
	public void Verify_Clicking_Leave_Page_displayed() throws InterruptedException {

		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Leave_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("leave"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Leave"), "PIM does not contains in the page.");
	}
	
	//Verify Time page is visible after clicking Time option in the menu bar
	@Test(priority = 11)
	public void Verify_Clicking_Time_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Time_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("time"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Time"), "PIM does not contains in the page.");
	}
	
	//Verify Recruitment page is visible after clicking Recruitment option in the menu bar
	@Test(priority = 12)
	public void Verify_Clicking_Recruitment_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Recruitment_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("recruitment"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Recruitment"), "PIM does not contains in the page.");
	}
	
	//Verify My Info page is visible after clicking My Info option in the menu bar
	@Test(priority = 13)
	public void Verify_Clicking_My_Info_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_My_Info_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("PIM"), "PIM does not contains in the page.");
	}
	
	
	//Verify Performance page is visible after clicking Performance option in the menu bar
	@Test(priority = 14)
	public void Verify_Clicking_Performance_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Performance_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("performance"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Performance"), "PIM does not contains in the page.");
	}
	
	//Verify Dashboard page is visible after clicking Dashboard option in the Menu bar
	@Test(priority = 15)
	public void Verify_Clicking_Dashboard_Page_displayed() throws InterruptedException {
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Dashboard_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("dashboard"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Dashboard"), "PIM does not contains in the page.");
	}
	
	
	//Verify Directory page is visible after clicking Directory option in the Menu bar
	@Test(priority = 16)
	public void Verify_Clicking_Directory_Page_displayed() throws InterruptedException {
		
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Directory_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("directory"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Directory"), "PIM does not contains in the page.");
	}
	
	//Verify Maintenance page is visible after clicking Maintenance option in the Menu bar
	@Test(priority = 17)
	public void Verify_Clicking_Maintenance_Page_displayed() throws InterruptedException {

		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Maintenance_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("maintenance"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Administrator Access"), "PIM does not contains in the page.");
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//Verify Claim page is visible after clicking Claim option in the Menu bar
	@Test(priority = 18)
	public void Verify_Clicking_Claim_Page_displayed() throws InterruptedException {

		
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Claim_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("claim"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Claim"), "PIM does not contains in the page.");
	}
	
	//Verify Buzz page is visible after clicking Buzz option in the Menu bar
	@Test(priority = 19)
	public void Verify_Clicking_Buzz_Page_displayed() throws InterruptedException {

		
		DashboardPage dp = new DashboardPage(driver);
		
		dp.Click_Buzz_Menu_btn();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("buzz"));
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Buzz"), "PIM does not contains in the page.");
	}
	
	
	
	
}
