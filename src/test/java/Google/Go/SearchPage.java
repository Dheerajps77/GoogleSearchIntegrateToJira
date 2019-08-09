package Google.Go;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchPage {

	WebDriver driver;

	@Test(priority = 0)
	public void googleSearch() throws Exception {
		try {
			String chromePath = "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			/*
			 * ChromeOptions option = new ChromeOptions(); option.setHeadless(true);
			 * option.addArguments("window-size=1200,1100");
			 * option.addArguments("--proxy-server='direct://'");
			 * option.addArguments("--proxy-bypass-list=*"); LoggingPreferences logPrefs =
			 * new LoggingPreferences(); logPrefs.enable(LogType.BROWSER, Level.ALL);
			 */
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");

			// System.out.println(driver.getPageSource());
			System.out.println("Current page title is " + driver.getTitle());
			System.out.println("Current page URL is " + driver.getCurrentUrl());
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 2)
	public void verifyGitLabURL() throws Exception {
		try {
			driver.navigate().to("https://github.com/");
			Thread.sleep(2000);
			System.out.println("Current page title is " + driver.getTitle());
			System.out.println("Current page URL is " + driver.getCurrentUrl());
			System.out.println("Hi....");
			System.out.println("Hello.. I am here...");
			boolean flag=false;
			if(driver.getCurrentUrl().equalsIgnoreCase("https://github.com/"))
			{
				flag=true;
			}
			Assert.assertTrue(flag, "Unable to open github url");
			System.out.println("verifyGitLabURL->>This test has been completed");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 1)
	public void verifyGoogleSearchTextBox() throws Exception {
		try {
			
			WebElement searchTextBoxElement=driver.findElement(By.xpath("//input[@name='q']"));
			searchTextBoxElement.sendKeys("Godzilla");
			searchTextBoxElement.submit();
			Thread.sleep(2000);
			WebElement searchResult=driver.findElement(By.xpath("//div[@class='r']//a[@href='https://en.wikipedia.org/wiki/Godzilla:_King_of_the_Monsters_(2019_film)']"));
			String urlString=searchResult.getAttribute("href");
			boolean flag=false;
			if(urlString.equalsIgnoreCase("https://en.wikipedia.org/wiki/Godzilla:_King_of_the_Monsters_(2019_film)"))
			{
				flag=true;
			}
			Assert.assertTrue(flag, "Unable to searched the results");
			System.out.println("verifyGoogleSearchTextBox->>This test has been completed");
		} catch (Exception e) {
			throw e;
		}
	}

	// @Test(priority=3)
	public void googleSearchVidoes() throws Exception {
		try {
			throw new SkipException("This test is not ready to run.So we are skipping this one");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterTest
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		driver.close();
		try {

		} catch (Exception e) {
			throw e;
		}
	}

}
