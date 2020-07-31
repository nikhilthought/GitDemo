import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class switchwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='gb_70']")).click();
		driver.findElement(By.xpath("//*[@id='initialView']/footer/ul/li[1]/a")).click();
		Set<String> w = driver.getWindowHandles();
		Iterator<String> it = w.iterator();
		String Parent = it.next(); 
		String Child = it.next();
		System.out.println("Before switching to Child window");
		driver.switchTo().window(Child);
		System.out.println("After switched to Child window");
		System.out.println(driver.getTitle());
		driver.switchTo().window(Parent);
		System.out.println("After switched to Parent window");
		System.out.println(driver.getTitle());
		
		

	}

}
