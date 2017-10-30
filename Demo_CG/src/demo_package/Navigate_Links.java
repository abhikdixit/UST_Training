package demo_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Navigate_Links {
	public WebDriver driver;
  @Test
  public void navigateToAllLinks() throws InterruptedException {
	  
	    driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		
	  List<WebElement> linksize = driver.findElements(By.tagName("a"));
	  int linksCount = linksize.size();
	  System.out.println("Total no of links Available:" + linksCount);
	  String[] links = new String[linksCount];
	  System.out.println("List of links Available:");
	  // print all the links from webpage
	  for (int i = 0; i < linksCount; i++) {
	  links[i] = linksize.get(i).getAttribute("href");
	  System.out.println(linksize.get(i).getAttribute("href"));
	  }
	  // navigate to each Link on the webpage
	  for (int i = 0; i < linksCount; i++) {
	  driver.navigate().to(links[i]);
	  System.out.println(driver.getTitle());
	  driver.navigate().back();

	  }
	  driver.close();
	  }
}
