import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Section12Assigment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("http://qaclickacademy.com/practice.php");
		d.findElement(By.id("checkBoxOption2")).click();
		String checkbox = d.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		WebElement dp = d.findElement(By.id("dropdown-class-example"));
		Select opt = new Select(dp);
		opt.selectByVisibleText(checkbox);
		
		d.findElement(By.id("name")).sendKeys(checkbox);
		d.findElement(By.id("alertbtn")).click();
		String a = d.switchTo().alert().getText();
		           d.switchTo().alert().accept();
		
		
		if(a.contains(checkbox))
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		
		
		
	}

}
