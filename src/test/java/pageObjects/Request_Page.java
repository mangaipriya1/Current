package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;






//import com.framework.screenshot.CaptureScreenshot;
import utility.Log;

public class Request_Page {

	public WebDriver driver;
	By menu_request = By.id("rptUser_menuAnchor_11");
	By btn_search = By.id("btnSearchRequest");
	By lnk_remedy = By.xpath(".//*[@id='ContentPlaceHolder1_grvRequestInfo_lbtnRequestFormTitle_3']");
	By btn_submit = By.id("btnSaveRemedyForm");
	By btn_popup = By.id("btnOk");
	By lnk_form = By.id("ContentPlaceHolder1_grvRequestInfo_lbtnRequestFormTitle_0");
	By txt_title = By.id("ContentPlaceHolder1_txtReviewTitle");
	By radio_approve = By.id("ContentPlaceHolder1_grvVisitorDetails_rblApproveDisApprove_0_0_0");
	By chk_comments = By.id("ContentPlaceHolder1_grvVisitorDetails_chkVictim_0");
	By btn_update = By.id("ContentPlaceHolder1_btnResubmit");		
	By radio_approve2 = By.id("ContentPlaceHolder1_grvVisitorDetails_rblApproveDisApprove_1_0_1");
	By btn_Initiate_Msg_Inmate = By.id("btnRaiseMyQuery");
	By btn_create_new = By.id("btnCreateNew");
	By dwn_message_type = By.id("ContentPlaceHolder1_ddlRequestType");
	By dwn_choose_inmate_single = By.id("ContentPlaceHolder1_ddlSingleInmates");
	By dwn_choose_inmate_multi = By.id("ContentPlaceHolder1_cbSelectAll");
	By txt_area_description = By.id("ContentPlaceHolder1_txtForumContent");
	By btn_msg_submit = By.id("btnForumSave");		
	By sort_form = By.xpath("//*[@id='ContentPlaceHolder1_grvRequestInfo']/tbody/tr[1]/th[1]/a"); 
	By sort_inmate = By.xpath("//*[@id='ContentPlaceHolder1_grvRequestInfo']/tbody/tr[1]/th[2]/a");
	By sort_created = By.xpath("//*[@id='ContentPlaceHolder1_grvRequestInfo']/tbody/tr[1]/th[3]/a");
	By sort_responded = By.xpath("//*[@id='ContentPlaceHolder1_grvRequestInfo']/tbody/tr[1]/th[4]/a"); 
	By sort_msg_initiate = By.xpath(" //*[@id='ContentPlaceHolder1_grvRequestInfo']/tbody/tr[1]/th[5]/a");
	By btn_initiate_msg = By.id("btnRaiseMyQuery");
	By radio_pdf = By.id("ContentPlaceHolder1_rdolstReplyMode_1");
	By radio_both = By.id("ContentPlaceHolder1_rdolstReplyMode_2");
	By btn_choosefile = By.id("ContentPlaceHolder1_fluDocument");
	By btn_back = By.id("ContentPlaceHolder1_btnBackToMain");
	
	Logger Log=Logger.getLogger("Login_Page");
	//PropertyConfigurator.configure("log4j.properties");	
	public void request(){
		try{
		this.driver = new Login_Page().getDriver();			
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");		
		scroll();
		driver.findElement(menu_request).click();
		Log.info("Request form has been chosen");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");	
		Thread.sleep(1000);
		Initiate_msg_to_inmate();
		Request_Sort();
		visitor_form();
		remedy_form();
		//CaptureScreenshot.captureScreenShot1();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,1550)");
		Thread.sleep(1000);
	}
	
	
	public void remedy_form() throws Exception{
		Select type = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlRequestTypeSearch")));
		type.selectByValue("2");
		Log.info("Type dropdown has chosen successfully");
		driver.findElement(btn_search).click();
		Log.info("Search button has chosen");
		Thread.sleep(1000);
		List<WebElement> myElements = driver.findElements(lnk_form);
		Thread.sleep(1000);			
		myElements.get(0).click();	
		//driver.findElement(lnk_remedy).click();
		scroll();
		//scroll();
		//scroll();
		Log.info("Admin Remedy form has been chosen");
		driver.findElement(txt_title).sendKeys("Admin form");
		Log.info("Title entered successfully");
		driver.findElement(btn_submit).click();
		Log.info("Submit button clicked successfully");
		Thread.sleep(1000);
		driver.findElement(btn_popup).click();
		Log.info("Ok Popup clicked successfully");
	}
	
	
	public void visitor_form() throws Exception{
		Select type = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlRequestTypeSearch")));
		type.selectByValue("1");
		Log.info("Type dropdown has chosen successfully");
		driver.findElement(btn_search).click();
		Log.info("Search button has chosen");
		Thread.sleep(1000);
		List<WebElement> myElements = driver.findElements(lnk_form);
		Thread.sleep(1000);			
		myElements.get(0).click();	
		//driver.findElement(lnk_remedy).click();
		scroll();
		//scroll();
		//scroll();
		
		Log.info("Visitor form has been chosen");
		Thread.sleep(1000);
		driver.findElement(radio_approve).click();
		Log.info("Approve button chosen successfully");
		Thread.sleep(1000);
		//driver.findElement(radio_approve2).click();
		//Log.info("Approve button chosen successfully");
		scroll();
		//List<WebElement> myElement = driver.findElements(chk_comments);
		Thread.sleep(1000);			
		//.get(0).click();	
		//driver.findElement(chk_comments).click();
		//Log.info("Checkbox clicked successfully");
		driver.findElement(btn_update).click();
		Log.info("Submit button clicked successfully");
		Thread.sleep(1000);
		driver.findElement(btn_popup).click();
		Log.info("Ok Popup clicked successfully");
	}
	
	
	public void Initiate_msg_to_inmate() throws Exception{
		this.driver = new Login_Page().getDriver();			
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");	
		Thread.sleep(1000);
		driver.findElement(menu_request).click();
		Log.info("Request form has been chosen");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");	
				
		Thread.sleep(1000);
		driver.findElement(btn_Initiate_Msg_Inmate).click();
		Thread.sleep(1000);
		Log.info("Initiate msg button clicked");
		driver.findElement(btn_create_new).click();
		Thread.sleep(1000);
		Select s1 = new Select(driver.findElement(dwn_message_type));
		s1.selectByValue("54");
		Log.info("Message type chosen");
		Thread.sleep(1000);
		Select s2 = new Select(driver.findElement(dwn_choose_inmate_single));
		s2.selectByValue("2661");
		Log.info("Single inmate dropdown chosen");
		Thread.sleep(1000);
		driver.findElement(radio_both).click();
		Thread.sleep(2000);
		driver.findElement(btn_choosefile).sendKeys("C:\\Users\\mangaipriya\\Desktop\\pdf.pdf");
		driver.findElement(txt_area_description).sendKeys("Helllooooo");
		Log.info("Description entered");
		Thread.sleep(2000);
		driver.findElement(btn_msg_submit).click();
		Log.info("Submit button clicked");
		Thread.sleep(2000);
		driver.findElement(btn_popup).click();
		driver.findElement(sort_form).click();
		Thread.sleep(2000);
		driver.findElement(sort_form).click();
		Log.info("Form has been sorted successfully");
		Thread.sleep(2000);
		driver.findElement(sort_msg_initiate).click();
		Log.info("Message Intitiated by has been sorted successfully");
		//driver.findElement(sort_msg_initiate).click();	
		Thread.sleep(2000);
		driver.findElement(sort_inmate).click();
		Thread.sleep(2000);
		driver.findElement(sort_inmate).click();
		Log.info("Initiated By has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(sort_created).click();
		Thread.sleep(1000);
		driver.findElement(sort_created).click();
		Log.info("Inmate has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(sort_responded).click();
		Thread.sleep(1000);
		driver.findElement(sort_responded).click();
		Log.info("Responded on has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(btn_back).click();
	}
	
	public void Request_Sort() throws Exception{
		/*this.driver = new Login_Page().getDriver();			
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");		
		driver.findElement(menu_request).click();
		Log.info("Request form has been chosen");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByIndex(3);	*/
		System.out.println("*****sorting*****");
		driver.findElement(sort_form).click();
		Thread.sleep(1000);
		driver.findElement(sort_form).click();
		Log.info("Request Form has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(sort_inmate).click();
		Thread.sleep(1000);
		driver.findElement(sort_inmate).click();
		Log.info("Inmate has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(sort_created).click();
		Thread.sleep(1000);
		driver.findElement(sort_created).click();
		Log.info("Form has been sorted successfully");
		Thread.sleep(1000);
		driver.findElement(sort_responded).click();
		Thread.sleep(1000);
		driver.findElement(sort_responded).click();
		Log.info("Responded on has been sorted successfully");
	}
	
	
	
	
}
