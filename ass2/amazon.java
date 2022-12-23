package week4.day2.ass2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		
		driver.findElement(By.xpath("(//div[text()='oneplus 9 pro'])[1]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("(//span[@class='a-price'])[1]")).getText();
		System.out.println(text);
		String text1 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text1);
		Thread.sleep(2000);
		
		//mouse over
		Actions act=new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='a-declarative'])[7]"));
		Thread.sleep(2000);
	
		act.pause(500).moveToElement(findElement).perform();
		
		//get 5 star rating %
		
		String text2 = driver.findElement(By.xpath("//table[@id='histogramTable']/tbody/tr/td[3]/span[2]/a")).getText();
		
		System.out.println(text2);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> count=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(count);
		driver.switchTo().window(list.get(1));
		

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File des= new  File("./snaps/amazon.jpg");
		FileUtils.copyFile(screenshotAs, des);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);

	
		String text3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(text3);
		
		if(text3.contains(text)) {
			
			System.out.println("Verified");
		}
		else {
			
			System.out.println("Not Verrified");
		}
		
		driver.quit();
	}

}
