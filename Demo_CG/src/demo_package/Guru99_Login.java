package demo_package;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99_Login {
private	WebDriver driver;
  @Test
  @Parameters({"uname","password"})
  public void Guru_Login(String uname,String password) {

			driver.navigate().to("http://demo.guru99.com/v4/");
			driver.manage().window().maximize();
			driver.findElement(By.name("uid")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("btnLogin")).click();
			WebElement element = driver.findElement(By.linkText("Manager"));
			String strng = element.getText();
			System.out.println(strng);
			Assert.assertEquals("Manager", strng);

  }
  @BeforeTest
  public void LaunchBrowser() {
	  driver = new FirefoxDriver();
 }
  
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }
}
