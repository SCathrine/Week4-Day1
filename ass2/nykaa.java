package week4.day2.ass2;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Actions act=new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("//div[@class='css-1yqek2e']/ul[2]/li/a"));
		act.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("Loreal Paris");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[1]")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		act.scrollByAmount(0, 500).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
     	Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='first-filter']/div")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']/span[text()='Hair Care']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@class='control control-checkbox'])[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='css-rtde4j']/div/span[text()='Shampoo']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//div[@class='css-43m2vm']")).click();
		//switch to new window
		Set<String> count=driver.getWindowHandles();
		List<String> list=new LinkedList<String>(count);
		driver.switchTo().window(list.get(1));
		WebElement findElement2 = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		findElement2.click();
		Select s=new Select(findElement2);
		s.selectByIndex(0);
		
		String text2 = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		Thread.sleep(5000);
		//start frame with 0
		//Note: id and name locator only works for frame
		//class locator doesnt wrk in frame use index.
		driver.switchTo().frame(0);
		String text3 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println(text3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		String text4 = driver.findElement(By.xpath("//p[@class='css-cla92e eka6zu20']")).getText();
		System.out.println(text4);
		if(text4.equals(text3)) {
			
			
			System.out.println("verified");
		}
		else {
			
			System.out.println("not verified");
		}
		
	}	

}
