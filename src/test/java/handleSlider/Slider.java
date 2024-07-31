package handleSlider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider
{
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebElement min_slider = driver.findElement(By.xpath("//span[@style='left: 0%;']"));
	System.out.println(min_slider.getLocation());
	Actions act = new Actions(driver);
	act.dragAndDropBy(min_slider, 100, 250).perform();
	
}
}
