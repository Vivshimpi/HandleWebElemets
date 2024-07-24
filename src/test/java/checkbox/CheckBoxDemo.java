package checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo 
{
public static void main(String[] args) 
{
	 WebDriver driver = new ChromeDriver();  
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
	
	  
	  List<WebElement> d = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

      int alldays = d.size();
      System.out.println(alldays);//7
      
      //fot select one day
      d.get(5).click();
      boolean status = d.get(5).isSelected();
      System.out.println(status);
      
      //for select dynamic day
     for(int i=0; i<d.size(); i++)
     {
    	 if(i==0 || i==6)
    	 {
    		d.get(i).click(); 
    		 boolean status1 = d.get(i).isSelected();
    	      System.out.println(status1);

    	 }
     }












}
}
