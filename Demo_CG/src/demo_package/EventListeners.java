package demo_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventListeners {
	
	private WebDriver driver;
	private EventFiringWebDriver e_driver;
	private WebEventListener eventListener;
	private String appURL = "http://newtours.demoaut.com/mercurywelcome.php";

	@BeforeClass()
	public void setUp() {

        driver = new FirefoxDriver();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			e_driver.manage().window().maximize();
			e_driver.get(appURL);
	}

	@Test
	public void testEventsONE() {
		System.out.println("***** Executing Test ONE ***** ");
		e_driver.findElement(By.linkText("SIGN-ON")).click();
		
	}

	@Test
	public void testEventsTWO()  {
		System.out.println("***** Executing Test Two ***** ");
		//Entering user name and clicking on next
		e_driver.findElement(By.linkText("SIGN-ON")).click();
		e_driver.findElement(By.name("userName")).sendKeys("selenium");
		e_driver.findElement(By.name("password")).sendKeys("selenium");
		e_driver.findElement(By.name("login")).click();
		e_driver.findElement(By.name("findFlights")).click();
		//driver.navigate().back();
		//driver.navigate().forward();
		e_driver.findElement(By.name("reserveFlights")).click();
	}

	@AfterClass()
	public void tearDown() {
		if (e_driver != null) {
			e_driver.quit();
		}
	}


}
