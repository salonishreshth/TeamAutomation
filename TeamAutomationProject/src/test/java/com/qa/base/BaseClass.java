package com.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	 @Parameters("browser")
		@BeforeClass
		public void setup(String browser) {
			if (browser.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				// options.addArguments("--headless");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				System.out.println("open browser");
			}
			else if (browser.equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				// options.addArguments("--headless");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options);
			}
		//	driver.get("https://www.airtel.in/");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(6));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    }
	 
	 	public void closeDriver() {
			driver.close();

		}

		public void closeAllDriver() {
			driver.quit();

		}

}
