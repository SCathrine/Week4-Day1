package week4.day2.ass2;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class countRowAndCol {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//table 1
		//calculate no of columns
    	List<WebElement> findElements = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		System.out.println("Table 1: Col = " +findElements.size());
		//total no of rows
		 List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		 int size = findElements2.size();
		System.out.println("Table 1: Rows = "  +size);
		
		//table 2
		//no of rows
	List<WebElement> findElements3 = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr"));
	int size2 = findElements3.size();
	System.out.println("Table 2: Rows = " +size2);
	//no of col
List<WebElement> findElements4 = driver.findElements(By.xpath("//div[@class='related-pages']/table/tbody/tr[2]/td"));
int size3 = findElements4.size();
System.out.println("Table 2: Col = " +size3);
		
		
		
		
		
		
		
		
	}

}
