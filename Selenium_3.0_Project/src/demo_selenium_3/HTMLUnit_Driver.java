package demo_selenium_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;


public class HTMLUnit_Driver {
	@Test
	public void HTMLUnit() {
		
	WebDriver driver = new HtmlUnitDriver();
    
	driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
	//driver.manage().window().maximize();
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys("selenium");
	driver.findElement(By.name("password")).sendKeys("selenium");
	driver.findElement(By.name("login")).click();
	driver.quit();		
	}
}
