package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWithListBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		WebElement selByInd1 = driver.findElement(By.id("dropdown1"));
		Select drDown1 = new Select(selByInd1);
		drDown1.selectByIndex(1);
		
		WebElement selByInd2 = driver.findElement(By.name("dropdown2"));
		Select drDown2 = new Select(selByInd2);
		drDown2.selectByVisibleText("Appium");
		
		WebElement selByInd3 = driver.findElement(By.id("dropdown3"));
		Select drDown3 = new Select(selByInd3);
		drDown3.selectByValue("3");
		
		WebElement webDrpDwn4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select drpDwn4 = new Select(webDrpDwn4);
		int drpDwnSize = drpDwn4.getOptions().size();
		System.out.println("Size of the 4th dropdown is :"+drpDwnSize);
          
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select")).sendKeys("Loadrunner");
		
		WebElement selectLast = driver.findElement(By.xpath("//section[@class='innerblock']//div[6]//select"));
		Select drDown6 = new Select(selectLast);
		int listSize = drDown6.getOptions().size();
		drDown6.selectByIndex(listSize-2);
		
	}

}
