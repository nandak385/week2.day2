package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("home")).click();
		driver.navigate().back();
        Point location = driver.findElement(By.id("position")).getLocation();
        System.out.println(" position of button (x,y) is " + location);
	    String attribute = driver.findElement(By.id("color")).getCssValue("background-color");
	    System.out.println("color is " + attribute );
	    Dimension size = driver.findElement(By.id("size")).getSize();
	    System.out.println(" height and width is " + size);
	    
	  
	}

}
