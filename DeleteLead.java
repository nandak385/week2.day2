package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//*[@id=\"ext-gen240__ext-gen254\"]")).click();
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneNumber")).sendKeys("9566");
		driver.findElement(By.xpath("//*[@id=\"ext-gen334\"]")).click();
	
		WebElement firstResultingLead = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));

		String frstRsltLeadText = firstResultingLead.getText();
		System.out.println(" First Resulting Lead Text :" + frstRsltLeadText);

		// Click First Resulting lead
		Thread.sleep(1000);
		firstResultingLead.click();

		// Click Delete
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(frstRsltLeadText);

		// Click Find Lead
		driver.findElement(By.xpath("//button[text()='Find Leads']"));

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		String finalResult = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("Final Message is : " + finalResult);

		if (finalResult.contains(finalResult))
			System.out.println("No records are there to display for the Lead id");
		else
			System.out.println("Still records are there to display for the Lead id");
		Thread.sleep(5000);
		driver.close();
	}
		
		
		
	

}
