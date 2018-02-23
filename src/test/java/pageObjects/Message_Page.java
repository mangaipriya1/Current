package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

//import com.framework.screenshot.CaptureScreenshot;







import utility.Log;

public class Message_Page {

	public WebDriver driver;
	By menu_messages = By.id("rptUser_menuAnchor_12");
	By lnk_subject = By.xpath(".//*[@id='lblMessageSubject']");
	By btn_back = By.xpath(".//*[@id='ContentPlaceHolder1_btnBack']");
	By btn_duplicate = By.id("ContentPlaceHolder1_lnkduplicate");
	By lnk_subject_duplicate = By.className("col-03");
	By dwn_flag_search = By.id("ContentPlaceHolder1_ddlMessageFlag");
	By btn_Search = By.id("btnSearch");
	By btn_back1 = By.id("ContentPlaceHolder1_Button1");
	By dwn_flag = By.id("ContentPlaceHolder1_ddlMessageFlag");
	By lnk_export_to_excel = By.id("ContentPlaceHolder1_imgbtnMessagesExporttoExcel");
	By lnk_pagination = By.xpath("//*[@id='grvMessagesInfo']/tbody/tr[12]/td/table/tbody/tr/td[3]/a");
	By sort_subject = By.xpath("//*[@id='grvMessagesInfo']/tbody/tr[1]/th[1]/a");
	By sorting_subject = By.id("lblMessageSubject");
	By sort_from = By.xpath("//*[@id='grvMessagesInfo']/tbody/tr[1]/th[2]/a");
	By sorting_from = By.id("lblFrom");
	By sort_to = By.xpath("//*[@id='grvMessagesInfo']/tbody/tr[1]/th[3]/a");
	By sorting_to = By.id("lblTo");
	By sort_sent = By.xpath("//*[@id='grvMessagesInfo']/tbody/tr[1]/th[5]/a");
	By sorting_sent = By.id("lblMessageSentDate");

	public void message(){
		try {
			this.driver = new Login_Page().getDriver();
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			driver.findElement(menu_messages).click();
			Log.info("Messages menu has been clicked");
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");	
			Thread.sleep(1000);
			Select sel1 = new Select(driver.findElement(dwn_flag));			
			sel1.selectByValue("0");
			Log.info("No Flag was chosen in search field");
			Thread.sleep(1000);
			List<WebElement> list = driver.findElements(lnk_subject);
			list.get(0).click();
			Log.info("Message has been clicked");
			Thread.sleep(1000);
			driver.findElement(btn_back).click();
			Log.info("Back button clicked");
			driver.findElement(btn_duplicate).click();
			Log.info("Duplicates button clicked");
			driver.findElement(lnk_subject_duplicate).click();
			Log.info("Subject Duplicates button clicked");
			Thread.sleep(2000);
			Select obj = new Select(driver.findElement(dwn_flag_search));
			obj.selectByValue("0");
			Log.info("Flag has been chosen in search");
			Thread.sleep(2000);
			driver.findElement(btn_Search).click();
			Log.info("Search button clicked successfully");
			Thread.sleep(2000);
			driver.findElement(lnk_subject_duplicate).click();
			Log.info("Subject Duplicates button clicked");
			Thread.sleep(2000);
			driver.findElement(btn_back1).click();
			Log.info("Back button clicked");
			Thread.sleep(2000);
			driver.findElement(lnk_export_to_excel).click();
			Log.info("Export to excel clicked successfully");
			Thread.sleep(2000);
			scroll();
			Thread.sleep(2000);
			driver.findElement(lnk_pagination).click();
			Log.info("Pagination clicked successfully");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	/* code for scroll*/
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
	}

	public void sort_message() throws Exception{
		this.driver = new Login_Page().getDriver();
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(menu_messages).click();
		Log.info("Messages menu has been clicked");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		Thread.sleep(1000);
		driver.findElement(sort_subject).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_subject();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(sort_subject).click();
		Thread.sleep(1000);
		sort_subject();

		driver.findElement(sort_from).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_from();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(sort_from).click();
		Thread.sleep(1000);
		sort_from();

		driver.findElement(sort_to).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_to();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(sort_to).click();
		Thread.sleep(1000);
		sort_to();

		driver.findElement(sort_sent).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_sent();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(sort_sent).click();
		Thread.sleep(1000);
		sort_sent();
	}

	public void sort_subject(){
		List<WebElement> li = driver.findElements(sorting_subject);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_from(){
		List<WebElement> li = driver.findElements(sorting_from);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_to(){
		List<WebElement> li = driver.findElements(sorting_to);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_sent(){
		List<WebElement> li = driver.findElements(sorting_sent);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}
}
