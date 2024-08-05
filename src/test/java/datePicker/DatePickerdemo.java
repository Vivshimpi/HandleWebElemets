package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerdemo 
{
  public static void main(String[] args) {
	
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://jqueryui.com/datepicker/");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.switchTo().frame(0);
	  
	  String month = "April";
	  String year = "2025";
	  String date = "9";
	  //manually pick date
	 // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("07/08/2024");
	  
	  //by using datePicker
	  driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	  
	  //select month and year
	  while(true)
	  {
	  String currentMonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	  String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	  
	  if(currentMonth.equals(month) && currentYear.equals(year))
	  {
		 break;
	  }
	  
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	
	  }
	  
	  
	  
	  List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
	  
	  for(WebElement x: dates)
	  {
		  if(x.getText().equals(date))
		  {
			  x.click();
			  break;
		  }
	  }
}
}
