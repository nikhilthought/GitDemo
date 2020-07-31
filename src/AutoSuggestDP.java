import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("http://qaclickacademy.com/practice.php");
		
		d.findElement(By.id("autocomplete")).click();
		WebElement source = d.findElement(By.id("autocomplete"));
		source.sendKeys("Ind");
		
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		String s = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(s);
		
		int i=0;
		while(!text.equalsIgnoreCase("India"))
		{
			i++;
			source.sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(s);
			System.out.println(text);
			
			if(i>6)
			{
				break;
			}
		}
		
		if(i>6)
		{
			System.out.println("Element not found");
		}
		else
		{
			System.out.println("Element found");
		}
		
		
	}

}
