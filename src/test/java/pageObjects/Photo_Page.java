package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

//import com.framework.screenshot.CaptureScreenshot;











import utility.Log;

public class Photo_Page {
	
	public WebDriver driver;
	By menu_photo = By.id("rptUser_menuAnchor_13");
	By lnk_photo = By.id("lblPhotoSubject");		
	By btn_approve = By.id("ContentPlaceHolder1_btnApprove");
	By btn_reject = By.id("ContentPlaceHolder1_btnReject");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	By btn_popup = By.id("btnOk");
	By btn_yes = By.id("btnYes");
	By dwn_PU_lastname = By.xpath("//*[@id='ddlPublicUserLastNameSearch_chosen']/div/div/input");
	By btn_reset = By.id("ContentPlaceHolder1_btnReset");
	By lnk_subject = By.xpath("//*[@id='grvPhotosInfo']/tbody/tr[1]/th[1]/a");
	By lnk_from = By.xpath("//*[@id='grvPhotosInfo']/tbody/tr[1]/th[2]/a");
	By lnk_to = By.xpath("//*[@id='grvPhotosInfo']/tbody/tr[1]/th[3]/a");
	By lnk_sent_on = By.xpath("//*[@id='grvPhotosInfo']/tbody/tr[1]/th[4]/a");
	By sort_subject = By.id("lblPhotoSubject");
	By sort_from = By.id("lblFrom");
	By sort_to = By.id("lblTo");
	By sort_on = By.id("lblPhotoSentDate");
	
	public void Edit_photo(){
		try{
		this.driver = new Login_Page().getDriver();			
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(menu_photo).click();
		Log.info("Photo menu has been chosen");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(dwn_PU_lastname));\
		driver.findElement(By.xpath("//*[@id='ddlPublicUserLastNameSearch_chosen']/a/span")).click();
		Thread.sleep(4000);
		WebElement autoOptions= driver.findElement(dwn_PU_lastname);
	    autoOptions.sendKeys("pr");
	    Log.info("Last name has been chosen");
	    Thread.sleep(4000);
		List<WebElement> element = driver.findElements(lnk_photo);
		element.get(0).click();
		Log.info("Photo has been chosen");		
		photo_reject();
		Thread.sleep(1000);
		driver.findElement(btn_yes).click();
		Log.info("Yes button clicked");
		Thread.sleep(1000);
		driver.findElement(btn_popup).click();
		Log.info("Popup button clicked");
		Thread.sleep(1000);
		driver.findElement(btn_reset).click();
		Log.info("Reset button clicked");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void photo_approve() throws Exception{
		Thread.sleep(1000);
		driver.findElement(btn_approve).click();
		Log.info("Approve button clicked");
	}
	
	public void photo_reject() throws Exception{
		Thread.sleep(1000);
		driver.findElement(btn_reject).click();
		Log.info("Reject button clicked");
	}
	
	public void sort_photo() throws Exception{
		this.driver = new Login_Page().getDriver();			
		Logger Log=Logger.getLogger("Login_Page");
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(menu_photo).click();
		Log.info("Photo menu has been chosen");
		Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
		sel.selectByValue("105");	
		Thread.sleep(1000);
		
		driver.findElement(lnk_subject).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_subject();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(lnk_subject).click();
		Thread.sleep(1000);
		sort_subject();

		driver.findElement(lnk_from).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_from();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(lnk_from).click();
		Thread.sleep(1000);
		sort_from();

		driver.findElement(lnk_to).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_to();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(lnk_to).click();
		Thread.sleep(1000);
		sort_to();

		driver.findElement(lnk_sent_on).click();
		System.out.println("Before Sorting");
		System.out.println("*************");
		Thread.sleep(1000);
		sort_sent();
		System.out.println("After Sorting");
		System.out.println("*************");
		driver.findElement(lnk_sent_on).click();
		Thread.sleep(1000);
		sort_sent();
		
	}
	
	public void sort_subject(){
		List<WebElement> li = driver.findElements(sort_subject);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_from(){
		List<WebElement> li = driver.findElements(sort_from);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_to(){
		List<WebElement> li = driver.findElements(sort_to);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}

	public void sort_sent(){
		List<WebElement> li = driver.findElements(sort_on);
		for (WebElement e : li) {
			System.out.println(e.getText());
		}
	}
}
