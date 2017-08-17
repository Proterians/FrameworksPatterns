package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import businessobjects.Letter;
import businessobjects.User;
import pageobjects.BasePage;
import pageobjects.pages.AllMailPage;
import pageobjects.pages.DraftPage;
import pageobjects.pages.InboxPage;
import pageobjects.pages.LoginPage;
import pageobjects.pages.PasswordPage;
import pageobjects.pages.SentMailPage;
import patterns.builder.BuilderDirector;
import patterns.builder.FormalLetterBuilder;
import patterns.builder.InformalLetterBuilder;
import patterns.decorator.WebDriverDecorator;
import patterns.singletone.WebDriverSingletone;

/**
 * Class with tests
 * 
 * @author Ivan_Bulgakov
 *
 */
public class GmailTest {

	private static final String START_URL = "https://mail.google.com/";
	private static final int TIME = 30;
	private static final String EXPECTED_TITLE = String.format("Входящие - %s - Gmail", new User().getLogin());

	private static WebDriver driver;

	private BasePage basePage;
	private LoginPage loginPage;
	private PasswordPage passwordPage;
	private InboxPage inboxPage;
	private AllMailPage allMailPage;
	private DraftPage draftPage;
	private SentMailPage sentPage;
	private String attribute = "email";
	Letter letter;
	BuilderDirector bd;

	User user = new User();

	public static WebDriver setDriver() {
		driver = new WebDriverDecorator(WebDriverSingletone.getWebDriverInstance());
		return driver;
	}

	@BeforeTest(description = "Start browser")
	public void startBrowser() {
		System.out.println("Run test");
		driver = setDriver();
		driver.get(START_URL);
	}

	@BeforeTest(description = "Set up waiters and maximize window", dependsOnMethods = "startBrowser")
	public void setWaiters() {
		driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * 
	 */
	@Parameters({ "letterParam" })
	@BeforeTest(description = "Set a letter", dependsOnMethods = "setWaiters")
	public void setLetter(String letterParam) {
		if (letterParam.equals("formal")) {
			System.out.println("Run test with 'formal' test letter");
			letter = BuilderDirector.buildLetter(new FormalLetterBuilder());
		} else if (letterParam.equalsIgnoreCase("informal")) {
			System.out.println("Run test with 'informal' test letter");
			letter = BuilderDirector.buildLetter(new InformalLetterBuilder());
		}

	}

	@Test(description = "Go to login page, typing the login and password, verify the right mail page")
	public void loginValidUser() {
		basePage = new BasePage(driver);
		loginPage = new LoginPage(driver);
		passwordPage = loginPage.goToPasswordPage(user);
		inboxPage = passwordPage.goToInboxPage(user);
		Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE, "It's wrong mailbox");
	}

	@Test(description = "Write new email and save in draft page", dependsOnMethods = "loginValidUser")
	private void writeLetterAndSave() {
		inboxPage.writeLetterAndSaveInDrafts(letter);
	}

	@Test(description = "Open draft page and verify input fields and than send emails", dependsOnMethods = "writeLetterAndSave")
	public void verifyInputFields() {
		draftPage = inboxPage.goToDrafPage();
		draftPage.clickOnTestMail(letter);
		Assert.assertTrue(!draftPage.isTestMailAdressEmpty(letter.getTestAdress()), "Incorrect adress");
		Assert.assertTrue(!draftPage.isTestMailSubjectEmpty(letter.getTestSubject()), "Incorrect subj");
		Assert.assertTrue(!draftPage.isTestMailTextboxEmpty(letter.getTestBody()), "Incorrect text");
		draftPage.sendMail();
	}

	@Test(description = "Open sent page and verify the letter's fields", dependsOnMethods = "verifyInputFields")
	public void verifySentMails() {
		sentPage = draftPage.goToSentPage();
		Assert.assertEquals(sentPage.getRecieverAdress(letter, attribute), letter.getTestAdress(),
				"Error! The email doesn't exist");
	}

	@Test(description = "Clean and logout", dependsOnMethods = "verifySentMails", alwaysRun = true)
	public void cleanUp() throws InterruptedException {
		System.out.println("Clean");
		allMailPage = basePage.goToAllMailPage();
		allMailPage.doCleanUp();
		allMailPage.logout();
	}

	@AfterSuite(description = "Close browser", alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
