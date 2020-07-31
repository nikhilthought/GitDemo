import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabledatacalculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Akash_Java\\Selenium_Softwares\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		int sum = 0;
		d.get("https://www.cricbuzz.com/live-cricket-scorecard/20193/rsaixi-vs-pak-3-day-practice-match-pakistan-tour-of-south-africa-2018-19");
		
		WebElement table = d.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
		int rowcount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		
		int rcount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		
		for(int i=0;i<rcount-2;i++)
		{
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int rcvalue = Integer.parseInt(value);
			
			
			sum=sum+rcvalue;
			
		}
		
		String extra = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extrarun =Integer.parseInt(extra);
		int total = sum+extrarun;
		
		String TotalScore = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int Totalrun =Integer.parseInt(TotalScore);
		
		if (total==Totalrun)
		{
		
			System.out.println("Total score matched");
		}
		else
		{
			System.out.println("failed to match Total score");
		}
		
	}

}
