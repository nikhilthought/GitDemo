import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		d.get("https://www.spicejet.com/");
		
		//select from cities and to cities
		d.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		d.findElement(By.xpath("*//a[@value='PNQ']")).click();
		d.findElement(By.xpath("//*[@id='dropdownGroup1']/div/ul[1]/li[7]/a")).click();
		
		//select departure date
		//d.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[6]/td[1]/a")).click(); // hardcoded
		
		//dynamic selection
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

		
		if(d.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Its Enabled");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		//select passenger
		Assert.assertFalse(d.findElement(By.id("divpaxinfo")).isSelected());
		d.findElement(By.id("divpaxinfo")).click();
		
		Assert.assertFalse(d.findElement(By.id("ctl00_mainContent_ddl_Adult")).isSelected());
		Select s = new Select(d.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("2");
		
		
		
		
		Select s1= new Select(d.findElement(By.id("ctl00_mainContent_ddl_Child")));
		s1.selectByIndex(1);
		
		Assert.assertFalse(d.findElement(By.id("divpaxinfo")).isSelected());
		d.findElement(By.id("divpaxinfo")).click();
		System.out.println(d.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(d.findElement(By.id("divpaxinfo")).getText(), "2 Adult, 1 Child");
		
		
		//hit search
		Assert.assertFalse(d.findElement(By.id("ctl00_mainContent_btn_FindFlights")).isSelected());
		d.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
			

		Thread.sleep(5000L);
		d.close();
	}

}
