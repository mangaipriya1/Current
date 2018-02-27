package pageObjects;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Log;




//import com.framework.screenshot.CaptureScreenshot;
import com.framework.screenshot.GetScreenShot;

import utility.Configure;
import utility.Log;
import utility.ReadExcel;

public class Login_Page {

	public static WebDriver driver;
	public static By txt_username = By.id("txtUsername");
	public static By txt_password = By.id("txtPassword");
	public static By btn_login =By.id("btnLogin");
	public static By menu_facility = By.xpath(".//*[@id='rptUser_menuAnchor_0']");


	/*public Login_Page()
	{
		this.driver=driver;
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}*/

	public WebDriver getDriver() {
		return driver;
	}



	@BeforeClass
	public static void testChrome() throws Exception{
		utility.Configure.Configure1();			
		System.setProperty("webdriver.chrome.driver", Configure.getChromePath());
		//PropertyConfigurator.configure("C:\\Users\\mangaipriya\\selenium\\inmatedemo\\src\\test\\java\\pageObjects\\log4j.properties");
		driver = new ChromeDriver();
		driver.get(Configure.getUrl());			
	}



	@Test(dataProvider="dp",priority=1)

	public static void Execute_Login(String username,String password){
		try{


			Logger logger=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");


			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
			driver.findElement(txt_username).sendKeys("");		
			driver.findElement(btn_login).click();

			logger.info("Enter valid Username");
			driver.findElement(txt_username).clear();
			driver.findElement(txt_username).sendKeys(username);
			logger.info("Username Entered Successfully");

			Thread.sleep(1000);
			driver.findElement(txt_password).sendKeys("");
			driver.findElement(btn_login).click();
			logger.info("Enter valid password");
			driver.findElement(txt_password).clear();
			driver.findElement(txt_password).sendKeys(password);

			logger.info("Password Entered Successfully");
			driver.findElement(btn_login).click();				
			logger.info("Submit button clicked Successfully");			
			WebElement loggedinuser = driver.findElement(By.xpath(".//*[@id='lblUserName']"));
			Assert.assertEquals(loggedinuser.getText(), "Admin Super");
			logger.info("Loggined as Super Admin");			
			//Thread.sleep(1000);


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*@Test(priority=7)
	public void Pod() throws Exception
	{		
		Pod obj = new Pod();
		obj.Add_Pod();
	}*/
	/*@Test(priority=2)
	public void Facility() throws Exception
	{
		Facility fac = new Facility();
		fac.Add_Facility("faciliy"+Math.random(), "facilitycode"+Math.random(), Math.random()+"test2301@test.com", "1234567896", "florida", "192.168.10.27", "/Inmate/Inmate2301"+Math.random()+".txt", "inmate_ftp", "inmate2017");
		fac.lnkFacilityID();
		fac.Pagination();
	}*/

	/*@Test(priority=3)
	public void Mgmt_user() throws Exception
	{		
		Management_User_Page obj = new Management_User_Page();
		obj.Mgmt_user_Add_Facilityadmin("mangaiadm","priyat","mangaiadma"+Math.random(),"mangai123");
		obj.Mgmt_user_Edit_facilityadmin();
		
		obj.Add_Facility_Staff("staffhlo"+Math.random(),"staff1@fac.com"+Math.random());
		obj.Mgmt_user_Edit_facilityStaff();
	    obj.Add_public_defender_admin();
		obj.Edit_public_defender_admin();
		obj.Add_public_defender_staff();
		obj.Edit_public_defender_staff();
		obj.Add_super_admin();
		obj.Edit_super_admin();
		obj.pagination();
	}*/
/*
	@Test(priority=4)
	public void Registered_Users() throws Exception
	{		
		Registered_Users_Page rr = new Registered_Users_Page();
		rr.Registered_user();
		rr.field_sorting();
	}
	 
	

	@Test(priority=5)
	public void Dashboard() throws Exception
	{		
		Dashboard_page objnew = new Dashboard_page();
		objnew.Dashboard();
	}

	@Test(priority=6)
	public void Document() throws Exception
	{		
		Document_Page doc = new Document_Page();
		doc.Upload_doc_add();
		doc.sort_document();
	}
	 
	@Test(priority=7)
	public void Lockdown() throws Exception
	{		
		Lockdown_Page lock = new Lockdown_Page();
		lock.lockdown();
	}

	@Test(priority=8)
	public void Revenue() throws Exception
	{		
		Revenue_Report rr = new Revenue_Report();
		rr.report_facility_daily();
		rr.report_all_daily();
		rr.report_all_monthly();
		rr.report_facility_monthly();
	}
	
	@Test(priority=9)
	public void Pod() throws Exception
	{		
		Pod obj = new Pod();
		obj.Add_Pod();
		obj.Edit_Pod();
		obj.sort_pod();
	}

	@Test(priority=10)
	public void Kiosk() throws Exception
	{		
		Kiosk obj = new Kiosk();
		obj.Add_kiosk();
		obj.Edit_kiosk();
	}
*/
	@Test(priority=11)
	public void Inmate_list() throws Exception
	{		
		Inmate obj = new Inmate();
		obj.Edit_Inmate();
	}

	/*@Test(priority=12)
	public void Publicuser() throws Exception
	{		
		Publicuser_Page obj = new Publicuser_Page();
		obj.publicuser_edit();
	}
	
	
	
	@Test(priority=13)
	public void Request() throws Exception
	{		
		Request_Page obj = new Request_Page();
		obj.request();
		obj.Request_Sort();
		obj.Initiate_msg_to_inmate();
	}


	@Test(priority=14)
	public void Message() throws Exception
	{		
		Message_Page obj = new Message_Page();
		obj.message();
		obj.sort_message();
	}

	@Test(priority=15)
	public void Photo() throws Exception
	{		
		Photo_Page obj = new Photo_Page();
		obj.Edit_photo();
		obj.sort_photo();
	}
	@Test(priority=16)
	public void Keyword() throws Exception
	{		
		Keyword_Page obj = new Keyword_Page();
		obj.keyword_add();
		obj.keyword_edit();
		obj.keyword_sorting();
	}

	

	@Test(priority=17)
	public void Notice() throws Exception
	{		
		Notice_Page obj = new Notice_Page();
		obj.Add_Notice();
		obj.sort_notice();
	}
	
	@Test(priority=18)
	public void Reporting() throws Exception
	{		
		Reporting obj = new Reporting();
		obj.report();

	}*/
	
	/*@Test(priority=19)
	public void Dnd() throws Exception
	{		
		Dnd obj = new Dnd();
		obj.dnd_users();

	}*/

	/*@Test(priority=12)
	public void Publicuser() throws Exception
	{		
		Publicuser_Page obj = new Publicuser_Page();
		obj.publicuser_edit();
	}*/

	@AfterMethod
	public static void onTestFailure(ITestResult result1) 
	{

		if(ITestResult.FAILURE==result1.getStatus())
		{
			try 
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("C:\\Users\\mangaipriya\\selenium\\inmatedemo\\src\\test\\java\\screenshot\\"+result1.getName()+".png"));
				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{   
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}   
		}
		//obj.close();
	}
	@DataProvider(name ="dp")
	public static Object[][] dp(){
		ReadExcel obj = new ReadExcel();
		int rows = obj.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for(int i=0;i<rows;i++){
			data[i][0] = obj.getData(0, i, 0);
			data[i][1] = obj.getData(0, i, 1);
		}
		return data;

	}
	
	


}




