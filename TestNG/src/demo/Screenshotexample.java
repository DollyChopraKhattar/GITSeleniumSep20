package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshotexample {

	WebDriver driver;

	@BeforeTest
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://phptravels.com/demo/");
	}

	@Test
	public void screenshotExp() {
	driver.findElement(By.linkText("LOG IN")).click();
	driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
	driver.findElement(By.name("password")).sendKeys("demouser");
	driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border")).click();
	}
}
