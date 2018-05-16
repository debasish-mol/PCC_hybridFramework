package AppPages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Factory.DataProviderFactory;

public class loginPages {
	
	WebDriver driver;
	
	//List<WebElement> data;
	
	public loginPages(WebDriver driver)
	{
		this.driver=driver;
		
		// data= driver.findElements(By.xpath("//div/input"));
	}

	@FindBy(xpath="//input[@type='text']") WebElement userName;
	
	@FindBy(xpath="//input[@type='password']") WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	
	
	public void loginInfo()
	{
		userName.sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
		password.sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
		login.click();
	}
	
	
	
}
