package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import businessobjects.User;
import pageobjects.BasePage;

/**
 * Class described a page when you must type password for login
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public class PasswordPage extends BasePage {

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(id = "passwordNext")
	private WebElement nextBtn;

	/**
	 * This method types password in input field
	 * 
	 * @param user
	 *            - instance of User
	 */
	public void typePassword(User user) {
		System.out.println("Typing user password: " + user.getPassword());
		getVisibleElement(passwordInput).clear();
		getVisibleElement(passwordInput).sendKeys(user.getPassword());
	}

	/**
	 * This method includes method typePassword and after the method performed
	 * clicks on next button and gets new instance of the Inbox page
	 * 
	 * @return new instance of Inbox page
	 */
	public InboxPage goToInboxPage(User user) {
		typePassword(user);
		getVisibleElement(nextBtn).click();
		getVisibleElement(accountOptionsBtn);
		return new InboxPage(driver);
	}
}
