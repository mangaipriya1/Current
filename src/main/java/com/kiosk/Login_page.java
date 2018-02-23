package com.kiosk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Login_page {
	public  static WebDriver driver;

	By btn_login = By.id("btnEnter");
	By txt_username = By.id("txtLoginUserName");
	By txt_password = By.id("txtLoginpassword");
	By dwn_choose_facility = By.id("ddlLoadAllFacility");
	By dwn_choose_pod = By.id("ddlLoadPod");
	By dwn_choose_kiosk = By.id("ddlKioskMachine");
	By txt_verification_code = By.id("txtVerificationCode");
	By btn_validate_machine = By.id("btnVerification");
	
	By btn_Enter_Id = By.id("txtUsername");
	By btn_Enter_pin = By.id("txtPassword");
	By btn_login1 = By.id("btnLogin");

	public void Login_Page()
	{
		this.driver=driver;
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	@Test
	public void Navigate_To_Inmate() throws Exception{
		try{
		System.setProperty("webdriver.ie.driver", "D:\\Mangai\\selenium\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		Thread.sleep(1000);

		driver.get("http://inmatecr01.sgssys.info/Common/KioskLogin.aspx");
		Thread.sleep(1000);
	//	driver.manage().window().maximize();		
	//	String  handle= driver.getWindowHandle();
		/*driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		Select obj = new Select(driver.findElement(dwn_choose_facility));
		obj.selectByValue("105");
		Thread.sleep(1000);
		Select obj1 = new Select(driver.findElement(dwn_choose_pod));
		obj1.selectByValue("133");
		Thread.sleep(1000);
		Select obj2 = new Select(driver.findElement(dwn_choose_kiosk));
		obj1.selectByValue("139");
		Thread.sleep(1000);
		driver.findElement(txt_verification_code).sendKeys("7D33EC7");
		Thread.sleep(1000);
		driver.findElement(btn_validate_machine).click();*/
		driver.findElement(btn_login).click();
		Thread.sleep(1000);
		/*driver.findElement(btn_Enter_Id).click();
		Thread.sleep(1000);
		driver.findElement(btn_Enter_pin).sendKeys("11");
		Thread.sleep(1000);*/
		driver.findElement(btn_login1).click();
		driver.navigate().to("http://inmatecr01.sgssys.info/Common/KioskLogin.aspx");
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
