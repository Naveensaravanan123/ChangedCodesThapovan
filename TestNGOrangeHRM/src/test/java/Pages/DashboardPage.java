package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	//Admin menu button
	By btn_Admin = By.xpath("//span[text()=\"Admin\"]");
	//PIM menu button
	By btn_PIM = By.xpath("//span[text()=\"PIM\"]");
	//Leave menu Button
	By btn_Leave = By.xpath("//span[text()=\"Leave\"]");
	//Time menu Button
	By btn_Time = By.xpath("//span[text()=\"Time\"]");
	//Recruitment menu Button
	By btn_recruitment = By.xpath("//span[text()=\"Recruitment\"]");
	//My Info menu Button
	By btn_My_Info = By.xpath("//span[text()=\"My Info\"]");
	//Performance menu button
	By btn_Performance = By.xpath("//span[text()=\"Performance\"]");	
	//Dashboard menu Button
	By btn_Dashboard = By.xpath("//span[text()=\"Dashboard\"]");
	//Directory menu button
	By btn_Directory = By.xpath("//span[text()=\"Directory\"]");
	//Maintenance menu Button
	By btn_Maintenance = By.xpath("//span[text()=\"Maintenance\"]");
	//Claim menu button
	By btn_Claim = By.xpath("//span[text()=\"Claim\"]");
	//Buzz menu buton
	By btn_Buzz = By.xpath("//span[text()=\"Buzz\"]");


	//Admin Menu Button
	public void Click_Admin_Menu_btn() {
		driver.findElement(btn_Admin).click();
	}
	//PIM Menu Button
	public void Click_PIM_Menu_btn() {
		driver.findElement(btn_PIM).click();
	}
	//Leave Menu Button
	public void Click_Leave_Menu_btn() {
		driver.findElement(btn_Leave).click();
	}
	//Time Menu button
	public void Click_Time_Menu_btn() {
		driver.findElement(btn_Time).click();
	}
	//Recruitment Menu button
	public void Click_Recruitment_Menu_btn() {
		driver.findElement(btn_recruitment).click();
	}
	//My Info Menu button
	public void Click_My_Info_Menu_btn() {
		driver.findElement(btn_My_Info).click();
	}
	//Performance Menu button
	public void Click_Performance_Menu_btn() {
		driver.findElement(btn_Performance).click();
	}
	//Dashboard Menu button
	public void Click_Dashboard_Menu_btn() {
		driver.findElement(btn_Dashboard).click();
	}
	//Directory Menu button
	public void Click_Directory_Menu_btn() {
		driver.findElement(btn_Directory).click();
	}
	//Maintenance Menu button
	public void Click_Maintenance_Menu_btn() {
		driver.findElement(btn_Maintenance).click();
	}
	//Claim Menu button
	public void Click_Claim_Menu_btn() {
		driver.findElement(btn_Claim).click();
	}
	//Buzz Menu button
	public void Click_Buzz_Menu_btn() {
		driver.findElement(btn_Buzz).click();
	}


}



