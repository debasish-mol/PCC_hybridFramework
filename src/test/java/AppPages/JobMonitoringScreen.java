package AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobMonitoringScreen {
	
	
public WebDriver driver;
	
	public JobMonitoringScreen(WebDriver driver) 
	{
		this.driver=driver;
	}

	@FindBy(xpath="//div[@class='window_title']/h2") WebElement pageTitle;
	
	@FindBy(xpath="//input[@id='JobNo']") WebElement jobNo;
	
	@FindBy(xpath="//div[@id='gridJobs']/table/tbody/tr[1]/td[7]") WebElement jobStatus;
	
	@FindBy(xpath="//div[@id='gridJobs']/div/a[5]/span[text()='Refresh']") WebElement refresh;
	
	
	public String getTitle()
	{
		return pageTitle.getText();
	}
	
	public String getStatus()
	{
		return jobStatus.getText();
	}
	
	public void clickOnRefresh()
	{
		refresh.click();
	}
	
}
