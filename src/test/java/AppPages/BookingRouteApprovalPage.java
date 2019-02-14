package AppPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingRouteApprovalPage {
	
	public WebDriver driver;
	
	public BookingRouteApprovalPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='txtBookingNo']") WebElement Booking_No_appv;
	
	@FindBy(xpath="//input[@id='btnPCLSearch']") WebElement Search_appv;
	
	//@FindBy(xpath="//input[@id='chk5117']") WebElement SelectRecord;
	
	@FindBy(xpath="//input[@name='chkStatus']") WebElement SelectRecord;
	
	@FindBy(xpath="//input[@id='btnLineUpdate']") WebElement ApproveButton;
	
	//@FindBy(xpath="//div[@id='pclMassApprovalWindowContent']/div/div[1]/div[5]/span/span/span[2]/span") WebElement RouteStatusLov;
	
	@FindBy(xpath=".//*[@id='pclMassApprovalWindowContent']/div/div[1]/div[2]/span/span/span[1]") WebElement RouteStatusLov;
	
	@FindBy(xpath="//ul[@id='ddlArrangeStatus_listbox']/li") List<WebElement> RouteStatusList;
	
	@FindBy(xpath="//input[@id='btnMassLineApproveSave']") WebElement SaveButton;
	
	@FindBy(xpath="//div[@id='gridPclSearch']/div[3]/table/tbody/tr/td[18]/a") WebElement BookingRtSts;
	
	@FindBy(xpath="html/body/div[2]/div[3]/div/div[3]/div[4]") WebElement transactionMsg;
	
	
	public void EnterBooking_No_appv(String bkg_no)
	{
		Booking_No_appv.sendKeys(bkg_no);
		
		try {
			
			Thread.sleep(1500);
			
		} catch (InterruptedException eSearchBkgNo) {
			
			System.out.println("Exception in booking no"+eSearchBkgNo);
		}
	}
	
	
	public void ClickOnSearch()
	{
		Search_appv.click();
		
		
	}
	
	public void CheckBookingRecord()
	{
		WebDriverWait waitSearchBooking = new WebDriverWait(driver,10);
		
		waitSearchBooking.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='gridPclSearch']/div[2]/table/tbody/tr/td")));
		
		SelectRecord.click();
	}
	
	
	public void ClickOnApproveButton()
	{
				
		ApproveButton.click();
		
		
		
	}
	
	public void SelectRouteStatus(String status) throws InterruptedException
	{
		WebDriverWait waitMassApproval = new WebDriverWait(driver,10);
		
		waitMassApproval.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pclMassApprovalWindow_wnd_title']")));
		
		RouteStatusLov.click();    //Approved  Not Approved   Rejected
		
		WebDriverWait waitApprvStatusList = new WebDriverWait(driver,10);
		
		waitApprvStatusList.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ddlArrangeStatus_listbox']/li[1]")));
		
		
		for(WebElement e: RouteStatusList)
		{
			//System.out.println("Insider for loop route select");
			
			if(e.getText().equals(status))
			{
				//System.out.println("Selected Status "+e.getText());
				e.click();
				break;
			}
				
		}
		
		
		SaveButton.click();
		
		
		
	}
	
	public void getBookingRtSts()
	{
	
	WebDriverWait waitSuccessMsg = new WebDriverWait(driver,10);
	//waitSuccessMsg.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("div[@class='success']")));
	
	waitSuccessMsg.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[4]")));
	
	if(transactionMsg.getText().contains("success"))
	{
		System.out.println("Booking Route Saved successfully");
	}
	
	//System.out.println("Booking Sts after save");
	
	String BkgRtSts = BookingRtSts.getText();
	
	System.out.println("Booking Route Approval Status "+BkgRtSts);
	
	}

}
