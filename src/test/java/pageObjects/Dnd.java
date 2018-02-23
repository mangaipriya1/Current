package pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;



public class Dnd {
	//test
	Logger log = Logger.getLogger(Dnd.class.getName());
	public WebDriver driver;	
	By menu_dnd = By.id("rptUser_menuAnchor_17");
	By btn_dnd = By.xpath("//input[@id='ContentPlaceHolder1_bnAddDNDUsers']");
	By radio_btn_email = By.id("ContentPlaceHolder1_rdoDNDType_1");
	By txt_mobile = By.id("ContentPlaceHolder1_txtDNDUserEmail");
	By txt_email = By.id("ContentPlaceHolder1_txtDNDUserEmail");
	By btn_save = By.id("btnSubmit");
	By sort_email = By.xpath("//a[contains(text(),'Email/Mobile')]");
	By sort_mobile = By.xpath("//a[contains(text(),'Date')]");
	By sort_source = By.xpath("//a[contains(text(),'Source')]");
	By sort_Remarks = By.xpath("//a[contains(text(),'Remarks')]");
	By sort_Status = By.xpath("//a[contains(text(),'Status')]");
	By export = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By pagination = By.xpath("//*[@id='grvDNDUsers']/tbody/tr[12]/td/table/tbody/tr/td[3]/a");
	By btn_twilio = By.id("btnGetDndFromTwilio");
	By btn_ok = By.name("ctl00$ContentPlaceHolder1$uctlMessage$btnOk");
	public void dnd_users() throws Exception{
		
		this.driver = new Login_Page().getDriver();
		System.out.println("Navigated to DND user");
		scroll();
		Thread.sleep(2000);
		driver.findElement(menu_dnd).click();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
	//	driver.findElement(export).click();
		log.info("Export to excel clicked successfully");
		Thread.sleep(1000);
		scroll();
		Thread.sleep(2500);
		//WebDriverWait w1 = new WebDriverWait(driver, 50);
		//w1.until(ExpectedConditions.elementToBeClickable(pagination));
		driver.findElement(pagination).click();
		Thread.sleep(2000);
		scroll1();
		Thread.sleep(2500);
		driver.findElement(btn_twilio).click();
		Thread.sleep(2500);
		driver.findElement(btn_ok).click();
		Thread.sleep(1000);
		char dnd = 'B';
		switch (dnd) {
		case 'A':
			driver.findElement(btn_dnd).click();
			Add_DND_Mobilenum();
			sorting();
			break;
		case 'B':
			driver.findElement(btn_dnd).click();
			Thread.sleep(1000);
			driver.findElement(radio_btn_email).click();
			Thread.sleep(1000);
			Add_DND_Email();
			sorting();
			break;
		default:
			break;
		}
		
	}
	
	public void Add_DND_Mobilenum() throws Exception{
		Thread.sleep(1000);
		driver.findElement(txt_mobile).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(btn_save).click();
		Thread.sleep(2500);
		driver.findElement(btn_ok).click();
		log.info("Dnd Mobile number added successfully");
	}
	
	public void Add_DND_Email() throws Exception{
		Thread.sleep(1000);
		driver.findElement(txt_email).sendKeys("abcd@gmail.com");
		Thread.sleep(1000);
		driver.findElement(btn_save).click();
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
		log.info("Dnd Email added successfully");
	}
	
	public void sorting() throws Exception{
		Thread.sleep(1000);
		driver.findElement(sort_email).click();
		Thread.sleep(1000);
		driver.findElement(sort_mobile).click();
		Thread.sleep(1000);
		driver.findElement(sort_source).click();
		Thread.sleep(1000);
		driver.findElement(sort_Remarks).click();
		Thread.sleep(1000);
		driver.findElement(sort_Status).click();
		Thread.sleep(1000);
		
	}
	
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,500)");
		Thread.sleep(1000);
	}
	
	/* code for scroll*/
	private void scroll1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,-500)");
		Thread.sleep(1000);
	}
}
