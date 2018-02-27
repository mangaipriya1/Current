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
import org.testng.annotations.AfterMethod;

//import com.framework.screenshot.CaptureScreenshot;











import utility.Log;

public class Management_User_Page {
	public WebDriver driver;

	By menu_mgmt_user = By.xpath(".//*[@id='rptUser_menuAnchor_1']");
	By btn_add_user = By.xpath(".//*[@id='ContentPlaceHolder1_btnAddUser']");
	By txt_fname = By.id("ContentPlaceHolder1_txtFirstName");
	By txt_lname =By.xpath(".//*[@id='ContentPlaceHolder1_txtLastName']");
	By txt_uname =By.id("ContentPlaceHolder1_txtUserName");
	By txt_pwd = By.id("txtPassword");
	By txt_email = By.id("ContentPlaceHolder1_txtEmail");
	By txt_address = By.id("ContentPlaceHolder1_txtAddress");	
	
	By chk_form1 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkSelectRequestTypeAd_0");
	By chk_respond1 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkPermRespond_0");
	By chk_form2 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkSelectRequestTypeAd_1");
	By chk_respond2 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkPermRespond_1");
	By chk_form3 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkSelectRequestTypeAd_2");
	By chk_respond3 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkPermRespond_2");
	By btn_submit = By.id("btnSubmit");
	By btn_popup = By.id("btnOk");
	By lnk_list_fac_admin = By.id("ContentPlaceHolder1_grvManagementUsers_lblFullName_0");
	By txt_middle_name = By.id("ContentPlaceHolder1_txtMiddleName");
	By btn_update1 = By.name("ctl00$ContentPlaceHolder1$btnSubmit");
	By btn_ok = By.name("ctl00$ContentPlaceHolder1$uctlMessage$btnOk");
	By chk_form4 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkSelectRequestTypeAd_3");
	By chk_respond4 = By.id("ContentPlaceHolder1_uctlFacilityAdminMenu_rptFacilityAdmin_grvRequestTypesAdmin_11_chkPermRespond_3");
	By txt_fullname = By.id("txtSearchFullName");
	By btn_search = By.id("btnSearchUser");
	//By lnk_pagination = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[12]/td/table/tbody/tr/td[2]/a");
	By lnk_export_to_excel = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By chk_staff_form1 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkSelectRequestType_0");
	By chk_staff_respond1 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkPermRespond_0");
	By chk_staff_form2 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkSelectRequestType_1");
	By chk_staff_respond2 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkPermRespond_1");
	By chk_staff_form3 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkSelectRequestType_2");
	By chk_staff_respond3 = By.id("ContentPlaceHolder1_uctlFacilityStaffMenu_rptFacilityStaff_grvRequestTypesStaff_11_chkPermRespond_2");
	By lnk_list_fac_staff = By.id("ContentPlaceHolder1_grvManagementUsers_lblFullName_0");
	By sort_full_name = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[1]/th[1]/a");	
	By sort_role = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[1]/th[2]/a");
	By sort_city = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[1]/th[3]/a");
	By sort_zip = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[1]/th[4]/a");
	By sort_status = By.xpath("//*[@id='ContentPlaceHolder1_grvManagementUsers']/tbody/tr[1]/th[5]/a");
	
	

	/* Add Management User*/
	public void Mgmt_user_Add_Facilityadmin(String fname,String lname,String uname,String pwd) throws Exception{
		try {
			Thread.sleep(1000);	
			this.driver = new Login_Page().getDriver();
			Thread.sleep(1000);
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");

			System.out.println("Navigated to mgmt user");
			Thread.sleep(1000);
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");	
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(btn_add_user).click();
			Log.info("Add user button has been clicked");
			Thread.sleep(2000);
			Select role = new Select(driver.findElement(By.id("ddlRole")));
			role.selectByValue("2");
			Log.info("Facility role has chosen");
			Thread.sleep(1000);
			driver.findElement(txt_fname).sendKeys(fname);
			Log.info("Firstname has been entered");
			driver.findElement(txt_lname).sendKeys(lname);
			Log.info("Lastname has been entered");
			driver.findElement(txt_uname).sendKeys(uname);
			Log.info("Username has been entered");
			driver.findElement(txt_pwd).sendKeys(pwd);
			Log.info("Password has been entered");
			driver.findElement(txt_email).sendKeys("test582@sgstechie.com");
			Log.info("Email has been entered");
			driver.findElement(txt_address).sendKeys("test");
			Log.info("Address has been entered");
			Select state = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
			state.selectByIndex(5);
			Log.info("State has been selected");
			Thread.sleep(1000);


			scroll();
			Thread.sleep(1000);
			WebElement element1= driver.findElement(chk_form1);
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element1);
			Log.info("Visitor checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element2=driver.findElement(chk_respond1);
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", element2);			
			Log.info("Visitor Respond checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element3 =driver.findElement(chk_form2);
			JavascriptExecutor executor3 = (JavascriptExecutor) driver;
			executor3.executeScript("arguments[0].click();", element3);
			Log.info("Remedy form has chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element4=driver.findElement(chk_respond2);
			JavascriptExecutor executor4 = (JavascriptExecutor) driver;
			executor4.executeScript("arguments[0].click();", element4);			
			Log.info("Remedy Respond checkbox chosen");

			/*scroll();
			Thread.sleep(1000);
			WebElement element5=driver.findElement(chk_form3);
			JavascriptExecutor executor5 = (JavascriptExecutor) driver;
			executor5.executeScript("arguments[0].click();", element5);			
			Log.info("Request form checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element6=driver.findElement(chk_respond3);
			JavascriptExecutor executor6 = (JavascriptExecutor) driver;
			executor6.executeScript("arguments[0].click();", element6);			
			Log.info("Request form respond checkbox chosen");
*/
			WebElement element= driver.findElement(By.id("btnSubmit"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.info("Submit button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_popup).click();
			Log.info("Ok Popup clicked successfully");


		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/* Edit Management User*/
	public void Mgmt_user_Edit_facilityadmin(){
		try {

			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			this.driver = new Login_Page().getDriver();	
			System.out.println("Navigated to mgmt user");
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");				
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(txt_fullname).sendKeys("fac");
			Log.info("Full name has been entered");
			Thread.sleep(1000);
			driver.findElement(btn_search).click();
			Log.info("search button has been chosen");
			Thread.sleep(1000);
			List<WebElement> myElements = driver.findElements(lnk_list_fac_admin);
			Thread.sleep(1000);			
			myElements.get(0).click();		
			Log.info("Edit option is clicked");
			Thread.sleep(2000);
			driver.findElement(txt_fname).clear();
			driver.findElement(txt_fname).sendKeys("hello200112");
			Thread.sleep(2000);	
			scroll();
			Thread.sleep(1000);
			/*WebElement element7=driver.findElement(chk_form3);
			JavascriptExecutor executor7 = (JavascriptExecutor) driver;
			executor7.executeScript("arguments[0].click();", element7);			
			Log.info("Request form 2 checkbox chosen");*/

			/*scroll();
			Thread.sleep(1000);
			WebElement element8=driver.findElement(chk_respond4);
			JavascriptExecutor executor8 = (JavascriptExecutor) driver;
			executor8.executeScript("arguments[0].click();", element8);			
			Log.info("Request form 2 respond checkbox chosen");*/
			//WebElement element = driver.findElement(btn_update1);
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("arguments[0].click()", element);
			scroll();
			webdriverWait(btn_update1, 50);
			driver.findElement(btn_update1).click();
			Log.info("Update button has been selected");

			webdriverWait(btn_ok, 50);
			driver.findElement(btn_ok).click();
			Log.info("Ok popup has been chosen");

		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public void pagination() {
		try {
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			this.driver = new Login_Page().getDriver();	
			System.out.println("Navigated to mgmt user");
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");				
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			driver.findElement(lnk_export_to_excel).click();
			Log.info("Export to excel has been chosen");
			scroll();
			Thread.sleep(1000);
			//webdriverWait(lnk_pagination, 50);
		//driver.findElement(lnk_pagination).click();
			Log.info("Pagination has been chosen");
			
			Thread.sleep(2000);
			driver.findElement(sort_full_name).click();
			Log.info("Before sorting Full name");
			Thread.sleep(2000);
			driver.findElement(sort_full_name).click();
			Log.info("After sorting Full name");
			
			Thread.sleep(2000);
			driver.findElement(sort_role).click();
			Log.info("Before sorting role");
			Thread.sleep(2000);
			driver.findElement(sort_role).click();
			Log.info("After sorting role");
			
			Thread.sleep(2000);
			driver.findElement(sort_city).click();
			Log.info("Before sorting city");
			Thread.sleep(2000);
			driver.findElement(sort_city).click();
			Log.info("After sorting city");
			
			Thread.sleep(2000);
			driver.findElement(sort_zip).click();
			Log.info("Before sorting zip");
			Thread.sleep(2000);
			driver.findElement(sort_zip).click();
			Log.info("After sorting zip");
			
			Thread.sleep(2000);
			driver.findElement(sort_status).click();
			Log.info("Before sorting status");
			Thread.sleep(2000);
			driver.findElement(sort_status).click();
			Log.info("After sorting status");			
			
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}

	}

	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
		Thread.sleep(1000);
	}

	/* code for explicit wait*/
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


	/* Add Facility Staff*/
	public void Add_Facility_Staff(String staffuname,String email){
		try {
			Thread.sleep(1000);

			this.driver = new Login_Page().getDriver();	
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");

			System.out.println("Navigated to mgmt user");
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");	
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(btn_add_user).click();
			Log.info("Add user button has been clicked");
			Thread.sleep(2000);
			Select role = new Select(driver.findElement(By.id("ddlRole")));
			role.selectByValue("3");		
			Log.info("Facility role has chosen");
			Thread.sleep(1000);
			driver.findElement(txt_fname).sendKeys("facility");
			Log.info("Facility staff first name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_lname).sendKeys("staff");
			Log.info("Facility staff last name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_uname).sendKeys(staffuname);
			Log.info("Facility staff username name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_pwd).sendKeys("facility123");
			Log.info("Facility staff Password has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_email).sendKeys(email);
			Log.info("Facility staff Email has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_address).sendKeys("facility");
			Log.info("Facility staff Address has been entered");
			Select state = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
			state.selectByIndex(5);
			Log.info("Facility staff State has been selected");


			scroll();
			Thread.sleep(1000);
			WebElement element1= driver.findElement(chk_staff_form1);
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element1);
			Log.info("Visitor checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element2=driver.findElement(chk_staff_respond1);
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", element2);			
			Log.info("Visitor Respond checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element3= driver.findElement(chk_staff_form2);
			JavascriptExecutor executor3 = (JavascriptExecutor) driver;
			executor3.executeScript("arguments[0].click();", element3);
			Log.info("Visitor checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element4=driver.findElement(chk_staff_respond2);
			JavascriptExecutor executor4 = (JavascriptExecutor) driver;
			executor4.executeScript("arguments[0].click();", element4);			
			Log.info("Visitor Respond checkbox chosen");

			WebElement element= driver.findElement(By.id("btnSubmit"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.info("Submit button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_popup).click();
			Log.info("Ok Popup clicked successfully");

		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	
	}

	/* Edit Facility Staff*/
	public void Mgmt_user_Edit_facilityStaff(){
		try {

			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			this.driver = new Login_Page().getDriver();	
			System.out.println("Navigated to mgmt user");
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");				
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(txt_fullname).sendKeys("staff facility");
			Log.info("Full name has been entered");
			Thread.sleep(1000);
			driver.findElement(btn_search).click();
			Log.info("search button has been chosen");
			Thread.sleep(1000);
			List<WebElement> myElements = driver.findElements(lnk_list_fac_staff);
			Thread.sleep(1000);			
			myElements.get(0).click();		
			Log.info("Edit option is clicked");
			Thread.sleep(2000);
			driver.findElement(txt_fname).clear();
			driver.findElement(txt_fname).sendKeys("hello staff"+Math.random());
			Thread.sleep(2000);	
			scroll();
			Thread.sleep(1000);
			WebElement element7=driver.findElement(chk_staff_form3);
			JavascriptExecutor executor7 = (JavascriptExecutor) driver;
			executor7.executeScript("arguments[0].click();", element7);			
			Log.info("Request form 2 checkbox chosen");

			scroll();
			Thread.sleep(1000);
			WebElement element8=driver.findElement(chk_staff_respond3);
			JavascriptExecutor executor8 = (JavascriptExecutor) driver;
			executor8.executeScript("arguments[0].click();", element8);			

			scroll();
			webdriverWait(btn_update1, 50);
			driver.findElement(btn_update1).click();
			Log.info("Update button has been selected");

			webdriverWait(btn_ok, 50);
			driver.findElement(btn_ok).click();
			Log.info("Ok popup has been chosen");

		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	/*Add Public Defender Admin*/
	public void Add_public_defender_admin(){
		try {

			Thread.sleep(1000);
			this.driver = new Login_Page().getDriver();	
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");

			System.out.println("Navigated to mgmt user");
			driver.findElement(menu_mgmt_user).click();
			Log.info("Management user menu has been chosen");	
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("114");
			Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(btn_add_user).click();
			Log.info("Add user button has been clicked");
			Thread.sleep(2000);
			Select role = new Select(driver.findElement(By.id("ddlRole")));
			role.selectByValue("11");		
			Log.info("Facility role has chosen");
			Thread.sleep(1000);
			driver.findElement(txt_fname).sendKeys("public");
			Log.info("PD Admin first name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_lname).sendKeys("defender");
			Log.info("PD Admin last name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_uname).sendKeys("pddefadmins"+Math.random());
			Log.info("PD Admin username name has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_pwd).sendKeys("PDAdmin123");
			Log.info("PD Admin Password has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_email).sendKeys(+Math.random()+"PDAdmins@test.com");
			Log.info("PD Admin Email has been entered");
			Thread.sleep(1000);
			driver.findElement(txt_address).sendKeys("facilityPD Admin");
			Log.info("PD Admin Address has been entered");
			Select state = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
			state.selectByIndex(5);
			Log.info("PD Admin State has been selected");
			WebElement element= driver.findElement(By.id("btnSubmit"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.info("Submit button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_popup).click();
			Log.info("Ok Popup clicked successfully");			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

	}
		/* Edit Public Defender Admin*/
		public void Edit_public_defender_admin(){
			try {
				Logger Log=Logger.getLogger("Login_Page");
				PropertyConfigurator.configure("log4j.properties");
				this.driver = new Login_Page().getDriver();	
				System.out.println("Navigated to mgmt user");
				driver.findElement(menu_mgmt_user).click();
				Log.info("Management user menu has been chosen");				
				Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
				sel.selectByValue("114");
				Log.info("Facility code has been chosen");
				Thread.sleep(2000);
				driver.findElement(txt_fullname).sendKeys("admin pd");
				Log.info("Full name has been entered");
				Thread.sleep(1000);
				driver.findElement(btn_search).click();
				Log.info("search button has been chosen");
				Thread.sleep(1000);
				List<WebElement> myElements = driver.findElements(lnk_list_fac_staff);
				Thread.sleep(1000);			
				myElements.get(0).click();		
				Log.info("Edit option is clicked");
				Thread.sleep(2000);
				driver.findElement(txt_fname).clear();
				driver.findElement(txt_fname).sendKeys("hello pdsadmin");
				Thread.sleep(2000);	
				scroll();
				webdriverWait(btn_update1, 50);
				driver.findElement(btn_update1).click();
				Log.info("Update button has been selected");

				webdriverWait(btn_ok, 50);
				driver.findElement(btn_ok).click();
				Log.info("Ok popup has been chosen");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		

		/*Add Public Defender Staff*/
		public void Add_public_defender_staff(){
			try {

				Thread.sleep(1000);
				this.driver = new Login_Page().getDriver();	
				Logger Log=Logger.getLogger("Login_Page");
				PropertyConfigurator.configure("log4j.properties");

				System.out.println("Navigated to mgmt user");
				driver.findElement(menu_mgmt_user).click();
				Log.info("Management user menu has been chosen");	
				Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
				sel.selectByValue("114");
				Log.info("Facility code has been chosen");
				Thread.sleep(2000);
				driver.findElement(btn_add_user).click();
				Log.info("Add user button has been clicked");
				Thread.sleep(2000);
				Select role = new Select(driver.findElement(By.id("ddlRole")));
				role.selectByValue("10");		
				Log.info("Facility role has chosen");
				Thread.sleep(1000);
				driver.findElement(txt_fname).sendKeys("public");
				Log.info("PD Staff first name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_lname).sendKeys("defenderstaff");
				Log.info("PD Staff last name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_uname).sendKeys(+Math.random()+"pdstaffnew");
				Log.info("PD Staff username name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_pwd).sendKeys("PDstaff123");
				Log.info("PD Staff Password has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_email).sendKeys(+Math.random()+"PDstaffnew@test.com");
				Log.info("PD Staff Email has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_address).sendKeys("facilityPD Admin");
				Log.info("PD Staff Address has been entered");
				Select state = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
				state.selectByIndex(5);
				Log.info("PD StaffState has been selected");
				WebElement element= driver.findElement(By.id("btnSubmit"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Log.info("Submit button clicked successfully");
				Thread.sleep(1000);
				driver.findElement(btn_popup).click();
				Log.info("Ok Popup clicked successfully");			
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}

		}

		/* Edit Public Defender staff*/
		public void Edit_public_defender_staff(){
			try {
				Logger Log=Logger.getLogger("Login_Page");
				PropertyConfigurator.configure("log4j.properties");
				this.driver = new Login_Page().getDriver();	
				System.out.println("Navigated to mgmt user");
				driver.findElement(menu_mgmt_user).click();
				Log.info("Management user menu has been chosen");				
				Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
				sel.selectByValue("114");
				Log.info("Facility code has been chosen");
				Thread.sleep(2000);
				driver.findElement(txt_fullname).sendKeys("defenderstaff");
				Log.info("Full name has been entered");
				Thread.sleep(1000);
				driver.findElement(btn_search).click();
				Log.info("search button has been chosen");
				Thread.sleep(1000);
				List<WebElement> myElements = driver.findElements(lnk_list_fac_staff);
				Thread.sleep(1000);			
				myElements.get(0).click();		
				Log.info("Edit option is clicked");
				Thread.sleep(2000);
				driver.findElement(txt_fname).clear();
				driver.findElement(txt_fname).sendKeys("hello pstaff");
				Thread.sleep(2000);	
				scroll();
				webdriverWait(btn_update1, 50);
				driver.findElement(btn_update1).click();
				Log.info("Update button has been selected");

				webdriverWait(btn_ok, 50);
				driver.findElement(btn_ok).click();
				Log.info("Ok popup has been chosen");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/* Add Super Admin*/
		public void Add_super_admin(){
			try {
				Thread.sleep(1000);
				this.driver = new Login_Page().getDriver();	
				Logger Log=Logger.getLogger("Login_Page");
				PropertyConfigurator.configure("log4j.properties");

				System.out.println("Navigated to mgmt user");
				driver.findElement(menu_mgmt_user).click();
				Log.info("Management user menu has been chosen");	
				Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
				sel.selectByValue("114");
				Log.info("Facility code has been chosen");
				Thread.sleep(2000);
				driver.findElement(btn_add_user).click();
				Log.info("Add user button has been clicked");
				Thread.sleep(2000);
				Select role = new Select(driver.findElement(By.id("ddlRole")));
				role.selectByValue("12");		
				Log.info("Facility role has chosen");
				Thread.sleep(1000);
				driver.findElement(txt_fname).sendKeys("super");
				Log.info("Super admin first name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_lname).sendKeys("admin");
				Log.info("Super admin last name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_uname).sendKeys(+Math.random()+"superadminneww");
				Log.info("Super admin username name has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_pwd).sendKeys("mangai123");
				Log.info("Super admin Password has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_email).sendKeys(+Math.random()+"superadminn@test3204.com");
				Log.info("Super admin Email has been entered");
				Thread.sleep(1000);
				driver.findElement(txt_address).sendKeys("address");
				Log.info("Super admin Address has been entered");
				Select state = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlState")));
				state.selectByIndex(5);
				Log.info("Super admin State has been selected");
				WebElement element= driver.findElement(By.id("btnSubmit"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Log.info("Submit button clicked successfully");
				Thread.sleep(1000);
				driver.findElement(btn_popup).click();
				Log.info("Ok Popup clicked successfully");			
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		
		/* Edit Super Admin*/
		public void Edit_super_admin(){
			try {
				Logger Log=Logger.getLogger("Login_Page");
				PropertyConfigurator.configure("log4j.properties");
				this.driver = new Login_Page().getDriver();	
				System.out.println("Navigated to mgmt user");
				driver.findElement(menu_mgmt_user).click();
				Log.info("Management user menu has been chosen");				
				Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
				sel.selectByValue("114");
				Log.info("Facility code has been chosen");
				Thread.sleep(2000);
				driver.findElement(txt_fullname).sendKeys("admin");
				Log.info("Full name has been entered");
				Thread.sleep(1000);
				driver.findElement(btn_search).click();
				Log.info("search button has been chosen");
				Thread.sleep(1000);
				List<WebElement> myElements = driver.findElements(lnk_list_fac_staff);
				Thread.sleep(1000);			
				myElements.get(0).click();		
				Log.info("Edit option is clicked");
				Thread.sleep(2000);
				driver.findElement(txt_fname).clear();
				driver.findElement(txt_fname).sendKeys("hello superadmin");
				Thread.sleep(2000);	
				scroll();
				scroll();
				webdriverWait(btn_submit, 50);
				driver.findElement(btn_submit).click();
				Log.info("Update button has been selected");

				webdriverWait(btn_ok, 50);
				driver.findElement(btn_ok).click();
				Log.info("Ok popup has been chosen");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}