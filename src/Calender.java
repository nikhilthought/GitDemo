import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.spicejet.com/");
		d.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		List<WebElement> days= d.findElements(By.className("ui-state-default"));
		int ndays = d.findElements(By.className("ui-state-default")).size();
		
		
		while(!d.findElement(By.className("ui-datepicker-title")).getText().contains("June"))
		{
			d.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
			
		}
		
		for(int i=0;i<ndays;i++)
		{
			d.findElements(By.className("ui-state-default")).get(i).getText();
			
			if(d.findElements(By.className("ui-state-default")).get(i).getText().contains("26"))
			{
				d.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
			
			
		}
		

	}

}
