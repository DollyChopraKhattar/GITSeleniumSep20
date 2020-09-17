package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void openApplication(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("WebDriver.Chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.monsterindia.com/");

	}

	@Test(priority = 0)
	public void verifyPageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "Job Vacancy - Latest Job Openings - Job Search Online - Monster India";
		Assert.assertEquals(actTitle, expTitle);

	}

	@Test(priority = 1)
	public void verifyText() {
		String actText = driver.findElement(By.cssSelector("#user-signup-actions > div:nth-child(1) > div > h2")).getText();
		String expText = "NEW TO MONSTER?";
		Assert.assertEquals(actText, expText);
	}

	@Test(priority = 2)
	public void loginBtnVisibility() {
		Boolean actBtnVisibility = driver.findElement(By.cssSelector("#seekerLoginBtn > a > span:nth-child(2)")).isDisplayed();
		Assert.assertTrue(actBtnVisibility);

	}

	@Test(priority = 3)
	public void searchBtnEnabled() {
		Boolean actBtnVisibility = driver.findElement(By.cssSelector("#searchForm > div > div.col-xl-2.col-lg-3.col-sm-2.col-xxs-12.fl.no-padding > input")).isEnabled();
		Assert.assertTrue(actBtnVisibility);
	}

	@AfterTest
	public void closeApplication() {
		driver.close();

	}

}
