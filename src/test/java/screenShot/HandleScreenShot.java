package screenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class HandleScreenShot 
{
  public static void main(String[] args) throws IOException, InterruptedException {
	
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(3000);
	  
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File des = new File(System.getProperty("user.dir")+"\\snap\\fullpage.png");
	  FileHandler.copy(src, des);
	  
	  WebElement form = driver.findElement(By.xpath("//div[@class='orangehrm-login-form']"));
	  File src1 = form.getScreenshotAs(OutputType.FILE);
	  File des1 = new File(System.getProperty("user.dir")+"\\snap\\form.png");
	  FileHandler.copy(src1, des1);
	  
	  WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
	  File src2 = logo.getScreenshotAs(OutputType.FILE);
	  File des2 = new File(System.getProperty("user.dir")+"\\snap\\logo.png");
	  FileHandler.copy(src2, des2);
	  
	  
	  
}
}
