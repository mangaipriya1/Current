package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

//import com.framework.screenshot.CaptureScreenshot;











import utility.Log;

public class Pod {
	public WebDriver driver;

	By menu_pod = By.id("rptUser_menuAnchor_7");
	By btn_add_pod = By.id("ContentPlaceHolder1_btnAddPOD");
	By txt_code = By.id("ContentPlaceHolder1_txtPodCode");
	By txt_name = By.id("ContentPlaceHolder1_txtPodName");
	By chk_access_permission = By.xpath(".//*[@id='chkSelectDeselectAll']");
	By btn_save = By.id("btnSubmit");
	By btn_popup = By.id("btnOk");
	By txt_code_search = By.id("ContentPlaceHolder1_txtPODCodeSearch");
	By btn_search = By.id("btnSearch");
	By lnk_list = By.xpath("//*[@id='lnkPod']");
	By lnk_code = By.xpath("//*[@id='grvPOD']/tbody/tr[1]/th[1]/a");
	By lnk_name = By.xpath("//*[@id='grvPOD']/tbody/tr[1]/th[2]/a");
	By lnk_inmates = By.xpath("//*[@id='grvPOD']/tbody/tr[1]/th[3]/a");
	By lnk_kiosk = By.xpath("//*[@id='grvPOD']/tbody/tr[1]/th[4]/a");
	By lnk_shared = By.xpath("//*[@id='grvPOD']/tbody/tr[1]/th[5]/a");
	By sort_code = By.id("lnkPod");
	By sort_name = By.id("lblPodName");
	By sort_inmates = By.id("lblnmates");
	By sort_kiosk = By.id("lblKiosks");
	By sort_shared = By.id("lblSharedPod");
	By btn_update = By.xpath("//*[@id='btnSubmit']");
	By lnk_kiosk_view = By.id("lnkKioskView");
	By kiosk_view_pagination = By.xpath("//*[@id='grdvwInmateLoginInfo']/tbody/tr[12]/td/table/tbody/tr/td[3]/a");
	By exportexcel = By.id("ContentPlaceHolder1_imgbtnInmateLoginInfoExportToExcel");
	By search_lastname = By.xpath("//*[@id='ddlLastNameSearch_chosen']/a/span");
	By enter_name = By.xpath("//*[@id='ddlLastNameSearch_chosen']/div/div/input");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	
	public void Add_Pod() throws Exception{
		try {
			this.driver = new Login_Page().getDriver();				
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			driver.findElement(menu_pod).click();
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");
			Thread.sleep(1000);			
			driver.findElement(btn_add_pod).click();
			Log.info("Add Pod has been chosen");
			driver.findElement(txt_code).sendKeys("Z1");
			Log.info("Pod code has been entered");
			driver.findElement(txt_name).sendKeys("Z1test");
			Log.info("Pod name has been entered");
			driver.findElement(chk_access_permission).click();
			Log.info("Permission Checkbox has been selected ");
			Thread.sleep(1000);
			driver.findElement(btn_save).click();
			Log.info("Save button clicked successfully");
			Thread.sleep(1000);
			driver.findElement(btn_popup).click();
			Log.info("Ok Popup clicked successfully");
			//CaptureScreenshot.captureScreenShot1();	

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Edit_Pod() throws Exception{
		try {
			this.driver = new Login_Page().getDriver();				
			Logger Log=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			driver.findElement(menu_pod).click();
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");
			Thread.sleep(2000);
			driver.findElement(txt_code_search).sendKeys("A");
			Log.info("Search button has been clicked");
			List<WebElement> myElements = driver.findElements(lnk_list);
			Thread.sleep(1000);			
			myElements.get(0).click();	
			Log.info("Edit option chosen");
			Thread.sleep(2000);	
			driver.findElement(txt_code).clear();
			Thread.sleep(2000);	
			scroll();
			Thread.sleep(2000);	
			driver.findElement(btn_update).click();
			Thread.sleep(2000);
			driver.findElement(txt_code).sendKeys("A112");
			Log.info("Edit Pod code");
			Thread.sleep(2000);	
			Thread.sleep(2000);	
			scroll();
			Thread.sleep(2000);	
			driver.findElement(btn_update).click();
			Thread.sleep(2000);
			driver.findElement(btn_popup).click();
			Log.info("Ok Popup clicked successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sort_pod() throws Exception{
		this.driver = new Login_Page().getDriver();				
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(menu_pod).click();
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		Thread.sleep(2000);
		System.out.println("Before Sorting");
		driver.findElement(lnk_code).click();
		Thread.sleep(1000);
		sorting_code();
		System.out.println("After Sorting");
		driver.findElement(lnk_code).click();
		Thread.sleep(1000);
		sorting_code();

		System.out.println("Before Sorting");
		driver.findElement(lnk_name).click();
		Thread.sleep(1000);
		sort_name();
		System.out.println("After Sorting");
		driver.findElement(lnk_name).click();
		Thread.sleep(1000);
		sort_name();

		System.out.println("Before Sorting");
		driver.findElement(lnk_inmates).click();
		Thread.sleep(1000);
		sort_inmates();
		System.out.println("After Sorting");
		driver.findElement(lnk_inmates).click();
		Thread.sleep(1000);
		sort_inmates();

		System.out.println("Before Sorting");
		driver.findElement(lnk_kiosk).click();
		Thread.sleep(1000);
		sort_kiosk();
		System.out.println("After Sorting");
		driver.findElement(lnk_kiosk).click();
		Thread.sleep(1000);
		sort_kiosk();

		System.out.println("Before Sorting");
		driver.findElement(lnk_shared).click();
		Thread.sleep(1000);
		sort_shared();
		System.out.println("After Sorting");
		driver.findElement(lnk_shared).click();
		Thread.sleep(1000);
		sort_shared();
		
		/*Thread.sleep(1000);
		driver.findElement(lnk_kiosk_view).click();
		Thread.sleep(1000);
		*/
		/*scroll();
		Thread.sleep(1000);
		//driver.findElement(kiosk_view_pagination).click();
		Thread.sleep(1000);
		driver.findElement(exportexcel).click();
		Thread.sleep(1000);*/
		/*scroll1();
		Thread.sleep(1000);
		driver.findElement(search_lastname).click();
		Thread.sleep(1000);
		driver.findElement(enter_name).sendKeys("ford");
		Thread.sleep(1000);
		driver.findElement(enter_name).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(btn_back).click();*/
		
		
	}

	public void sorting_code() throws Exception{
		Thread.sleep(1000);

		List<WebElement> li  = driver.findElements(sort_code);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}
	public void sort_name() throws Exception{
		Thread.sleep(1000);

		List<WebElement> list  = driver.findElements(sort_name);
		for (WebElement e : list) {
			System.out.println(e.getText());
		}

	}

	public void sort_inmates() throws Exception{
		Thread.sleep(1000);

		List<WebElement> li  = driver.findElements(sort_inmates);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}
	public void sort_kiosk() throws Exception{
		Thread.sleep(1000);

		List<WebElement> list  = driver.findElements(sort_kiosk);
		for (WebElement e : list) {
			System.out.println(e.getText());
		}

	}

	public void sort_shared() throws Exception{
		Thread.sleep(1000);

		List<WebElement> li  = driver.findElements(sort_shared);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	/* code for scroll*/
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
	}

	private void scroll1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(-250,-350)");
	}

}
