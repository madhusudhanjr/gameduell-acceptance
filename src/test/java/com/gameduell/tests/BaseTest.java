package com.gameduell.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gameduell.pageobjects.HomePage;
import com.gameduell.pageobjects.LoginPage;

/**
 * BaseTest Class holds common methods to execute before and after executing the
 * Test Cases
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class BaseTest {

	/**
	 * Class variable which holds the reference to the Logger Object
	 */
	Logger logger = Logger.getLogger(BaseTest.class);

	/**
	 * Class variable which holds the reference to the WebDriver Object
	 */
	public static WebDriver m_driver;

	enum Drivers {

		CHROME, FF;
	}

	/**
	 * Class variable reference to GameDuell Page Objects
	 */
	public LoginPage m_loginPage;
	public HomePage m_homePage;

	/**
	 * This method is used to launch the URL
	 */
	public LoginPage launchURL(String url) {

		m_driver.get(url);

		return new LoginPage(m_driver);
	}

	/**
	 * This method is used to initialize before executing any tests
	 */
	@BeforeSuite(alwaysRun = true)
	public void initialize() {

		PropertyConfigurator.configure("src/test/resources/Logger/log4j.properties");

	}

	/**
	 * Before Test executes before executing any Tests (contains one or more
	 * Test Methods)
	 * 
	 * @param browser
	 * @param url
	 */
	@Parameters({ "browser", "url" })
	@BeforeTest(alwaysRun = true)
	public void setup(String browser, String url) {

		logger.info("Enter @BeforeTest method");

		DesiredCapabilities capabilites = new DesiredCapabilities();

		switch (Drivers.valueOf(browser)) {
		case CHROME:

			System.setProperty("webdriver.chrome.driver", "/Users/mjr/Downloads/chromedriver");
			m_driver = new ChromeDriver(capabilites);
			break;

		default:
			throw new SkipException("Browser not Supported!!");
		}

		m_driver.manage().window().maximize();
		m_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Connection established successfully with the browser!!");
		
		logger.info("Exit @BeforeTest method");

	}

	/**
	 * After Test quits driver after executing all Test Methods which are part of Test
	 */
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		
		logger.info("Enter @AfterTest method");
		
		m_driver.quit();
		logger.info("Driver quit success!!");
		logger.info("Completed Test Execution successfully!!");
		
		logger.info("Exit @AfterTest method");
	}

}
