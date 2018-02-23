package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class Reporting {

	public  WebDriver driver;
	
	

	By menu_reporting = By.id("rptUser_menuAnchor_16");
	By dwn_type = By.id("ContentPlaceHolder1_ddlRequestTypeSearch");
	By txt_start_date = By.id("ContentPlaceHolder1_txtRequestCreatedStartDateSearch");
	By txt_end_date = By.id("ContentPlaceHolder1_txtRequestCreatedEndDateSearch");
	By btn_search = By.id("btnSearchRequest");
	By export_excel = By.id("ContentPlaceHolder1_imgbtnOverAllExportToExcel");
	By btn_reset = By.id("ContentPlaceHolder1_btnSearchCancel");
	By dwn_status = By.id("ContentPlaceHolder1_ddlRequestStatusSearch");
	By lnk_form = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[1]/a");
	By lnk_request_cnt = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[2]/a");
	By lnk_respond_time = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[3]/a");
	By lnk_Avg_respond = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[4]/a");
	By lnk_Req_cnt_percent = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[5]/a");
	By lnk_respond_time_percent = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[6]/a");
	By lnk_avg_respond_percent = By.xpath("//*[@id='ContentPlaceHolder1_grdvwOverAllRequest']/tbody/tr[1]/th[6]/a");

	public void report(){
		try{
			this.driver = new Login_Page().getDriver();
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");

			driver.findElement(menu_reporting).click();
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");	
			Thread.sleep(1000);


			String type ="Request";
			switch (type) {
			case "visitor":
				search_visitor_form();	
				Log.info("Visitor Form has been chosen");	
				staus_both();
				break;
			case "Admin":
				search_admin_form();
				Log.info("Administrative Remedy Form has been chosen");		
				staus_Request_close();
				break;
			case "Request":
				search_request_form();
				Log.info("Request Form Type has been chosen");	
				staus_Request_open();
				break;
			default:
				break;
			}


			driver.findElement(txt_start_date).sendKeys("08/05/2017");
			Log.info("Start date entered");
			driver.findElement(txt_end_date).sendKeys("09/25/2017");
			Log.info("Start date entered");

			driver.findElement(btn_search).click();
			Log.info("Search button has clicked");
			/*WebElement element = driver.findElement(export_excel);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", element);		
			Log.info("Export to excel clicked successfully");*/
			Thread.sleep(3000);
			driver.findElement(btn_reset).click();
			Log.info("Reset button clicked successfully");
			sorting_form();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void search_request_form(){
		Select select = new Select(driver.findElement(dwn_type));
		select.selectByValue("3");
	}

	public void search_admin_form(){
		Select select = new Select(driver.findElement(dwn_type));
		select.selectByValue("2");

	}

	public void search_visitor_form(){
		Select select = new Select(driver.findElement(dwn_type));
		select.selectByValue("1");

	}

	public void staus_both(){
		Select select = new Select(driver.findElement(dwn_status));
		select.selectByValue("2");
	}

	public void staus_Request_open(){
		Select select = new Select(driver.findElement(dwn_status));
		select.selectByValue("1");
	}

	public void staus_Request_close(){
		Select select = new Select(driver.findElement(dwn_status));
		select.selectByValue("1");
	}

	public void sorting_form() throws Exception{
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		scroll();
		Thread.sleep(3000);
		driver.findElement(lnk_form).click();
		Log.info("Form sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_form).click();		
		Log.info("Form sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_request_cnt).click();
		Log.info("Request Count sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_request_cnt).click();		
		Log.info("Request Count sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_respond_time).click();
		Log.info("Respond time sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_respond_time).click();		
		Log.info("Respond time sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_Avg_respond).click();
		Log.info("Average Respond time sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_Avg_respond).click();		
		Log.info("Average Respond time sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_Req_cnt_percent).click();
		Log.info("Avg Request Count sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_respond_time).click();		
		Log.info("Avg Request Count sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_respond_time_percent).click();
		Log.info("Avg Respond sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_respond_time_percent).click();		
		Log.info("Avg Respond Count sorted as Decending");
		
		Thread.sleep(3000);
		driver.findElement(lnk_avg_respond_percent).click();
		Log.info("Avg Respond Percent sorted as Ascending");
		Thread.sleep(3000);
		driver.findElement(lnk_avg_respond_percent).click();		
		Log.info("Avg Respond Percent sorted as Decending");
		
	}

	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,650)");
		Thread.sleep(1000);

	}
}


