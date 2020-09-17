package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MonsterValidation {
	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.monsterindia.com/");
				
	}
	
	@Test(priority = 0)
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Vacancy - Latest Job Openings - Job Search Online - Monster India";
		Assert.assertEquals(actualTitle, expectedTitle);		
				
	}
	@Test(priority = 1)
	public void verifyTitle() {
		String expectedText = driver.findElement(By.cssSelector("#user-signup-actions > div:nth-child(1) > div > h2")).getText();
		String acctualText = "NEW TO MONSTER?";
		Assert.assertEquals(expectedText, acctualText);
	}
	@Test(priority = 2)
	public void verifyLoginButtonVisibility() {
		boolean loginBtnVisibility =  driver.findElement(By.cssSelector("#seekerLoginBtn > a > span:nth-child(2)")).isDisplayed();
		Assert.assertTrue(loginBtnVisibility);
	}
	@Test(priority = 3)
	public void searchButtonEnability() {
		Boolean Status = driver.findElement(By.cssSelector("#searchForm > div > div.col-xl-2.col-lg-3.col-sm-2.col-xxs-12.fl.no-padding > input")).isEnabled();
		Assert.assertTrue(Status);

	}
	
	
	@AfterTest
	
	public void closeApplication() {
		driver.close();
	}

}
