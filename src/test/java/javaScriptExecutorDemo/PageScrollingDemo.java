package javaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScrollingDemo 
{
public static void main(String[] args) {
	
	   WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.nopcommerce.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    //scroll by using pixel
	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("window.scrollBy(0, 1000)", "");
//	    System.out.println(js.executeScript("return window.pageYOffset;"));
	    
	    //scroll till the element is visible
//	    WebElement poll =driver.findElement(By.xpath("//div[@class='title']//strong[text()='Community poll']"));
//	    js.executeScript("arguments[0].scrollIntoView()", poll);
//	    System.out.println(js.executeScript("return window.pageYOffset;"));
	    
	    //scroll till end of page
	    js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	    System.out.println(js.executeScript("return window.pageYOffset;"));
        
	    //scroll top of page
	    js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
	    System.out.println(js.executeScript("return window.pageYOffset;"));

}
}
