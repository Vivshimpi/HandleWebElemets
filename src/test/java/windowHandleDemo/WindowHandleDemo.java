package windowHandleDemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo 
{
  public static void main(String[] args) 
  {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
	
	Set<String> windowid =driver.getWindowHandles();
	
	System.out.println(windowid);
	
	for(String id :windowid)
	{
		String url = driver.switchTo().window(id).getCurrentUrl();
		System.out.println(url);
		if(url.equals("https://www.orangehrm.com/"))
		{
			driver.close();
		}
	}
	
}
}
