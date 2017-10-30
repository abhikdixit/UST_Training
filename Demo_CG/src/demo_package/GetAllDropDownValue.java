package demo_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GetAllDropDownValue {
  @Test
  public void AllValue() {
	WebDriver driver = new FirefoxDriver();
	String baseurl = "http://newtours.demoaut.com/mercurywelcome.php";
	driver.get(baseurl);
	driver.manage().window().maximize();
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys("testing");
	driver.findElement(By.name("password")).sendKeys("testing");
	driver.findElement(By.name("login")).click();
	  WebElement element = driver.findElement(By.name("fromPort"));
      Select s = new Select(element);
      List <WebElement> elementcount = s.getOptions();

      System.out.println(elementcount.size());
      for(int i=0 ;i<elementcount.size();i++)
      {
          String value = elementcount.get(i).getText();
          s.selectByValue(value);
          System.out.println(value);

      }
      driver.quit();
  }
}
