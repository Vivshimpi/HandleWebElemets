package alertsHandling;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupsHandling
{
public static void main(String[] args) throws InterruptedException {
	
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	 
	  Alert alt =  driver.switchTo().alert();
	  Thread.sleep(2000);
      System.out.println(alt.getText());
	  alt.accept();
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		 
	  Alert alt1 =  driver.switchTo().alert();
	  Thread.sleep(2000);
      System.out.println(alt1.getText());

	  alt1.dismiss();
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		 
	  Alert alt2 =  driver.switchTo().alert();
	  Thread.sleep(2000);
      System.out.println(alt2.getText());
      alt2.sendKeys("Vivek");
      Thread.sleep(2000);
      alt2.accept();
	  
}
}
