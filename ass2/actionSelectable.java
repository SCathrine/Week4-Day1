package week4.day2.ass2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionSelectable {

	public static void main(String[] args) {


		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);	
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//find if any iframe is there in DOM
		driver.switchTo().frame(0);
	
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		Actions act=new Actions(driver);
		//click item1----pressdown(KEYDOWN) ctrl key--click item2--click item3----release(KEYUP) ctrl key.
		
		act.click(item1).keyDown(Keys.CONTROL).click(item2).click(item3).keyUp(Keys.CONTROL).perform();
		
		
	}

}
