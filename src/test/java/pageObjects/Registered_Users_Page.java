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

public class Registered_Users_Page {
	public static WebDriver driver;
	By menu_Registered_user = By.xpath(".//*[@id='rptUser_menuAnchor_2']");
	By dwn_user_status = By.id("ContentPlaceHolder1_ddlCurrentStatus");
	By btn_submit = By.id("ContentPlaceHolder1_btnUpdateUserCurrentStatus");
	By lnk_username = By.id("lblUserName");
	By btn_ok = By.name("ctl00$ContentPlaceHolder1$uctlMessage$btnOk");
	By txt_username = By.id("ContentPlaceHolder1_txtSearchUserName");
	By btn_search = By.id("btnSearch");
	By btn_export_excel = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By lnk_pagination = By.xpath("//*[@id='grvUsers']/tbody/tr[12]/td/table/tbody/tr/td[2]/a");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	By btn_Reset = By.id("btnReset");
	By sort_username = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[1]/a");
	By sort_lastname = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[2]/a");
	By sort_fname = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[3]/a"); 
	By sort_email = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[4]/a");
	By sort_city = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[5]/a");
	By sort_state = By.xpath("//*[@id='grvUsers']/tbody/tr[1]/th[6]/a");
	By sort_list_username = By.id("lblUserName");
	By sort_list_lastname = By.id("lblLastName");
	By sort_list_firstname = By.id("lblFirstName");
	By sort_list_email = By.id("lblEmail");
	By sort_list_city = By.id("lblCity");
	By sort_list_state = By.id("lblState");


	public void Registered_user(){

		try{
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			this.driver = new Login_Page().getDriver();				

			driver.findElement(menu_Registered_user).click();
			Log.info("Registered user menu has been chosen");				
			//Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));			
			//sel.selectByIndex(2);
			//Log.info("Facility code has been chosen");
			Thread.sleep(2000);
			driver.findElement(btn_export_excel).click();
			Log.info("Export to excel has been clicked");	

			Thread.sleep(2000);
			scroll();
			driver.findElement(lnk_pagination).click();
			Log.info("Pagination has been clicked");	

			Thread.sleep(2000);
			driver.findElement(txt_username).sendKeys("mangai");
			Log.info("Submit button has been clicked");		

			Thread.sleep(2000);			
			driver.findElement(btn_search).click();
			Log.info("Search button has been clicked");

			Thread.sleep(2000);
			List<WebElement> myElements = driver.findElements(lnk_username);					
			myElements.get(4).click();
			Log.info("Username has been selected");

			Thread.sleep(2000);
			Select status = new Select(driver.findElement(dwn_user_status));
			status.selectByValue("1");
			Log.info("Inactive has been chosen");

			Thread.sleep(2000);
			driver.findElement(btn_submit).click();
			Log.info("Submit button has been clicked");

			Thread.sleep(2000);
			driver.findElement(btn_ok).click();
			Log.info("OK button has been clicked");

			Thread.sleep(2000);
			Select status1 = new Select(driver.findElement(dwn_user_status));
			Thread.sleep(2000);
			status1.selectByValue("2");
			Log.info("Active has been chosen");

			Thread.sleep(2000);
			driver.findElement(btn_submit).click();
			Log.info("Submit button has been clicked");

			Thread.sleep(2000);
			driver.findElement(btn_ok).click();
			Log.info("OK button has been clicked");

			Thread.sleep(2000);
			driver.findElement(btn_back).click();
			Log.info("Back button has been clicked");

			Thread.sleep(2000);
			driver.findElement(btn_Reset).click();
			Log.info("Reset button has been clicked");


		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/* code for scroll*/
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
	}

	public void field_sorting() throws Exception{
		this.driver = new Login_Page().getDriver();	
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		//driver.findElement(menu_Registered_user).click();
		//Log.info("Registered user menu has been chosen");	

	/*	Thread.sleep(1000);
		driver.findElement(sort_username).click();
		Log.info("Username sorted successfully");
		Thread.sleep(3000);

		sorting_username();
		Log.info("Navigated to sorting function");
		Thread.sleep(1000);
		driver.findElement(sort_username).click();
		Log.info("Username clicked successfully");
		Thread.sleep(1000);		
		sorting_username();
		Log.info("Username sorting successfully");
		
		Thread.sleep(1000);
		driver.findElement(sort_lastname).click();
		Log.info("Lastname sorting successfully");
		Thread.sleep(1000);
		sorting_lastname();
		driver.findElement(sort_lastname).click();
		Log.info("Lastname sorting successfully");*/

		/*Thread.sleep(2000);
		driver.findElement(sort_fname).click();
		Log.info("Firstname sorted successfully");
		Thread.sleep(1000);                                                                                                                                                                                   
		sorting_firstname();
		driver.findElement(sort_fname).click();
		Log.info("Firstname sorting successfully");
		*/
		Thread.sleep(1000);
		driver.findElement(sort_email).click();
		Log.info("Email sorting successfully");
		Thread.sleep(1000);
		sorting_email();
		driver.findElement(sort_email).click();
		Log.info("Email sorting successfully");
		
		
		Thread.sleep(1000);
		driver.findElement(sort_city).click();
		Log.info("City sorting successfully");
		Thread.sleep(1000);	
		sorting_city();
		driver.findElement(sort_city).click();
		Log.info("City sorting successfully");
		
		Thread.sleep(1000);
		driver.findElement(sort_state).click();
		Log.info("State sorting successfully");
		Thread.sleep(1000);	
		sorting_state();
		Thread.sleep(1000);
		driver.findElement(sort_state).click();
		Log.info("State sorting successfully");
	}

	public void sorting_username() throws Exception{
		List<WebElement> li = driver.findElements(sort_list_username);
		for(WebElement e : li) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}

	public void sorting_lastname() throws Exception{
		List<WebElement> ln = driver.findElements(sort_list_lastname);
		for(WebElement e : ln) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}

	public void sorting_firstname() throws Exception{
		List<WebElement> li = driver.findElements(sort_list_firstname);
		for(WebElement e : li) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}

	public void sorting_email() throws Exception{
		List<WebElement> li = driver.findElements(sort_list_email);
		for(WebElement e : li) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}

	public void sorting_city() throws Exception{
		List<WebElement> li = driver.findElements(sort_list_city);
		for(WebElement e : li) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}

	public void sorting_state() throws Exception{
		List<WebElement> li = driver.findElements(sort_list_state);
		for(WebElement e : li) {
			Thread.sleep(1000);	
			System.out.println(e.getText());
		}
	}


	/* code for explicit wait*/
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
