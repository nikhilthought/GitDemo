import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitmechanism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification-");
		
		WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        WebDriverWait w = new WebDriverWait(driver, 5); // Globally declare explicit wait
        
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        
        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
        
        System.out.println(driver.findElement(By.id("results")).getText());
        
        
	}

}
