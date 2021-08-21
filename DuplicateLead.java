package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.name("emailAddress")).sendKeys("123@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"ext-gen334\"]")).click();
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(2000);

		WebElement firstLead = driver
				.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a"));
		// Capture name of First Resulting lead
		String frstLeadTxt = firstLead.getText();
		System.out.println("First Resulting Lead Name : " + frstLeadTxt);

		firstLead.click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("submitButton")).click();
		
		String duplLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		if(duplLeadName.equals(frstLeadTxt)) {
			System.out.println(duplLeadName + " && " + frstLeadTxt + " are equals to eachother");
		}
		driver.close();

	}

}
