package demo_selenium_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Gecko_Driver {
	WebDriver driver;
	@Test	
	public void bookticket() throws InterruptedException {
		
	System.setProperty("webdriver.gecko.driver","C:\\Users\\adixit\\workspace\\Selenium_3.0_Project\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
	//Thread.sleep(30);
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys("selenium");
	driver.findElement(By.name("password")).sendKeys("selenium");
	driver.findElement(By.name("login")).click();
	WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
	String strng = element.getText();
	System.out.println(strng);
	Assert.assertEquals("SIGN-OFF", strng);
	driver.findElement(By.xpath("//input[@value='oneway']")).click();
	Select oSelect = new Select(driver.findElement(By.name("fromPort")));
 	oSelect.selectByValue("London");
	driver.findElement(By.name("findFlights")).click();
	String depart = driver.findElement(By.xpath("//td[@class='title']/font/b/font[contains(text(), 'DEPART')]")).getText();
	System.out.println(depart);
	Assert.assertEquals("DEPART", depart);
	driver.findElement(By.name("reserveFlights")).click();
	driver.findElement(By.name("passFirst0")).sendKeys("Demo");
	driver.findElement(By.name("passLast0")).sendKeys("Selenium");
	driver.findElement(By.name("creditnumber")).sendKeys("1234567891234567");
	driver.findElement(By.name("buyFlights")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
	
	}
	
	@Test
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
}
