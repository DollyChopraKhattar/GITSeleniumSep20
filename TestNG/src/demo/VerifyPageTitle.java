package demo;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyPageTitle {
	WebDriver driver;
	//adding a test comment
	@BeforeTest
	public void openApplication() {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void verifyPageTitle() throws IOException {
		try {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - Log In or Sign Up Test";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
		catch(Exception ex) {
			takeScreenshot();
			Assert.fail("Script failed due to exception "+ex);
		}
		
	}
	
	private void takeScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\Users\\Ankit Khattar\\Desktop\\Dolly\\SELENIUM\\Screenshots"+(new Random().nextInt())+".jpg"));
	}
	
	@AfterTest
	public void closeApplication() {
		driver.close();
	}

}
