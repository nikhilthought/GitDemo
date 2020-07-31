import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkswindowsActions 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		
		d.get("http://qaclickacademy.com/practice.php");
		
		
		//1.get the count of all the links present on page
		System.out.println(d.findElements(By.tagName("a")).size());
		
		//2.get the count of all the links present on footer of this page
		WebElement fd = d.findElement(By.id("gf-BIG"));
		System.out.println(fd.findElements(By.tagName("a")).size());
		
		//3.get the count of all the links present in first coulmn of the footer
		WebElement fcl = fd.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(fcl.findElements(By.tagName("a")).size());
		
		//4.Open all the links present in first coulmn of the footer in seperate window/tab
		for(int i=1;i<fcl.findElements(By.tagName("a")).size();i++)
		{
			String rightclickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			fcl.findElements(By.tagName("a")).get(i).sendKeys(rightclickonlink);
			Thread.sleep(4000);
			
		}
		
		//5.Get the title of all the open tabs/windows
		Set<String> w =d.getWindowHandles();
		Iterator<String> it =  w.iterator();
		
		while(it.hasNext())
		{
			String cwindows = it.next();
			d.switchTo().window(cwindows);
			System.out.println(d.getTitle());
				
		}
	}

}
