package demo_package;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	WebDriver driver;
	 
    @BeforeMethod
    public void LaunchApp() throws Exception {

	    driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	}

@Test(dataProvider="LoginData")
public void LoginApp(String uname,String password)throws  Exception{
	
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("login")).click();
	driver.quit();
	}

@DataProvider(name = "LoginData")
public Object[][] Authentication() throws Exception{
	ReadExcel excel = new ReadExcel();
	Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\workspace\\Demo_CG\\FlightTestData.xlsx","TestData");
	System.out.println(testObjArray);
     return testObjArray;
     
	}
 
}
