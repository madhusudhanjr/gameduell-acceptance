package com.gameduell.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * A base for all the pages within the suite
 */
public abstract class BasePage {

	/**
	 * The driver
	 */
	protected final WebDriver m_driver;

	@FindBy(linkText = "OK")
	WebElement okButton;

	/**
	 * A base constructor that sets the page's driver
	 *
	 * The page structure is being used within this test in order to separate
	 * the page actions from the tests.
	 *
	 * @param driver
	 *            the driver created in the BeforeTest method.
	 */
	protected BasePage(WebDriver driver) {
		this.m_driver = driver;
		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(ajaxElementLocatorFactory, this);
	}

	/**
	 * This method clicks on OK button of the Alert
	 */
	public void handleAlertOKButton() {
		okButton.click();
	}

}
