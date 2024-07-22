package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDemo
{
 public static void main(String[] args)
 {
  WebDriver driver = new ChromeDriver();  
  driver.manage().window().maximize();
  driver.get("https://testautomationpractice.blogspot.com/");
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
  WebElement countrydrp = driver.findElement(By.xpath("//select[@id='country']"));
  countrydrp.click();
  
//  Select sel = new Select(countrydrp);
//  sel.selectByVisibleText("India");
//  System.out.println("India is select");
  
  List<WebElement> options = driver.findElements(By.xpath("//select[@id='country']//option"));
  
  for(WebElement Countrylist: options)
  {
	 String values = Countrylist.getText();
	 if(values.equals("Germany"))
	 {
		 Countrylist.click();
	 }
  }
  
  
 }
}
