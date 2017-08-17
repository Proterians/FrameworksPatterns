package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.BasePage;

/**
 * Class described a main mail page when you login into the email box
 * 
 * @author Ivan_Bulgakov
 *
 */

public class AllMailPage extends BasePage {

	private By deleteMailAlert = By.xpath("//span[contains(text(), 'в корзину')]");

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public AllMailPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method does clean up (delete all mails) to return email box to its
	 * original state
	 */
	public void doCleanUp() throws InterruptedException {
		System.out.println("Do clean up");
		if (driver.isElementPresent(selectAllOptChk)) {
			selectAllOptChk.click();
			Thread.sleep(100);
			getVisibleElement(deleteBtn).click();
			submitBtn.click();
			if (driver.isElementPresent(deleteMailAlert)) {
				System.out.println("All mails are deleted");
			} else {
				System.out.println("Mails are not deleted");
			}

		}
	}

	/**
	 * This method does logout from email box
	 */
	public void logout() throws InterruptedException {
		System.out.println("Do logout");
		getClickableElement(accountOptionsBtn).click();
		if (driver.isElementPresent(logoutBtn)) {
			logoutBtn.click();
		}
	}
}
