package pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dashboard_page {

	public static WebDriver driver;
	
	public void Dashboard() throws Exception{
		//test
		Logger logger=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		this.driver = new Login_Page().getDriver();	
		By menu_dashboard = By.xpath(".//*[@id='rptUser_menuAnchor_3']");
		By btn_import = By.xpath(".//*[@id='ContentPlaceHolder1_btnImportInmates']");
		By btn_popup = By.id("btnOk");
		By btn_Report = By.id("ContentPlaceHolder1_btnReports");	
		By btn_export_excel = By.id("ContentPlaceHolder1_imbtnExportToExcel");
		By lnk_duplicates = By.id("ContentPlaceHolder1_lnkbtnDuplicateCountHeader");
		By lnk_error = By.id("ContentPlaceHolder1_lnkbtnErrorsInUpdate");
		By btn_back = By.id("ContentPlaceHolder1_btnBack");
		
		try{
		Thread.sleep(2000);
		driver.findElement(menu_dashboard).click();
		logger.info("Dashboard chosen successfully");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		logger.info("Facility code has been chosen");
		Thread.sleep(1000);
		driver.findElement(btn_import).click();
		logger.info("Import Inmates button has been clicked");
		Thread.sleep(2000);
		driver.findElement(btn_popup).click();
		logger.info("Ok Popup clicked successfully");
		Thread.sleep(1000);
		driver.findElement(btn_Report).click();
		logger.info("Report button clicked successfully");		
		Thread.sleep(2000);	
		scroll();
		Thread.sleep(2000);	
		driver.findElement(lnk_duplicates).click();
		logger.info("Duplicates link has been clicked");	
		Thread.sleep(2000);
		driver.findElement(btn_export_excel).click();
		logger.info("Export to excel has been clicked");	
		Thread.sleep(2000);
		driver.findElement(btn_back).click();
		logger.info("Back button has been clicked");	
		Thread.sleep(2000);
		Thread.sleep(2000);	
		scroll();
		Thread.sleep(2000);	
		driver.findElement(lnk_error).click();
		logger.info("Error link has been clicked");	
		Thread.sleep(2000);
		driver.findElement(btn_export_excel).click();
		logger.info("Export to excel has been clicked");	
		Thread.sleep(2000);		
		driver.findElement(btn_back).click();
		logger.info("Back button has been clicked");
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
