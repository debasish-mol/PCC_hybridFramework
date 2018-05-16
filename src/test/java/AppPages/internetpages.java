package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class internetpages {
	
	public WebDriver driver1;
	
	public internetpages(WebDriver ldriver)
	{
		driver1=ldriver;
	
	}
	
			
	WebElement userName = driver1.findElement(By.id("username"));
	WebElement Password = driver1.findElement(By.id("password"));
	WebElement login = driver1.findElement(By.xpath("//button"));
	
	/*
	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement Password;
	@FindBy(xpath="//button") WebElement login;
	*/
	
	public void loginpages(String user,String pass)
	{
		
		userName.sendKeys(user);
		Password.sendKeys(pass);
		login.click();
		
	}
	

}
