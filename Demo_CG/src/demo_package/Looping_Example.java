package demo_package;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Looping_Example{
  @Test
	public void AllLinks() {
	  
		WebDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		for (int i = 0; i<=alllinks.size(); i=i+1)

		{
			//alllinks.get(i).click();
			System.out.println(alllinks.get(i).getText());
		}
		
	}

}
