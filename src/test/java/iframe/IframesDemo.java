package iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframesDemo 
{
public static void main(String[] args) throws InterruptedException {
	
	 WebDriver driver	= new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://ui.vision/demo/webtest/frames/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  //frame1
	  WebElement frm1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	  driver.switchTo().frame(frm1);
	  
	  WebElement input = driver.findElement(By.xpath("//input[@name='mytext1']"));
	  input.sendKeys("vivek");
	  
	  driver.switchTo().defaultContent();
	  
	  //frame2
	  WebElement frm2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	  driver.switchTo().frame(frm2);
	  
	  WebElement input1 = driver.findElement(By.xpath("//input[@name='mytext2']"));
	  input1.sendKeys("vivek");
	  
	  driver.switchTo().defaultContent();
	  
	  //frame3
	  WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	  driver.switchTo().frame(frm3);
	  
	  WebElement input2 = driver.findElement(By.xpath("//input[@name='mytext3']"));
	  input2.sendKeys("vivek");
	  
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[2]")).click();
	  
}
}
