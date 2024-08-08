package datePicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerdemo2
{


	static Month convertMonth(String month)
	{
		HashMap<String, Month> monthMap = new HashMap<>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);
		if(vmonth == null)
		{
			System.out.println("Invalid month");
		}

		return vmonth;
	}

	static void selectDate(WebDriver driver, String ryear, String rmonth, String rdate)
	{

		//select year
		WebElement yeardropd = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		yeardropd.click();
		Select sel = new Select(yeardropd);
		sel.selectByVisibleText(ryear);

		//select month
		while(true)
		{
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			//convert reqmonth  nd displaymonth in month object

			Month expectedMonth = convertMonth(rmonth);
			Month currentMonth = convertMonth(displayMonth);

			//compare
			int result = expectedMonth.compareTo(currentMonth);
			System.out.println(result);
			//this will return 3 values <0 / 0 / >0
			//if 0 then months are equal
			// if <0 then its past month 
			//if >0 then its future month

			if(result<0)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
			else if(result>0)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				break;
			}

		}

		//select date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for(WebElement dates: alldates)
		{
			if(dates.getText().equals(rdate))
			{
				dates.click();
				break;
			}
		}
	}

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String ryear = "1995";
		String rmonth = "January";
		String rdate = "9";

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		selectDate(driver, ryear, rmonth, rdate);


	}





}
