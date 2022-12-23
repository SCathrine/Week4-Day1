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

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement findElement = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(findElement).perform();
		WebElement findElement2 = driver.findElement(By.xpath("//a[text()='Jackets']//parent::li[@data-reactid='40']"));
		findElement2.click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(text);
		
		WebElement findElement3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]"));
		
		String text3 = findElement3.getText();
		System.out.println(text3);
		Thread.sleep(2000);
		
		 WebElement findElement4 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
        String text4 = findElement4.getText();
        System.out.println(text4);
		Thread.sleep(2000);
		
		//PLS HELP----unable to add two string values using concat. tried parseInt
		/*int text5= Integer.parseInt(text3)+Integer.parseInt(text4);
		System.out.println(text5);
		Thread.sleep(2000);*/
		
		driver.findElement(By.xpath("(//ul[@class='categories-list']/li[1])")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(2000);
		List<WebElement> findElements = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int size = findElements.size();
		System.out.println(size);
		List<String> l=new ArrayList<String>();
		boolean flag=false;
		for(int i=0;i<size;i++) {
		
			WebElement findElement5 = driver.findElement(By.xpath("//h3[@class='product-brand']"));
			String text2 = findElement5.getText();
			//System.out.println(text2);
			l.add(text2);
			
		}	
		
		System.out.println(l);
		if(l.contains("Duke")) {
			flag=true;
			System.out.println("verified");
			
		}
		if(flag==false)
		{
			System.out.println("Not Verified");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
		Thread.sleep(5000);
		  Set<String> windowHandles = driver.getWindowHandles();
		    List<String> ll=new ArrayList<String>(windowHandles);
		    driver.switchTo().window(ll.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File des=new File("./snaps/myntra.jpg");
	    FileUtils.copyFile(screenshotAs, des);
	    Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		Thread.sleep(2000);
		
		driver.quit();
		}	
	}



