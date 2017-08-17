package pageobjects.pages;

/** 
 * Class described a page when you must type your email as a login
 * 
 * @author Ivan_Bulgakov
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import businessobjects.User;
import pageobjects.BasePage;

public class LoginPage extends BasePage {

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "identifierId")
	private WebElement loginInput;

	@FindBy(id = "identifierNext")
	private WebElement nextBtn;

	/**
	 * This method includes method typeLogin and after the method performed
	 * clicks on next button and gets new instance of the Password page
	 * 
	 * @return new instance of Password page
	 */
	public PasswordPage goToPasswordPage(User user) {
		typeLogin(user);
		nextBtn.click();
		return new PasswordPage(getDriver());
	}

	/**
	 * This method types an email as a login in input field
	 * 
	 * @param user
	 *            - instance of User
	 */
	public void typeLogin(User user) {
		System.out.println("Typing user login: " + user.getLogin());
		loginInput.clear();
		loginInput.sendKeys(user.getLogin());
	}
}