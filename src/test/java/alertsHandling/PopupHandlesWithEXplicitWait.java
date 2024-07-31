package alertsHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandlesWithEXplicitWait
{
public static void main(String[] args) throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	  WebElement button = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
	  wait.until(ExpectedConditions.visibilityOf(button));
	  wait.until(ExpectedConditions.alertIsPresent()).accept();
	  
}
}
