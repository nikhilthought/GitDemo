import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications-");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait
		WebDriverWait w = new WebDriverWait(driver, 5); //global declaration for explicit wait 
		
		String[] itemsNeeded = {"Brocolli","Carrot","Cucumber","Brinjal"};
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		for(int p=0;p<2;p++)
        {
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[2]/a[2]")).click();
        }
		
		Thread.sleep(3000);
		itemsCart(driver, itemsNeeded);
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/button")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div/div//div/select")));
		Select s = new Select(driver.findElement(By.xpath("//*[@id='root']/div/div/div/div//div/select")));
		s.selectByValue("India");
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/button")).click();
	}
	
		public static void itemsCart(WebDriver driver, String[] itemsNeeded)
		{
			
			int j=0;
			List<WebElement> products =driver.findElements(By.cssSelector("h4.product-name"));
			
			for(int i=0;i<products.size();i++)
			{
				String[] name=products.get(i).getText().split("-");
				String formattedname = name[0].trim();
				
				List itemNeededList = Arrays.asList(itemsNeeded);
				if(itemNeededList.contains(formattedname))
				{
			        j++;
			        
					driver.findElements(By.xpath("*//div[@class='product-action']/button")).get(i).click();
					
					if(j==itemsNeeded.length)
					{
					 break;	
					} // if closure
					
				} // if closure
				
			} //for closure
			
			
			
		} //method closure
		
	}// Class closure
		

