package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import businessobjects.User;
import pageobjects.BasePage;

public class PasswordPage extends BasePage {

	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(id = "passwordNext")
	private WebElement nextBtn;

	public void typePassword(User user) {
		System.out.println("Typing user password: " + user.getPassword());
		getVisibleElement(passwordInput).clear();
		getVisibleElement(passwordInput).sendKeys(user.getPassword());
	}

	public InboxPage goToInboxPage(User user) {
		typePassword(user);
		getVisibleElement(nextBtn).click();
		getVisibleElement(accountOptionsBtn);
		return new InboxPage(driver);
	}
}
