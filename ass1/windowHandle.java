package week4.day1.ass1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		//print session id of driver window
		System.out.println(driver);
		driver.findElement(By.xpath("//button[@id='j_idt88:new']/span")).click();
		//get windows opened
		Set<String> windowHandles = driver.getWindowHandles();
		//print the session id's of opened windows
		//tab 1 and tab2
		System.out.println();
		System.out.println("**Button 1**");
		System.out.println(windowHandles);
		//find size of opened windows
		System.out.println("Windows Opened:" +windowHandles.size());
		//convert to List to switch control to different tabs. 
		List<String> window=new ArrayList<String>(windowHandles);
		//focus on tab1
		driver.switchTo().window(window.get(1));
		System.out.println("Title of New Window:" +driver.getTitle());
		//remove focus from tab1
		driver.close();
		Thread.sleep(5000);
		//focus on parent tab 0
		driver.switchTo().window(window.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> window1=new ArrayList<String>(windowHandles1);
		System.out.println();
		System.out.println("**Button 2**");
		System.out.println("number of openend tabs: " +windowHandles1.size());
		driver.switchTo().window(window1.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(window1.get(2));
		Thread.sleep(2000);
         driver.close();
        driver.switchTo().window(window1.get(0));
		System.out.println();
		System.out.println("**Button 3**");
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHand1 = driver.getWindowHandles();
		Thread.sleep(2000);
		List<String> window2=new ArrayList<String>(windowHand1);
		//change focus to tab3
		//close tab3
		System.out.println("number of openend tabs: " +windowHand1.size());
		driver.switchTo().window(window2.get(3));
		driver.close();
		//change focus to tab2
		//close tab2
		driver.switchTo().window(window2.get(2));
		driver.close();
		//change focus to tab1
	    //close tab1
		driver.switchTo().window(window2.get(1));
		driver.close();
		driver.switchTo().window(window2.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(10000);
		Set<String> windowHand2 = driver.getWindowHandles();
		List<String> window3=new ArrayList<String>(windowHand2);
		driver.switchTo().window(window3.get(2));
		driver.quit();
		
	}

}
