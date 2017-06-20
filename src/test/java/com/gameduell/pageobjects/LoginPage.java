package com.gameduell.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage Page Object class contains all the WebElements present in the Login
 * Page and the necessary actions to be performed on the identified WebElements
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class LoginPage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(css = "#newHereLink")
	WebElement newHereLink;

	@FindBy(name = "j_username")
	WebElement username;

	@FindBy(name = "j_password")
	WebElement password;

	@FindBy(id = "loginLink")
	WebElement loginButton;

	@FindBy(name = "commonName")
	WebElement reg_username;

	@FindBy(name = "password")
	WebElement reg_password;

	@FindBy(name = "email")
	WebElement reg_email;

	@FindBy(id = "registrationButton")
	WebElement reg_button;

	@FindBy(css = ".icon.valid")
	WebElement validIcon;

	/**
	 * Constructor for LoginPage
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to enter the userName
	 * 
	 * @param userName
	 */
	public void enterUserName(String userName) {

		username.sendKeys(userName);

	}

	/**
	 * This method is used to enter the password
	 * 
	 * @param pwd
	 */
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);

	}

	/**
	 * This method is used to click Login Button
	 */
	public void clickLoginButton() {
		loginButton.click();

	}

	/**
	 * This method clicks on NewHere Link
	 */
	public void clickNewHereLink() {
		newHereLink.click();

	}
	
	/**
	 * This method is used to enter the userName while registering
	 * 
	 * @param regName
	 */
	public void enterRegUsername(String regName) {
		reg_username.sendKeys(regName);
		reg_username.sendKeys(Keys.TAB);
		validIcon.isDisplayed();

	}

	/**
	 * This method is used to enter the regPwd while registering
	 * 
	 * @param regPwd
	 */
	public void enterRegPassword(String regPwd) {
		reg_password.sendKeys(regPwd);
		reg_password.sendKeys(Keys.TAB);
		validIcon.isDisplayed();
	}

	/**
	 * This method is used to enter the email while registering
	 * 
	 * @param mail
	 */
	public void enterRegEmail(String mail) {
		reg_email.sendKeys(mail);
		reg_email.sendKeys(Keys.TAB);
		validIcon.isDisplayed();
	}

	/**
	 * This method is used to click on PlayNow Button
	 */
	public void clickPlayNowButton() {
		reg_button.click();

	}

	/**
	 * This method is used to register as a new user
	 * 
	 * @param randomString
	 */
	public HomePage registerNewUser(String randomString) {

		enterRegUsername(randomString);

		enterRegPassword("Password");

		enterRegEmail(randomString + "@gmail.com");

		clickPlayNowButton();

		return new HomePage(m_driver);

	}

	/**
	 * This method is used to perform login
	 * 
	 * @param randomString
	 */
	public HomePage performLogin(String randomString) {

		enterUserName(randomString);

		enterPassword("Password");

		clickLoginButton();

		return new HomePage(m_driver);

	}

}
