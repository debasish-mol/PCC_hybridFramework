package AppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractSearchScreen {

	WebDriver driver;
	
	public ContractSearchScreen(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@aria-owns='ddlContractType_listbox']/span/span[text()='All']") WebElement ContTypeSelect;
	
	@FindBy(xpath="//ul[@id='ddlContractType_listbox']/li") List<WebElement> ContParticularTypeSelect; 
	
	@FindBy(xpath="//input[@id='txtContractNo']") WebElement ContNumber;
	
	@FindBy(xpath="//input[@id='txtContractName']") WebElement ContName;
	
	@FindBy(xpath="//input[@id='txtMainCustName']") WebElement ContMainCustomer;
	
	@FindBy(xpath="//input[@id='txtFromRegion']") WebElement ContFromRegion;
	
	@FindBy(xpath="//input[@id='txtToRegion']") WebElement ContToRegion;
	
	@FindBy(xpath="//input[@id='txtFromPort']") WebElement ContFromPort;
	
	@FindBy(xpath="//input[@id='txtToPort']") WebElement ContToPort;
	
	@FindBy(xpath="//span[@aria-owns='txtCargoType_listbox']/span/span[text()='All']") WebElement ContCargoType;
	
	@FindBy(xpath="//ul[@id='txtCargoType_listbox']/li")  List<WebElement> ConParticularCargoSelect;
	
	@FindBy(xpath="//input[@id='txtMake']") WebElement ContMake;
	
	
	@FindBy(xpath="//input[@id='txtModel']") WebElement ContModel;
	
	@FindBy(xpath="//span[@aria-owns='ddlStatus_listbox']/span/span[text()='All']") WebElement ContStatus;
	
	@FindBy(xpath="//ul[@id='ddlStatus_listbox']/li") List<WebElement> ConStatusSelect;
	
	@FindBy(xpath="//input[@id='chkExpiredContract']") WebElement ExpiredContCheckBox;
	
	@FindBy(xpath="//input[@id='btnClearSearch']") WebElement ClearSearch;
	
	@FindBy(xpath="//input[@id='btnSearchContract']") WebElement SearchContract;
	
	@FindBy(xpath="//input[@id='btnEdit']") WebElement EditContact;
	
	
	public void EnterContactNumber(String number)
	{
		ContNumber.sendKeys(number);
	}
	
	
	public void ClickOnSearch()
	{
		SearchContract.click();
	}
	
	
	public void ClickOnEditContact()
	{
		EditContact.click();		
		
	}
	
	
	
	
}
