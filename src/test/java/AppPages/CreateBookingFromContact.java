package AppPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//div[@id='treeview-left-view']/ul/li/ul/li") List<WebElement> allCargo;
	
	@FindBy(xpath="//div[@id='CreateBkgRevGrid']/table/thead/tr/th[3]") WebElement selectAllRevenue;
	
	@FindBy(xpath = "//span[@id='ContractBKGWindow_wnd_title']") WebElement addRevenueForSelectedCargo;
	
	@FindBy(xpath="//input[@id='btnConfirm']") WebElement addRevenueConfirm;
	
	
	
	public void selctCargo(String cargoName)
	{
		
		int totalCargoNo = allCargo.size();
		
		for(int i=1;i<=totalCargoNo;i++)
		{
			
			WebElement cargo = driver.findElement(By.xpath("//div[@id='treeview-left-view']/ul/li/ul/li["+ i +"]/div/span[3]/div"));
			
			//System.out.println("Model name "+cargo.getText());
			
			if(cargo.getText().equalsIgnoreCase(cargoName))
			{
				WebElement checkBox = driver.findElement(By.xpath("//*[@id='treeview-left-view']/ul/li/ul/li["+i+"]/div/span[2]/input"));
				
				checkBox.click();
				
				break;
				
			}
			
			
		}
		
		
	}
	
	 
		
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
		
				
		WebDriverWait waitContTree = new WebDriverWait(driver,20);
		
		waitContTree.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='treeview-left-view']/ul/li/ul/li/div/span[3]/div")));
		
		
		
		WebDriverWait waitContractSearch = new WebDriverWait(driver,20);
		
		waitContractSearch.until(ExpectedConditions.elementToBeClickable(CreateBookingButton));
		
		
		CreateBookingButton.click();
		
		WebDriverWait waitAllRevenue = new WebDriverWait(driver,20);
		
		waitAllRevenue.until(ExpectedConditions.textToBePresentInElement(addRevenueForSelectedCargo,"Add Revenue For Selected Cargo"));
		
		selectAllRevenue.click();
		
		addRevenueConfirm.click();
		
		
				
	}
	
	
}
