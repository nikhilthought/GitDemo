import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestAutoSDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver(options);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.get("https://www.travelyaari.com/");
		d.findElement(By.id("crossCor")).click();
		WebElement srcloc = d.findElement(By.id("from-city"));
		srcloc.sendKeys("Shir");
		
		Thread.sleep(5000);
		
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		String srcloc1 = "return document.getElementById(\"from-city\").value;";
		String fromcity = (String) js.executeScript(srcloc1);
		int i=0;
		while(!fromcity.equalsIgnoreCase("Shirpur"))
		{
			i++;
			srcloc.sendKeys(Keys.ARROW_DOWN);
			fromcity = (String) js.executeScript(srcloc1);
			
			if(i>20)
			{
				break;
			}
			
		}
		if(i<18)
		{
			System.out.println("From City match found");
		}
		else
		{
			System.out.println("From City match not found");
		}
		
		srcloc.sendKeys(Keys.TAB);
		
		
		WebElement destloc = d.findElement(By.id("to-city"));
		destloc.sendKeys("Pan");
		
		Thread.sleep(5000);
		
		JavascriptExecutor js1 = (JavascriptExecutor)d;
		String destloc1 = "return document.getElementById(\"to-city\").value;";
		String tocity = (String) js.executeScript(destloc1);
		int j=0;
		while(!tocity.equalsIgnoreCase("Panvel  Navi Mumbai"))
		{
			j++;
			destloc.sendKeys(Keys.ARROW_DOWN);
			tocity = (String) js.executeScript(destloc1);
			
			if(j>20)
			{
				break;
			}
			
		}
		if(j<20)
		{
			System.out.println("To City match found");
		}
		else
		{
			System.out.println("To City match not found");
		}
		
		destloc.sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		
		System.out.println(d.findElement(By.xpath("//*[@class='pika-single is-bound is-hidden']/div[2]/div/div")).getText());
		/*while(!d.findElement(By.xpath("//*[@class='pika-single is-bound is-hidden']/div[2]/div/div")).getText().contains("July"))
				{
			       d.findElement(By.xpath("//*[@class='pika-single is-bound is-hidden']/div[2]/div/button")).click();
			
				}*/
		
		
	}

}
