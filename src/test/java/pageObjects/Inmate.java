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

//import utility.Log;

public class Inmate {

	public  WebDriver driver;
	By lnk_inmate_id = By.id("lnkInmateResidentId");
	By txt_id = By.id("ContentPlaceHolder1_txtInmateIDSearch");
	By btn_search = By.id("btnSearch");
	By lnk_inmate = By.id("rptUser_menuAnchor_9");
	By lst_edit = By.id("lnkInmateResidentId");
	By menu_message = By.xpath("//*[@id='ContentPlaceHolder1_anchrMessages']/i/span");
	By menu_photo = By.xpath("//*[@id='ContentPlaceHolder1_anchrPhotos']/i/span");
	By menu_free_credits = By.xpath("//*[@id='ContentPlaceHolder1_achrFreeCreditsInfo']/i/span");
	By txt_investigator_mail = By.id("ContentPlaceHolder1_txtInvestigatorEmail");
	By btn_update = By.id("btnSaveInmateInformation");
	By btn_ok = By.id("btnOk");
	By btn_back = By.id("ContentPlaceHolder1_btnFreeCreditsBack");
	By btn_reset = By.id("btnReset");
	By lnk_subject = By.id("lblMessageSubject");
	By btn_translate = By.id("lnkbtnTranslate");
	By btn_message_back = By.id("ContentPlaceHolder1_btnBack");
	By lnk_photo_subject = By.id("lblPhotoSubject");
	By btn_photo_back = By.id("ContentPlaceHolder1_btnBack");
	By export_excel = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By pagination = By.xpath("//*[@id='grvInmates']/tbody/tr[12]/td/table/tbody/tr/td[2]/a");
	By lnk_publicuser_sort = By.xpath("//*[@id='grvInmatesInfo']/tbody/tr[1]/th[1]/a");
	//By sort_publicuser = By.xpath("//*[@id='grvInmatesInfo']/tbody/tr[1]/th[1]/a");
	
	
	
	public void Edit_Inmate() throws Exception{
		try {
			this.driver = new Login_Page().getDriver();
			Thread.sleep(1000);
			Logger logger=Logger.getLogger("Login_Page");
			PropertyConfigurator.configure("log4j.properties");
			Thread.sleep(1000);			
			driver.findElement(lnk_inmate).click();
			Select sel = new Select(driver.findElement(By.id("ddlFacilityCodes")));
			sel.selectByValue("105");
			Thread.sleep(1000);			
			driver.findElement(txt_id).sendKeys("11");
			logger.info("Id has been entered ");	
			driver.findElement(btn_search).click();
			logger.info("search has been clicked ");
			Thread.sleep(1000);	
			List<WebElement> elements = driver.findElements(lst_edit);
			elements.get(0).click();
			logger.info("Edit has been chosen");
			Thread.sleep(2000);
			Edit_Info();
			logger.info("Investigator mail added successfully");
			/*webdriverWait(lnk_publicuser_sort, 50);
			driver.findElement(lnk_publicuser_sort).click();
			//scroll();
			Thread.sleep(1000);
			Sorting();
			logger.info("PU user sorted successfully");*/
			
			
			driver.findElement(menu_message).click();
			logger.info("Message Tab has been clicked");
			Thread.sleep(2000);
			List<WebElement> element1 = driver.findElements(lnk_subject);
			element1.get(3).click();
			logger.info("Message link has been clicked");
			Thread.sleep(1000);
			driver.findElement(btn_translate).click();
			logger.info("Translate button clicked");
			Thread.sleep(10000);
			driver.findElement(btn_message_back).click();
			logger.info("Messages back button has been clicked");			
			driver.findElement(menu_photo).click();
			logger.info("Photo Tab has been clicked");		
			Thread.sleep(2000);
			List<WebElement> element2 = driver.findElements(lnk_photo_subject);
			element2.get(1).click();
			logger.info("Photo link has been clicked");
			driver.findElement(btn_photo_back).click();
			Thread.sleep(1000);
			logger.info("Photo Back Button has been clicked");
			Thread.sleep(1000);
			driver.findElement(menu_free_credits).click();
			logger.info("Free credits Tab has been clicked");
			Thread.sleep(1000);
			driver.findElement(btn_back).click();
			Thread.sleep(1000);
			driver.findElement(btn_reset).click();
			Thread.sleep(1000);
			driver.findElement(export_excel).click();
			logger.info("Export to excel link clicked");
			//Thread.sleep(1000);
			scroll();
			webdriverWait(pagination, 50);
			driver.findElement(pagination).click();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public void Edit_Info(){
		try {
			driver.findElement(txt_investigator_mail).clear();
			driver.findElement(txt_investigator_mail).sendKeys("mangaipriya@themajesticpeople.com");
			driver.findElement(btn_update).click();
			Thread.sleep(2000);
			driver.findElement(btn_ok).click();
			Thread.sleep(2000);
			List<WebElement> elements = driver.findElements(lst_edit);
			elements.get(0).click();
					
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

	}
	

	/* code for scroll*/
	private void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
	}

	/* code for explicit wait*/
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void Sorting() throws Exception{
		
		
		List<WebElement> alllinks =driver.findElements(By.id("lblInmateResidentId"));
	    String a[]=new String[alllinks.size()];
	   
	    for(int i=0;i<alllinks.size();i++)
	    {
	        a[i]=alllinks.get(i).getText(); 
	        System.out.println(a[i]);
	     
	    }
}
	
	public void Edit_Message(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
