import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchwindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//*[@id='content']/ul/li[33]/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
		Set<String> w =  driver.getWindowHandles();
		Iterator<String> its = w.iterator();
		String P = its.next();
		String C = its.next();
		driver.switchTo().window(C);
		System.out.println(driver.findElement(By.xpath("/html/body/div/h3")).getText());
		driver.switchTo().window(P);
		System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText());
		
		
		
	}

}
