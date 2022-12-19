package week4.day1.ass1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mergeContact {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a/img)[4]")).click();
		Thread.sleep(5000);
		
		Set<String> s = driver.getWindowHandles();
		 List<String> w=new ArrayList<String>(s);
		    //switch tab 1
		    driver.switchTo().window(w.get(1));
		WebElement findElement = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a[text()='14535']"));
         findElement.click();
         
        // driver.close();
         driver.switchTo().window(w.get(0));
         Thread.sleep(2000);
 	    driver.findElement(By.xpath("(//a/img)[5]")).click();
 	   Thread.sleep(5000);
 	   
 	  Set<String> s1 = driver.getWindowHandles();
		 List<String> w1=new ArrayList<String>(s1);
		    //switch tab 1
		    driver.switchTo().window(w1.get(1));
 	   
 	    driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a[text()='14594']")).click();
 	   driver.switchTo().window(w1.get(0));
 	   driver.findElement(By.xpath("//a[text()='Merge']")).click();
 	   
 	    Alert a=driver.switchTo().alert();
 	    a.accept();
 	    String title = driver.getTitle();
 	    if(title.equals("View Contact | opentaps CRM")) {
 	    	System.out.println("Verified");
 	    }
 	    else {
 	    	System.out.println("Not Verified");
 	    }
	}

}
