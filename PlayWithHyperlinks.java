package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html#");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
        String attribute = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
        System.out.println(attribute);
        WebElement error = driver.findElement(By.linkText("Verify am I broken?"));
        error.click();
        String err = driver.getTitle();
        String err1 = "HTTP Status 404 – Not Found";
        System.out.println(err);
        if (err.equals(err1)) {
        	System.out.println("The link is Broken");
			
		}else {
			System.out.println("The link is not Broken");
			
		}
		driver.navigate().back();

		String attribute2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/a")).getAttribute("href");
		
		String attribute3 = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		
		if (attribute2.equals(attribute3)) {
			System.out.println("Both the links are same");
			
		}else {
			System.out.println("both links are different");
		}

      
         List<WebElement> links = driver.findElements(By.tagName("a"));
         System.out.println("The no of link in this page are " + links.size());
	}

}
