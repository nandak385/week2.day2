package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.findElement(By.xpath("(//div[@class='x-form-item x-tab-item'])[2]//input")).sendKeys("Nanda");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ')]//a"))
			.click();
		System.out.println(driver.getTitle());
		String orgCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Edit")).click();
		WebElement cmpnyName = driver.findElement(By.id("updateLeadForm_companyName"));
		cmpnyName.clear();
		cmpnyName.sendKeys("WTS 1");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String editCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(
				"Comapny Name before update : " + orgCompanyName + "Company Name after update " + editCompanyName);
		driver.close();
	}

}
