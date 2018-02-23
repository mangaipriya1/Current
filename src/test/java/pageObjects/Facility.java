package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import utility.Configure;
//import utility.Log;
//import utility.ReadExcel;

public class Facility   {
	public  WebDriver driver;
	public static Logger logger=Logger.getLogger("Login_Page");
	//PropertyConfigurator.configure("log4j.properties");

	By btn_Addfacility = By.xpath(".//*[@id='ContentPlaceHolder1_bnAddFacility']");
	By txt_code = By.xpath(".//*[@id='ContentPlaceHolder1_txtFacilityCode']");
	By txt_name = By.xpath(".//*[@id='ContentPlaceHolder1_txtFacilityName']");
	By txt_email =By.xpath(".//*[@id='ContentPlaceHolder1_txtEmail']");
	By txt_phone = By.xpath(".//*[@id='ContentPlaceHolder1_txtPhone']");
	By txt_address = By.xpath(".//*[@id='ContentPlaceHolder1_txtAddress1']");
	//By dropdown_state = By.xpath(".//*[@id='ContentPlaceHolder1_txtAddress1']");
	By btn_browse = By.xpath(".//*[@id='ContentPlaceHolder1_fluFormLogo']");
	By btn_upload = By.xpath(".//*[@id='ContentPlaceHolder1_btnUploadLogo']");
	By chk_message = By.xpath(".//*[@id='ContentPlaceHolder1_chkMessageAccess']"); 	 	
	By chk_document = By.xpath(".//*[@id='ContentPlaceHolder1_chkDocumentAccess']");
	By chk_photo = By.xpath(".//*[@id='ContentPlaceHolder1_chkPhotoAccess']");
	By chk_request = By.xpath(".//*[@id='ContentPlaceHolder1_chkFormRequestAccess']");
	By chk_commissary = By.id("ContentPlaceHolder1_chkCommissaryAccess");
	By chk_lawlibrary = By.xpath(".//*[@id='ContentPlaceHolder1_chkLawLibraryAccess']");
	By dwn_visitor = By.xpath(".//*[@id='ContentPlaceHolder1_cblAvailableForms_0']");
	By dwn_admin = By.xpath(".//*[@id='ContentPlaceHolder1_cblAvailableForms_1']");
	By dwn_request = By.xpath(".//*[@id='ContentPlaceHolder1_cblAvailableForms_2']");
	By btn_Addform = By.name("ctl00$ContentPlaceHolder1$btnAddForms");
	By btn_ok =By.id("btnOk");
	By txt_server_url =By.xpath(".//*[@id='ContentPlaceHolder1_txtFTPServerURL']");
	By txt_username = By.xpath(".//*[@id='ContentPlaceHolder1_txtFTPUsername']");
	By txt_filepath = By.xpath(".//*[@id='ContentPlaceHolder1_txtFTPFilePath']");
	By txt_password = By.xpath(".//*[@id='ContentPlaceHolder1_txtFTPPassword']");
	By btn_save = By.xpath(".//*[@id='btnSubmit']");
	By btn_alert =By.name("ctl00$ContentPlaceHolder1$uctlMessage$btnOk");
	By txt_visitor = By.name("ctl00$ContentPlaceHolder1$grvFormsInfo$ctl02$txtFacilityRequestFormTitle");
	By txt_pd = By.name("ctl00$ContentPlaceHolder1$grvFormsInfo$ctl03$txtFacilityRequestFormTitle");
	By txt_admin = By.name("ctl00$ContentPlaceHolder1$grvFormsInfo$ctl04$txtFacilityRequestFormTitle");
	By dwn_frequency_count1 = By.id("ContentPlaceHolder1_grvFormsInfo_ddlFrequencyCount_1");
	By dwn_frequency_type1 = By.id("ContentPlaceHolder1_grvFormsInfo_ddlFrequencyType_1");
	By dwn_freq_count2 = By.name("ctl00$ContentPlaceHolder1$grvFormsInfo$ctl04$ddlFrequencyCount");
	By dwn_frequency_type2 = By.name("ctl00$ContentPlaceHolder1$grvFormsInfo$ctl04$ddlFrequencyType");
	By chk_Active1 = By.id("ContentPlaceHolder1_rblForm1_0");
	By chk_Active2 = By.id("ContentPlaceHolder1_rblForm2_0");
	By chk_Active3 = By.id("ContentPlaceHolder1_rblForm3_0");
	By txt_lawlibrary = By.id("ContentPlaceHolder1_txtLawLibraryUrl");
	By txt_commissary = By.id("ContentPlaceHolder1_txtCommisaryUrl");
	By edit_fac = By.xpath("//*[@id='lnkFacilityID']");
	By pagination = By.xpath(".//*[@id='grvFacility']/tbody/tr[12]/td/table/tbody/tr/td[2]/a");
	By btn_update = By.name("ctl00$ContentPlaceHolder1$btnSubmit");
	By btn_popup = By.name("ctl00$ContentPlaceHolder1$uctlMessage$btnOk");
	By menu_facility = By.xpath("//*[@id=rptUser_menuAnchor_0]");
	By bt_reset = By.name("ctl00$ContentPlaceHolder1$btnReset");
	By lnk_Export_to_excel  = By.name("ctl00$ContentPlaceHolder1$imbtnExportToExcel");
	By btn_form_yes = By.id("btnYes");
	By Chk_msg_to_inmate1 = By.id("ContentPlaceHolder1_cblManagementAvailableForms_0");
	By chk_msg_to_inmate2 = By.id("ContentPlaceHolder1_cblManagementAvailableForms_1");
	By chk_msg_to_inmate3 = By.id("ContentPlaceHolder1_cblAvailableForms_3");
	By btn_add_form = By.id("ContentPlaceHolder1_btnAddForms");
	By txt_admin_form = By.id("ContentPlaceHolder1_grvFormsInfo_txtFacilityRequestFormTitle_2");
	By txt_msg_to_inmate1 = By.id("ContentPlaceHolder1_gdvwManagementForm_txtFacilityManagementRequestFormTitle_0");
	By txt_msg_to_inmate2 = By.id("ContentPlaceHolder1_gdvwManagementForm_txtFacilityManagementRequestFormTitle_1");
	By txt_req_form = By.id("ContentPlaceHolder1_grvFormsInfo_txtFacilityRequestFormTitle_3");
	//By sort_code = By.xpath("//*[@id='grvFacility']/tbody/tr[1]/th[1]/a");
	By sort_code = By.linkText("Code");
	//*[@id="grvFacility"]/tbody/tr[1]/th[1]/a
	By sort_name = By.xpath("//*[@id='grvFacility']/tbody/tr[1]/th[2]/a");
	By sort_city = By.xpath("//*[@id='grvFacility']/tbody/tr[1]/th[3]/a");
	By sort_state = By.xpath("//*[@id='grvFacility']/tbody/tr[1]/th[4]/a");
	By sort_status = By.xpath("//*[@id='grvFacility']/tbody/tr[1]/th[5]/a");
	By sort_lnk_code = By.id("lnkFacilityID");
	By sort_lnk_name = By.id("lblFacilityDescription");
	By sort_lnk_city = By.xpath("//*[@id='grvFacility']/tbody/tr[2]/td[3]");
	By sort_lnk_state = By.id("lblState");
	By sort_lnk_status = By.id("imgStatus");
	


	/* Add Facility */
	public void Add_Facility(String code,String name,String email,String phone,String address,String serverurl,String filepath,String uname,String pwd) throws Exception{
		try {

			this.driver = new Login_Page().getDriver();
			Thread.sleep(1000);
			
			driver.findElement(btn_Addfacility).click();
			logger.info("Add Facility has been chosen");	
			Thread.sleep(4000);			
			scroll();
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(txt_code).sendKeys(code);
			Thread.sleep(1000);	
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();			
			scroll();
			webdriverWait(btn_save, 50);			
			driver.findElement(txt_name).sendKeys(name);
			logger.info("Facility Name has been entered");
			Thread.sleep(1000);	
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_browse).sendKeys("");
			Thread.sleep(1000);
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();
			Thread.sleep(1000);
			driver.findElement(btn_browse).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\bear_PNG1194.png");
			logger.info("Logo chosen successfully");
			Thread.sleep(1000);	
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();
			Thread.sleep(1000);	
			driver.findElement(btn_upload).click();
			logger.info("Upload button chosen successfully");
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();	
			driver.findElement(txt_email).sendKeys(email);
			logger.info("Email has been entered");	
			scroll();
			webdriverWait(btn_save, 50);;	
			driver.findElement(btn_save).click();
			driver.findElement(txt_phone).sendKeys(phone);
			logger.info("Phone number has been entered");
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();
			Thread.sleep(1000);	
			driver.findElement(txt_address).sendKeys(address);
			logger.info("Facility address has been entered");
			scroll();
			webdriverWait(btn_save, 50);
			driver.findElement(btn_save).click();
			Select state = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddlState")));
			state.selectByIndex(2);
			logger.info("State has chosen");
			Thread.sleep(1000);	
			webdriverWait(btn_save, 50);
			driver.findElement(chk_message).click();
			logger.info("Message checkbox chosen successfully");
			Thread.sleep(1000);		
			driver.findElement(chk_document).click();
			logger.info("Document checkbox chosen successfully");
			Thread.sleep(1000);		
			driver.findElement(chk_photo).click();
			logger.info("Photo checkbox chosen successfully");
			Thread.sleep(1000);		
			driver.findElement(chk_request).click();
			logger.info("Request checkbox chosen successfully");
			Thread.sleep(1000);		
			scroll();
			/*driver.findElement(chk_commissary).click();
			logger.info("Commissary checkbox chosen successfully");
			Thread.sleep(1000);		
			driver.findElement(chk_lawlibrary).click();
			logger.info("Lawlibrary checkbox chosen successfully");
			Thread.sleep(1000);
			driver.findElement(txt_commissary).sendKeys("http://inmatecr01.sgssys.info/Admin/AddFacility.aspx");
			logger.info("Commissary textbox entered successfully");
			Thread.sleep(1000);	
			driver.findElement(txt_lawlibrary).sendKeys("http://inmatecr01.sgssys.info/Admin/AddFacility.aspx");
			logger.info("Law library textbox entered successfully");*/
			webdriverWait(dwn_visitor, 50);
			driver.findElement(dwn_visitor).click();
			logger.info("Visitor checkbox chosen successfully");
			Thread.sleep(1000);			
			driver.findElement(dwn_admin).click();
			logger.info("Admin checkbox chosen successfully");
			Thread.sleep(1000);	
			driver.findElement(dwn_request).click();
			logger.info("Request checkbox chosen successfully");						
			//webdriverWait(btn_Addform, 50);	
			//driver.findElement(btn_Addform).click();
			Thread.sleep(1000);					
			//driver.findElement(btn_form_yes).click();
			//logger.info("Ok button chosen successfully");
			driver.findElement(Chk_msg_to_inmate1).click();
			logger.info("Message to inmate1 has been chosen");
			driver.findElement(chk_msg_to_inmate2).click();
			logger.info("Message to inmate2 has been chosen");
			driver.findElement(btn_add_form).click();
			Thread.sleep(1000);
			driver.findElement(btn_form_yes).click();
			driver.findElement(txt_visitor).sendKeys("visitor form");
			logger.info("Visitor form has been entered");
			Thread.sleep(1000);	
			driver.findElement(txt_pd).sendKeys("pd form");
			logger.info("Request form has been entered");
			Thread.sleep(1000);	
			
		//	driver.findElement(btn_ok).click();
			logger.info("Ok button has been clicked");
			driver.findElement(txt_admin).sendKeys("Administrative Remedy form");
			logger.info("Remedy form has been entered");
			Thread.sleep(1000);
			Select freqcount1 = new Select(driver.findElement(dwn_frequency_count1));
			freqcount1.selectByIndex(2);
			logger.info("Freq count has been entered");
			Select freqtype1 = new Select(driver.findElement(dwn_frequency_type1));
			freqtype1.selectByIndex(1);
			logger.info("Freq type has been entered");
			Select freqcount2 = new Select(driver.findElement(dwn_freq_count2));
			freqcount2.selectByIndex(5);
			logger.info("Freq count has been entered");	
			Select freqtype2 = new Select(driver.findElement(dwn_frequency_type2));
			freqtype2.selectByIndex(2);
			driver.findElement(txt_msg_to_inmate1).sendKeys("Message to inmate1");
			logger.info("Form title1 has been entered");
			driver.findElement(txt_msg_to_inmate2).sendKeys("Message to inmate2");
			logger.info("Form title2 has been entered");
			Thread.sleep(2000);
			scroll();
			webdriverWait(btn_save,50);
			driver.findElement(btn_save).click();
			Thread.sleep(1000);
			driver.findElement(txt_server_url).sendKeys(serverurl);
			logger.info("Server url has been entered");
			Thread.sleep(1000);	
			driver.findElement(txt_filepath).sendKeys("123.22222.222.22");
			driver.findElement(btn_save).click();
			driver.findElement(txt_filepath).clear();
			driver.findElement(txt_filepath).sendKeys(filepath);
			logger.info("File path has been entered");
			Thread.sleep(1000);	
			driver.findElement(txt_username).sendKeys(uname);
			logger.info("Username has been entered");
			Thread.sleep(1000);	
			driver.findElement(txt_password).sendKeys(pwd);
			logger.info("Password has been entered");
			Thread.sleep(1000);	
			driver.findElement(btn_save).click();
			logger.info("save button clicked");
			Thread.sleep(1000);	
			driver.findElement(btn_ok).click();
			Thread.sleep(2000);	
			logger.info("Ok button clicked");				
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	/* Edit Facility */
	public void lnkFacilityID(){

		try {
			//Logger logger=Logger.getLogger("Login_Page");
		//PropertyConfigurator.configure("log4j.properties");
			//System.out.println("hiii123");
			this.driver = new Login_Page().getDriver();
			driver.findElement(By.id("ContentPlaceHolder1_txtFacilityCodeSearch")).sendKeys("120");
			Thread.sleep(2000);
			driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnSearch")).click();			
			webdriverWait(edit_fac, 50);
			List<WebElement> myElements = driver.findElements(edit_fac);
			Thread.sleep(2000);
			myElements.get(0).click();
			Thread.sleep(2000);
			System.out.println("Size of List: "+myElements.size());
			driver.findElement(txt_code).clear();
			driver.findElement(txt_code).sendKeys("Tes1fac");
			logger.info("Code has been edited");
			Thread.sleep(2000);
			scroll();
			driver.findElement(chk_msg_to_inmate3).click();
			logger.info("Message to inmate3 has been chosen");
			Thread.sleep(2000);
			driver.findElement(btn_add_form).click();
			Thread.sleep(2000);
			driver.findElement(btn_form_yes).click();
			Thread.sleep(2000);
			driver.findElement(txt_req_form).sendKeys("Request form");
			Thread.sleep(1000);
			driver.findElement(txt_msg_to_inmate1).clear();
			Thread.sleep(2000);
			driver.findElement(txt_msg_to_inmate1).sendKeys("Message to inmate1 form");
			Thread.sleep(2000);
			
			
			
			driver.findElement(btn_update).click();
			logger.info("Update button clicked");
			driver.findElement(btn_alert).click();
			Thread.sleep(2000);
			driver.findElement(bt_reset).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/* Pagination and Export to Excel */
	public void Pagination(){	
		try {
			/*Logger logger=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");	
			//driver.findElement(menu_facility).click();
			this.driver = new Login_Page().getDriver();*/
			//driver.findElement(lnk_Export_to_excel).click();
			logger.info("Export to excel link clicked successfully");
			webdriverWait(pagination, 50);
			logger.info("Navigated to list page");
			scroll();
			webdriverWait(pagination, 100);
			driver.findElement(pagination).click();
			logger.info("Pagination has been chosen");
			
			logger.info("Before Code sorting");			
			sort_code_before();	
			Thread.sleep(2000);
			driver.findElement(sort_code).click();
			//System.out.println("sort code clicked successfully");
			logger.info("After code sorting");
			sort_code_after();
			
			logger.info("Before Name sorting");			
			sort_name_before();			
			driver.findElement(sort_name).click();
			logger.info("After Name sorting");
			sort_name_after();
			
			/*logger.info("Before City sorting");			
			//sort_city_before();			
			driver.findElement(sort_city).click();
			logger.info("After City sorting");
			sort_city_after();*/
			
			logger.info("Before State sorting");			
			sort_state_before();			
			driver.findElement(sort_state).click();
			logger.info("After State sorting");
			sort_state_after();
			
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	/* code for scroll */
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
	}

	/* code for Explicit wait */
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void sort_code_before() throws Exception{
		try{
		Thread.sleep(1000);
		driver.findElement(sort_code).click();
		
		webdriverWait(sort_lnk_code, 250);
		List<WebElement> sortcode = driver.findElements(sort_lnk_code);
		Thread.sleep(1000);
		for(WebElement e:sortcode){
			Thread.sleep(2000);
			System.out.println(e.getText());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void sort_code_after() throws Exception{
		try{
		Thread.sleep(1000);
		driver.findElement(sort_code).click();
		webdriverWait(sort_lnk_code, 250);
		List<WebElement> sortcode1 = driver.findElements(sort_lnk_code);
		for(WebElement e:sortcode1){
			Thread.sleep(2000);
			System.out.println(e.getText());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void sort_name_before() throws Exception{
		try{
		Thread.sleep(1000);
		driver.findElement(sort_name).click();		
		webdriverWait(sort_lnk_name, 250);
		List<WebElement> sortname = driver.findElements(sort_lnk_name);
		for(WebElement e:sortname){
			Thread.sleep(2000);
			System.out.println(e.getText());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void sort_name_after() throws Exception{
		try{
		Thread.sleep(1000);
		driver.findElement(sort_name).click();		
		webdriverWait(sort_lnk_name, 250);
		List<WebElement> sortname = driver.findElements(sort_lnk_name);
		for(WebElement e:sortname){
			Thread.sleep(2000);
			System.out.println(e.getText());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public void sort_city_before() throws Exception{
		Thread.sleep(1000);
		driver.findElement(sort_city).click();		
		webdriverWait(sort_lnk_city, 50);
		List<WebElement> sortcity = driver.findElements(sort_lnk_city);
		for(WebElement e:sortcity){
			Thread.sleep(2000);
			System.out.println(e.getText());
		}
	}*/
	
	public void sort_city_after() throws Exception{
		try {
			Thread.sleep(1000);
			driver.findElement(sort_city).click();		
			webdriverWait(sort_lnk_city, 250);
			List<WebElement> sortcity = driver.findElements(sort_lnk_city);
			for(WebElement e:sortcity){
				Thread.sleep(2000);
				System.out.println(e.getText());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void sort_state_before() throws Exception{
		try {
			Thread.sleep(2000);
			driver.findElement(sort_state).click();		
			webdriverWait(sort_lnk_state, 250);
			List<WebElement> sortstate = driver.findElements(sort_lnk_state);
			for(WebElement e:sortstate){
				Thread.sleep(2000);
				System.out.println(e.getText());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void sort_state_after() throws Exception{
		try {
			Thread.sleep(1000);
			driver.findElement(sort_state).click();		
			webdriverWait(sort_lnk_state, 250);
			List<WebElement> sortstate = driver.findElements(sort_lnk_state);
			for(WebElement e:sortstate){
				Thread.sleep(2000);
				System.out.println(e.getText());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	







}
