package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("yes")).click();
		
		WebElement buttonSelectName = driver.findElement(By.xpath("(//input[@name='news'])[2]/parent::label"));
		boolean buttonSelect = driver.findElement(By.xpath("(//input[@name='news'])[2]")).isSelected();
		if(buttonSelect)
		System.out.println("The default selected radio button is "+buttonSelectName.getText());
	
	 boolean selectedCheck = driver.findElement(By.xpath("//label[contains(text(),'group')]/following-sibling::input[2]")).isSelected();
		if(selectedCheck)
		{
					System.out.println("Choice is already selected");
		}else
		{	
			System.out.println("Choice wasn't selected");
		}	

	}

}
