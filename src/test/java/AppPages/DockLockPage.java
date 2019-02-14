package AppPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DockLockPage {
	
public WebDriver driver;
	
	public DockLockPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='VslName']") WebElement vsl_name;
	
	@FindBy(xpath="//input[@id='VslCode']") WebElement vsl_code;
	
	@FindBy(xpath="//input[@id='VoyNo']") WebElement voy_code;
	
	@FindBy(xpath="//input[@id='PortAbrv']") WebElement port;
	
	@FindBy(xpath="//input[@id='PortCode']") WebElement port_code;
	
	@FindBy(xpath="//input[@id='CallOrd']") WebElement call_order;
	
	@FindBy(xpath="//input[@id='btnClear']") WebElement clear_button;
	
	@FindBy(xpath="//input[@id='btnSearch']") WebElement search_button;
	
	@FindBy(xpath="//div[@id='gridPortSearchResult']/table/tbody/tr/td[2]") List<WebElement> portCount;
	
	@FindBy(xpath="//textarea[@id='BlNos']") WebElement enterBLs;
	
	@FindBy(xpath="//input[@id='btnSearchBls']") WebElement searchBL;
	
	@FindBy(xpath="//input[@id='chkSelectAll']") WebElement checkBoxAll;
	
	@FindBy(xpath="//input[@id='btnBlWiseDocLock']") WebElement process;
	
	@FindBy(xpath="//input[@id='uxMsg-button1']") WebElement msgYes;
	
	
	
	
	
	
	
	public void enter_vsl_name(String name)
	{
		vsl_name.clear();
		
		vsl_name.sendKeys(name);
		
			try
			{
				
				Thread.sleep(2000);
				
			} catch (InterruptedException evsl)
			{
				evsl.printStackTrace();
			}
		}
				
		
	
	
	
	
	public void enter_voy_code(String voyName)
	{
		voy_code.clear();
		
		voy_code.sendKeys(voyName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException evoy)
		{
			
			evoy.printStackTrace();
		}
		
	}
	
	public void enter_portName(String portName)
	{
		
		port.clear();
		
		port.sendKeys(portName);
		
				try
				{
					
					Thread.sleep(2000);
					
				} catch (InterruptedException evsl)
				{
					evsl.printStackTrace();
				}
			
					
			
		}
		
	
	public void enter_call_order(String callOrder)
	{
		
		call_order.clear();
		
		call_order.sendKeys(callOrder);
		
		
	}
	
	
	public void click_Clear_Button()
	{
		clear_button.click();
	}
	
	public void click_Search_Button()
	{
		search_button.click();
		
		WebDriverWait waitvalue = new WebDriverWait(driver,10);
		
		waitvalue.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='gridPortSearchResult']/table/tbody/tr/td")));
		
		try {
			
			Thread.sleep(2000);
		
		} catch (InterruptedException eSearch) {
			
			eSearch.printStackTrace();
		}
	}
		
	
	public void selectPort(String portName,String BLNOS)
	{
		int TotalNoOfPort = portCount.size();
		
		for(int i=1;i<=TotalNoOfPort;i++)
		{
			//By.xpath(//div[@id='gridPortSearchResult']/table/tbody/tr[i]/td[2]).
			
			System.out.println("value of i "+i);
			
			WebElement portcode = driver.findElement(By.xpath("//div[@id='gridPortSearchResult']/table/tbody/tr[" + i + "]/td[2]"));
			
			System.out.println("port name "+portcode.getAttribute("title"));
			
			if(portcode.getAttribute("title").equalsIgnoreCase(portName))
			{
				System.out.println("Selected port name "+ portcode.getAttribute("title"));
				
				//portcode.click();
				
				WebElement gear = driver.findElement(By.xpath("//div[@id='gridPortSearchResult']/table/tbody/tr[" + i + "]/td[1]"));
				
				gear.click();
				
				try {
					
					Thread.sleep(2000);
					
				} catch (InterruptedException eGear) {
					
					eGear.printStackTrace();
				}
				
				WebElement BLWiseDoc = driver.findElement(By.xpath("html/body/table/tbody/tr/td/div/div[7]/div"));
				
				BLWiseDoc.click();
				
				try {
					
					Thread.sleep(1500);
					
				} catch (InterruptedException eBLPopup) {
					
					eBLPopup.printStackTrace();
				}
				
				enterBLs.sendKeys(BLNOS);
				
				searchBL.click();
				
				try {
					Thread.sleep(2000);
				
				} catch (InterruptedException eBlSearch) {
					
					eBlSearch.printStackTrace();
				}
				
				checkBoxAll.click();
				
				process.click();
				
				try {
					Thread.sleep(1000);
				
				} catch (InterruptedException econf) {
					
					econf.printStackTrace();
				}
				
				msgYes.click();
				
				
				
				
				break;
			}
			
		}
		
	}
	
	
	
	}


