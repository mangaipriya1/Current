package pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class Lockdown_Page {

	public static WebDriver driver;
	public void lockdown() throws Exception{
		try{
		this.driver = new Login_Page().getDriver();	
		By menu_lockdown = By.id("rptUser_menuAnchor_5");
		By chk_permission = By.id("chkHeaderSelectAllKioskLockDownAllActive");
		By btn_lock = By.id("ContentPlaceHolder1_btnKioskLockdownLock");
		By btn_popup = By.id("btnOk");
		By chk_kiosk_lock = By.id("chkHeaderSelectAllKioskLockDownActive");
		
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(menu_lockdown).click();
		Log.info("Lockdown menu has been clicked");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		Thread.sleep(4000);
		driver.findElement(chk_permission).click();
		//driver.findElement(chk_permission).click();
		Log.info("Permission has chosen");
		scroll();
		Thread.sleep(4000);	
		scroll();
		driver.findElement(btn_lock).click();
		Log.info("Lock button has clicked");
		Thread.sleep(5000);
		driver.findElement(btn_popup).click();
		Log.info("Ok Popup clicked successfully");
		Thread.sleep(4000);
		driver.findElement(chk_kiosk_lock).click();
		Log.info("Lock button has clicked");
		scroll();
		Thread.sleep(2000);
		driver.findElement(btn_lock).click();
		Log.info("Lock button has clicked");
		Thread.sleep(1000);
		driver.findElement(btn_popup).click();
		Log.info("Ok Popup clicked successfully");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
		Thread.sleep(1000);
	}
}
