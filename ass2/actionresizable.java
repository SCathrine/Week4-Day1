package week4.day2.ass2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionresizable {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//find if any iframe is there in DOM
		driver.switchTo().frame(0);
		//need to click the corner part so locate corner element.
		WebElement findElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		//click and hold the mouse---move to desire location----release hold.
		
		act.clickAndHold(findElement).moveByOffset(-100, -100).release().perform();

	}

}
