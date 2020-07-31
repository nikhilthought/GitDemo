import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.findElement(By.id("alertbtn")).click();
		d.switchTo().alert().accept(); // to accept/Yes/ok - use accept();
		
		
		d.findElement(By.id("confirmbtn")).click();
		d.switchTo().alert().dismiss();  // to cancel/No/Deny - use dismiss();

	}

}
