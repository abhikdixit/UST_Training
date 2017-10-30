package demo_package;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Capture_ScreenShot {
	public WebDriver driver;
	@Test
	public void Login() throws Exception
	{
		try{
		driver = new FirefoxDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		}
		catch (Exception e){
		System.out.println("Exception");
		//calls the method to take the screenshot.
		getscreenshot();
		}
		driver.quit();
	}
	
	public void getscreenshot() throws Exception
	{
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//The below method will save the screen shot in proper location with name “screenshot.png”
	FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
}
}
