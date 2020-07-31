import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("http://qaclickacademy.com/practice.php");
		
	    JavascriptExecutor js =  (JavascriptExecutor)d;
	    js.executeScript("window.scrollBy(0,300)");
		
		WebElement t = d.findElement(By.cssSelector("table[id='product']"));
		
		System.out.println("Total row count "  +"\t" + t.findElements(By.xpath("//tr")).size());
		System.out.println("Total Column count " +"\t" + t.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> srow = t.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println(srow.get(0).getText());
		System.out.println(srow.get(1).getText());
		System.out.println(srow.get(2).getText());
		
		Thread.sleep(5000);
		d.close();

	}

}
