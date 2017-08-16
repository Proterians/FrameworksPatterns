package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.BasePage;

public class AllMailPage extends BasePage {

	private By deleteMailAlert = By.xpath("//span[contains(text(), 'в корзину')]");

	public AllMailPage(WebDriver driver) {
		super(driver);
	}

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

	public void logout() throws InterruptedException {
		System.out.println("Do logout");
		getClickableElement(accountOptionsBtn).click();
		if (driver.isElementPresent(logoutBtn)) {
			logoutBtn.click();
		}
	}
}
