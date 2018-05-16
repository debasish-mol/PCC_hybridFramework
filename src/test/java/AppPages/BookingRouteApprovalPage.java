package AppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingRouteApprovalPage {
	
	public WebDriver driver;
	
	public BookingRouteApprovalPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='txtBookingNo']") WebElement Booking_No_appv;
	
	@FindBy(xpath="//input[@id='btnPCLSearch']") WebElement Search_appv;
	
	@FindBy(xpath="//input[@id='chk5117']") WebElement SelectRecord;
	
	@FindBy(xpath="//input[@id='btnLineUpdate']") WebElement ApproveButton;
	
	@FindBy(xpath="//*[@id='pclMassApprovalWindowContent']/div/div[1]/div[5]/span/span/span[2]/span") WebElement RouteStatusLov;
	
	@FindBy(xpath="//ul[@id='ddlArrangeStatus_listbox']/li") List<WebElement> RouteStatusList;
	
	@FindBy(xpath="//input[@id='btnMassLineApproveSave']") WebElement SaveButton;
	
	
	public void EnterBooking_No_appv(String bkg_no)
	{
		Booking_No_appv.sendKeys(bkg_no);
	}
	
	
	public void ClickOnSearch()
	{
		Search_appv.click();
		
	}
	
	public void CheckBookingRecord()
	{
		SelectRecord.click();
	}
	
	
	public void ClickOnApproveButton()
	{
		ApproveButton.click();
		
	}
	
	public void SelectRouteStatus(String status) throws InterruptedException
	{
		RouteStatusLov.click();    //Approved  Not Approved   Rejected
		
		Thread.sleep(1500);
		
		for(WebElement e: RouteStatusList)
		{
			System.out.println("Insider for loop route select");
			
			if(e.getText().equals(status))
			{
				System.out.println("Selected Status "+e.getText());
				e.click();
				break;
			}
				
		}
		
		
		SaveButton.click();
		
	}

}
