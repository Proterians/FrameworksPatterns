package pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import businessobjects.User;
import pageobjects.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "identifierId")
	private WebElement loginInput;

	@FindBy(id = "identifierNext")
	private WebElement nextBtn;

	public PasswordPage goToPasswordPage(User user) {
		typeLogin(user);
		nextBtn.click();
		return new PasswordPage(getDriver());
	}

	public void typeLogin(User user) {
		System.out.println("Typing user login: " + user.getLogin());
		loginInput.clear();
		loginInput.sendKeys(user.getLogin());
	}
}