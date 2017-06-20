package com.gameduell.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test class to test Gameduell Login functionalities
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 *
 */
public class GameduellLoginTest extends BaseTest {

	Logger logger = Logger.getLogger(GameduellLoginTest.class);

	/**
	 * This Test Method register as a new user to ww.gameduell.com and logs in
	 * with the created user details
	 * 
	 * @throws Exception
	 */
	@Parameters({ "browser", "url" })
	@Test(priority = 0)
	public void gameduellRegistrationTest(String browser, String url) throws Exception {

		logger.info("START OF TEST CASE:: gameduellRegistrationTest()\n");

		logger.info("Launching URL");
		m_loginPage = launchURL(url);

		logger.info("Click New Here Link");
		m_loginPage.handleAlertOKButton();
		m_loginPage.clickNewHereLink();

		logger.info("Register as a new user");
		String randomString = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
		
		logger.info("Registering with the username as :: " + randomString);
		m_homePage = m_loginPage.registerNewUser(randomString);

		logger.info("Click MyGameDuell Tab");
		m_homePage.handleAlertOKButton();
		m_homePage.clickMyGameDuellTab();

		logger.info("Get MyGameDuell Overview Page Account Balance");
		String overviewAccountBalance = m_homePage.getOverviewContent();

		logger.info("Get Account Box Account Balance");
		String accBoxAmount = m_homePage.getAccountBoxAmount();

		logger.info("Assert Account Balance");
		Assert.assertTrue((overviewAccountBalance.contains(accBoxAmount)), "Account Balance Mismatch!!");
		logger.info("Account Balance asserted successfully");

		logger.info("Logout");
		m_homePage.clickLogout();

		logger.info("Perform Login");
		m_loginPage.performLogin(randomString);
		String currentUrl = m_driver.getCurrentUrl();

		logger.info("Assert URL");
		Assert.assertTrue(currentUrl.contains("/gd/emailManagement/emailValidation.xhtml"), "URL mismatch!!");
		logger.info("URL asserted successfully");

		logger.info("END OF TEST CASE:: gameduellRegistrationTest()\n");
	}

}
