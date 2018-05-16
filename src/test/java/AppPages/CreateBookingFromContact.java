package AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBookingFromContact {
	
	public WebDriver driver;
	
	
	public CreateBookingFromContact(WebDriver driver)
	{
		this.driver=driver;
	}
	

	@FindBy(xpath="//input[@id='txtContractNo']") WebElement Contact_No;
	
	@FindBy(xpath="//input[@id='btnSearchContract']") WebElement SearchButton;
	
	@FindBy(xpath="//div[@id='gridContract']/table/tbody/tr/td[5]/a") WebElement ContactNoLink;
	
	@FindBy(xpath="//input[@id='btnContractBookingTop']") WebElement CreateBookingButton;
	
	 
		
	public void EnterContactNo(String no)
	{
		Contact_No.sendKeys(no);
	}
	
	
	public void ClickOnSearch()
	{
		SearchButton.click();
	}
	
	
	public void ClickOnContactNoLink()
	{
		ContactNoLink.click();
		
	}
	
	
	public void ClickOnCreateButton()
	{
		CreateBookingButton.click();
	}
	
	
}
