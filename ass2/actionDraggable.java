package week4.day2.ass2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionDraggable {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//find if any iframe is there in DOM
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(findElement, 50, 100).perform();
		
	}

}
