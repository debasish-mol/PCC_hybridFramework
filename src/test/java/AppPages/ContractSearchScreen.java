package AppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContractSearchScreen {

	WebDriver driver;
	
	public ContractSearchScreen(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[@aria-owns='ddlContractType_listbox']/span/span[text()='All']") WebElement contTypeSelect;
	
	@FindBy(xpath="//ul[@id='ddlContractType_listbox']/li") List<WebElement> contParticularTypeSelect; 
	
	@FindBy(xpath="//input[@id='txtContractNo']") WebElement contNumber;
	
	@FindBy(xpath="//input[@id='txtContractName']") WebElement contName;
	
	@FindBy(xpath="//input[@id='txtMainCustName']") WebElement contMainCustomer;
	
	@FindBy(xpath="//input[@id='txtFromRegion']") WebElement contFromRegion;
	
	@FindBy(xpath="//input[@id='txtToRegion']") WebElement contToRegion;
	
	@FindBy(xpath="//input[@id='txtFromPort']") WebElement contFromPort;
	
	@FindBy(xpath="//input[@id='txtToPort']") WebElement contToPort;
	
	@FindBy(xpath="//span[@aria-owns='txtCargoType_listbox']/span/span[text()='All']") WebElement contCargoType;
	
	@FindBy(xpath="//ul[@id='txtCargoType_listbox']/li")  List<WebElement> conParticularCargoSelect;
	
	@FindBy(xpath="//input[@id='txtMake']") WebElement contMake;
	
	@FindBy(xpath="//input[@id='txtModel']") WebElement contModel;
	
	@FindBy(xpath="//span[@aria-owns='ddlStatus_listbox']/span/span[text()='All']") WebElement contStatus;
	
	@FindBy(xpath="//ul[@id='ddlStatus_listbox']/li") List<WebElement> conStatusSelect;
	
	@FindBy(xpath="//input[@id='chkExpiredContract']") WebElement expiredContCheckBox;
	
	@FindBy(xpath="//input[@id='btnClearSearch']") WebElement clearSearch;
	
	@FindBy(xpath="//input[@id='btnSearchContract']") WebElement searchContract;
	
	@FindBy(xpath="//input[@id='btnEdit']") WebElement editContact;
	
	
	public void enterContactNumber(String number)
	{
		contNumber.sendKeys(number);
	}
	
	
	public void clickOnSearch()
	{
		searchContract.click();
		
		WebDriverWait waitContractSearch = new WebDriverWait(driver,15);
		
		waitContractSearch.until(ExpectedConditions.visibilityOf(editContact));
		
		
	}
	
	
	public void clickOnEditContact()
	{
		editContact.click();		
		
	}
	
	public void waitForScreenLoad()
	{
		WebDriverWait waitScreenLoad = new WebDriverWait(driver,15);
		
		waitScreenLoad.until(ExpectedConditions.visibilityOf(searchContract));
	}
	
	
}
