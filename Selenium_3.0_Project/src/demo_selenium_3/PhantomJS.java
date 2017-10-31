package demo_selenium_3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJS {
	@Test
	public void PhantomJSTest() {
        		
        System.setProperty("webdriver.phantomjs.driver","C:\\Users\\adixit\\workspace\\Selenium_3.0_Project\\phantomjs.exe");		
        WebDriver driver = new PhantomJSDriver();	
        driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.name("login")).click();
		driver.quit();			
}		
}
