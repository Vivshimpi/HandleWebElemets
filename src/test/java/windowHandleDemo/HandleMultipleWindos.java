package windowHandleDemo;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindos
{
public static void main(String[] args) throws InterruptedException
{
  WebDriver driver	= new ChromeDriver();
  
  driver.manage().window().maximize();
  driver.get("https://testautomationpractice.blogspot.com/");
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  Thread.sleep(2000);

  driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("java");
  Thread.sleep(2000);

  driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
  Thread.sleep(3000);
  
 List<WebElement> results =  driver.findElements(By.xpath("//a[contains(text(),'Java')]"));
             System.out.println(results.size());
             
   for(WebElement x:results)
   {
	   x.click();
   }
   
   Set<String> id = driver.getWindowHandles();
   
   for(String x: id)
   {
	  String url =  driver.switchTo().window(x).getCurrentUrl();
	  System.out.println(url);
	  
	  String title = driver.switchTo().window(x).getTitle();
	  System.out.println(title);
	  
	  if(title.equals("Java (programming language) - Wikipedia") || title.equals("Java version history - Wikipedia"))
	  {
		  driver.close();
	  }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
}
