package demo_package;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile_RobotClass {
	String URL = "https://uploadfiles.io/";
	WebDriver  driver;
	//WebDriverWait wait = new WebDriverWait(driver,10);
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testUpload() throws InterruptedException{		
		driver.get(URL);
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\Images\\Image0019.jpg";
		System.out.println(filepath);

		driver.findElement(By.id("upload-window")).click();

		uploadFile(filepath);
		Thread.sleep(10);

		Assert.assertTrue(verifySuccessMessage());
		//ScreenShot_Test ObjScreen = new ScreenShot_Test();
		//ObjScreen.tearDown();
	}

	private boolean verifySuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#edit>h3")));
		String actualText=driver.findElement(By.cssSelector("#edit>h3")).getText();
		return actualText.contains("Done! Your file is available at:");
	}

	public static void uploadFile(String fileLocation) {
		try {
			//Upload file through Robot API
			StringSelection ss = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.delay(1000);     

			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);    
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			//Press Enter
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);	

			robot.delay(1000);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
