package demo_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//This Scripts to Handle Alert message
public class Alert_Test {
	@Test
	public void checktitle() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		String baseurl = "http://demo.guru99.com/v4/";
		driver.get(baseurl);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.name("uid")).sendKeys("mngr88200");
		driver.findElement(By.name("password")).sendKeys("UhymAsY");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.linkText("Delete Customer")).click();
		driver.findElement(By.name("cusid")).sendKeys("91761");
		driver.findElement(By.name("AccSubmit")).click();
		String errmsg = driver.switchTo().alert().getText();
		System.out.println(errmsg);
		driver.switchTo().alert().dismiss();
		driver.quit();
	}
}
