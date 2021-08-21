package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntractWithImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
		driver.navigate().back();
		

		String srcLink = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).getAttribute("src");
		System.out.println(srcLink);
		driver.navigate().to("http://leafground.com/images/abcd.jpg");
		String srcLinkTitle = driver.getTitle();
		if (srcLinkTitle.contains("HTTP Status 404"))
			System.out.println("The image is broken");
		else
			System.out.println("The image is not broken ");
		driver.navigate().back();

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		driver.navigate().back();

	}

	

}
