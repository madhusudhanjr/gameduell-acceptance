package com.gameduell.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomePage Page Object class contains all the WebElements present in the Home
 * Page and the necessary actions to be performed on the identified WebElements
 * 
 * @author Madhusudhan (madhusudhan.jr@gmail.com)
 */
public class HomePage extends BasePage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(linkText = "My GameDuell")
	WebElement myGameDuellTab;

	@FindBy(css = "p.firstParagraph")
	WebElement overviewContent;

	@FindBy(id = "logoutLink")
	WebElement logout;

	@FindBy(css = ".amount")
	WebElement accountBoxAmount;

	/**
	 * Constructor for HomePage
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * This method is used to click on MyGameDuellTab
	 */
	public void clickMyGameDuellTab() {

		myGameDuellTab.click();
	}

	/**
	 * This method is used to get Overview Content
	 */
	public String getOverviewContent() {

		return overviewContent.getText();
	}

	/**
	 * This method is used to get Account balance from Account Box
	 */
	public String getAccountBoxAmount() {

		return accountBoxAmount.getText();
	}

	/**
	 * This method is used to logout
	 */
	public void clickLogout() {

		logout.click();
	}

}
