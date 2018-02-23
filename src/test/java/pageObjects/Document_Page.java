package pageObjects;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import utility.logger;

public class Document_Page {

	public static WebDriver driver;
	By menu_document = By.xpath(".//*[@id='rptUser_menuAnchor_4']");
	By btn_upload = By.xpath(".//*[@id='ContentPlaceHolder1_btnUploadDocuments']");
	By txt_title = By.id("ContentPlaceHolder1_txtTitle");
	By btn_browse = By.id("ContentPlaceHolder1_fluDocument");
	By btn_save = By.id("btnSubmit");
	By btn_popup = By.id("btnOk");
	By btn_Reset = By.id("ContentPlaceHolder1_btnCancel");
	By btn_Back = By.id("ContentPlaceHolder1_btnBack");
	By lnk_title = By.xpath("//*[@id='grvDocuments']/tbody/tr[1]/th[1]/a");
	By lnk_document = By.xpath("//*[@id='grvDocuments']/tbody/tr[1]/th[2]/a");
	By lnk_date = By.xpath("//*[@id='grvDocuments']/tbody/tr[1]/th[3]/a");
	By sort_title = By.id("lnkDocumentTitle");
	By sort_doc = By.id("lnkDocumentFileName");
	By sort_date = By.id("lblDocumentUploadDate");
	//*[@id="grvDocuments"]/tbody/tr[1]/th[1]/a
	public void Login_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Upload_doc_add() throws Exception{
		try {
			Logger logger=Logger.getLogger("loggerin_Page");
			PropertyConfigurator.configure("log4j.properties");
			Document_Page.driver = new Login_Page().getDriver();

			
			this.driver = new Login_Page().getDriver();	
			driver.findElement(menu_document).click();
			logger.info("Document menu has been clicked");
			Thread.sleep(1000);
			logger.info("Document chosen successfully");
			Thread.sleep(1000);
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");
			Thread.sleep(2000);
			driver.findElement(btn_upload).click();		
			logger.info("Upload button has been clicked");
			Thread.sleep(2000);
			driver.findElement(btn_save).click();
			logger.info("Save button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(txt_title).sendKeys("pdf1 sample");
			logger.info("Title entered successfully");
			Thread.sleep(4000);
			driver.findElement(btn_save).click();
			logger.info("Save button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_browse).click();
			Runtime.getRuntime().exec("C:\\Users\\mangaipriya\\Desktop\\fileupload.exe");
			logger.info("File uploaded successfully");
			Thread.sleep(4000);
			driver.findElement(btn_save).click();
			logger.info("Save button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_popup).click();
			logger.info("Ok Popup clicked successfully");
			/*driver.findElement(btn_Reset).click();
			logger.info("Reset Button clicked successfully");
			driver.findElement(btn_Back).click();
			logger.info("Back Button clicked successfully");*/
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void sort_document() throws Exception{
		Logger logger=Logger.getLogger("loggerin_Page");
		PropertyConfigurator.configure("log4j.properties");
		Document_Page.driver = new Login_Page().getDriver();
		this.driver = new Login_Page().getDriver();	
		driver.findElement(menu_document).click();
		logger.info("Document menu has been clicked");
		Thread.sleep(1000);
		logger.info("Document chosen successfully");
		Thread.sleep(1000);
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		try{
		Thread.sleep(1000);
		System.out.println("Before Sorting title");
		driver.findElement(lnk_title).click();
		Thread.sleep(1000);
		sort_title();
		driver.findElement(lnk_title).click();
		System.out.println("After Sorting title");
		Thread.sleep(1000);
		sort_title();
		
		Thread.sleep(1000);
		System.out.println("Before Sorting document");
		driver.findElement(lnk_document).click();
		Thread.sleep(1000);
		sort_doc();
		driver.findElement(lnk_document).click();
		System.out.println("After Sorting document");
		Thread.sleep(1000);
		sort_doc();
		
		Thread.sleep(1000);
		System.out.println("Before Sorting date");
		driver.findElement(lnk_date).click();
		Thread.sleep(1000);
		sort_date();
		driver.findElement(lnk_date).click();
		System.out.println("After Sorting date");
		Thread.sleep(1000);
		sort_date();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void sort_title(){
		List<WebElement> list = driver.findElements(By.id("lnkDocumentTitle"));
		for (WebElement e : list) {
			System.out.println(e.getText());
		}
	}
	
	public void sort_doc(){
		List<WebElement> list = driver.findElements(By.id("lnkDocumentFileName"));
		for (WebElement e : list) {
			System.out.println(e.getText());
		}
	}
	
	public void sort_date(){
		List<WebElement> list = driver.findElements(By.id("lblDocumentUploadDate"));
		for (WebElement e : list) {
			System.out.println(e.getText());
		}
	}
	
}
