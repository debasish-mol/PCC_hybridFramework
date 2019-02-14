package AppPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageIndex 
{
	
public WebDriver driver;
	
	public HomePageIndex(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[text()='Operational']") WebElement operation;
	
	@FindBy(xpath="//span[text()='Documentation']") WebElement documentation;
	
	@FindBy(xpath="//a[text()='B/L Create']") WebElement blCreate;
	
	
	public void mouseMoveToOperational()
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(operation).click().build().perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException eOpera) {
			
			eOpera.printStackTrace();
		}
		
		
	}
	
	public void mouseMoveToDocumentation()
	{
		
		Point documentationPoint = documentation.getLocation();
		 
		 Robot robot;
		 
		try {
			robot = new Robot();
			
			 robot.mouseMove(documentationPoint.getX(),documentationPoint.getY()+120);
			
		} catch (AWTException eRobot) {
			
			eRobot.printStackTrace();
		}
		
		 		 	
		try {
			
			Thread.sleep(1500);
		} catch (InterruptedException eDoc) {
			
			eDoc.printStackTrace();
		}
				
	}
	
	public void clickOnCreateBL()
	{
		
		blCreate.click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		//Thread.sleep(4000);
		
		for(String s :allWindow )
		{
			driver.switchTo().window(s);
			
			driver.manage().window().maximize();
			
						
		if(driver.getTitle().contains("Create B/Ls"))
		{
			System.out.println("Inside If loops");
			break;
		}
			
				
		}
		
		
	}
	
	

}
