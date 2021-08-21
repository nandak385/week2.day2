package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntractWithCheckBoxs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[1]")).click();
		
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[6]")).isSelected();
        System.out.println("The checkbox is select "+ selected);
        
        
        boolean findElement1 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[1]")).isSelected();
        if(!findElement1)
    		driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
        
     
        
        driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[3]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[4]")).click();	
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[5]")).click();
      
        
}
}