import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class UIElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");
		
		Select s1 = new Select(driver.findElement(By.id("Childrens")));
		s1.selectByIndex(2);
		
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='MoreOptionsLink']")).click();
		
		WebElement dest = driver.findElement(By.xpath("//*[@id='AirlineAutocomplete']"));
		dest.sendKeys("SpiceJet");
		Thread.sleep(5000);
		dest.sendKeys(Keys.ARROW_DOWN);
		dest.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//*[@id='SearchBtn']")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\'homeErrorMessage\']")).getText());
	}

}
