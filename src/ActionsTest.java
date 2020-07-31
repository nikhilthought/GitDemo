import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		if(login(driver))
		{
			if(verifyLogin(driver))
			{
				System.out.println("Test case is passed");
			}
			
			else
			{
				System.out.println("Test case is failed");
			}
		}
		else
		{
			System.out.println("Test case is failed");
		}
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[3]/a"))).moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[3]/ul/li[3]/a"))).moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[3]/ul/li[3]/ul/li/a"))).click().build().perform();
		
		
}
	
	public static boolean login(WebDriver driver)
	{
	
	String username = "Admin";
	String password = "admin123";
	try {
		
		if(driver.getTitle().contains("OrangeHRM")) 
		{
		
			System.out.println("Web Application is opened successfully");
		
			//performing an operation by storing control in web-element
			WebElement d=driver.findElement(By.xpath("//input[@id='txtUsername']"));
			d.sendKeys(username);
			
			//search element and perform operation
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
			
			//click on loginbutton
			driver.findElement(By.id("btnLogin")).click();
			return true;
				
	}
		else
		{
			System.out.println("Web Application is not opened");
			return false;
		}
	}
	catch (Exception e) 
	{
		// TODO: handle exception
		System.out.println(e.getMessage());
		return false;
	}
	
}
	
	public static boolean verifyLogin(WebDriver driver)
	{
		
		try 
		{
		
			if(driver.findElement(By.id("welcome")).isDisplayed())
			{
				System.out.println("User got logged in successfully");
			}
			else
			{
				System.out.println("User not logged in successfully");
			}
			return true;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}
	
}
