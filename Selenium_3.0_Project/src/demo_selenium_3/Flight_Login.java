package demo_selenium_3;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Flight_Login {
	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\CGI_Training\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.name("login")).click();
		driver.getTitle();
		WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
		//Thread.sleep(60);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String strng = element.getText();
		System.out.println(strng);
		Assert.assertEquals("SIGN-OFF",strng);
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Select oPassenger = new Select(driver.findElement(By.name("passCount")));
		oPassenger.selectByValue("2");
		Select oFlyFrom = new Select(driver.findElement(By.name("fromPort")));
		//oFlyFrom.selectByValue("London");
		oFlyFrom.selectByVisibleText("London");
		driver.findElement(By.name("findFlights")).click();
		
		List<WebElement> CheckBoxList = driver.findElements(By.name("outFlight"));
		CheckBoxList.get(2).click();
		/*String depart = driver.findElement(By.xpath("//td[@class='title']/font/b/font[contains(text(), 'DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART", depart);*/
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).sendKeys("Demo");
		driver.findElement(By.name("passLast0")).sendKeys("Selenium");
		driver.findElement(By.name("creditnumber")).sendKeys("1234567891234567");
		driver.findElement(By.name("buyFlights")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
		//driver.navigate().back();
		driver.quit();
		//driver.close();

	}

}
