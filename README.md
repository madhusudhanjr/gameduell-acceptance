# gameduell-acceptance tests

Test Steps:
Goal
1. Open a domain of your choice from GameDuell (www.gameduell.com for example)
2. Click on "New here? Test for free!" link
3. Register a new user (you can use a provider which offers disposable mails, like trashmail.com)
4. Validate that you have the correct amount of practice money
  1. Go to My GameDuell page
  2. Validate that the account balance in "My Gameduell overview" is the same like in account box
5. Logout
6. Login
7. Validate that you are still on "/gd/emailManagement/emailValidation.xhtml"

# Project details:

1. Project Type: Maven
2. Tool: Selenium WebDriver (v 3.4)
3. Program Language: Java (v 1.8 SDK)
4. Testing Framework: TestNG
5. Test Framework Design: Page Object Model (POM) with Page Factory Pattern
6. Logging: Log4j
7. Reproting: Default TestNG Reporting
8. Browser: Tested on Chrome (v 59.0)
9. Platform: Tested on Mac OS Sierra

# Steps to run the Tetsts:

Run the the test suite xml file as TestNG tests

Test Suite File: src/test/resources/TestSuite/GameduellLoginTests.xml
