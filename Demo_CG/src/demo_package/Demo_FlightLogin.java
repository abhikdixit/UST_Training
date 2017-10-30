 package demo_package;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo_FlightLogin {
	
@Test
	public void Login() throws Exception
	{
   /*ProfilesIni prof = new ProfilesIni();				
	FirefoxProfile ffProfile= prof.getProfile("myprofile");
	ffProfile.setAcceptUntrustedCertificates(true);
	ffProfile.setAcceptUntrustedCertificates(false);*/
	
  System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Demo_CG\\chromedriver.exe");
   ChromeDriver driver = new ChromeDriver();
   		//WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.name("login")).click();
		driver.quit();
		
	}
	
	
}
