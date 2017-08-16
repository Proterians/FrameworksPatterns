package pageobjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import businessobjects.Letter;
import pageobjects.BasePage;

public class InboxPage extends BasePage {

	private Actions builder = new Actions(driver.getInternalDriver());
	private Action pressEscKey = builder.sendKeys(Keys.ESCAPE).build();

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "to")
	private WebElement adressInput;

	@FindBy(name = "subjectbox")
	private WebElement subjectInput;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	private WebElement textBodyInput;

	@FindBy(xpath = "//span[contains(text(), 'Сохранено')]")
	private WebElement saveAlert;

	public boolean isMailSaved() {
		return getVisibleElement(saveAlert).isDisplayed();
	}

	public void clickToWriteLetter() {
		writeLetterBtn.click();
	}

	public void writeLetterAndSaveInDrafts(Letter letter) {
		clickToWriteLetter();
		adressInput.clear();
		adressInput.sendKeys(letter.getTestAdress());

		subjectInput.clear();
		subjectInput.sendKeys(letter.getTestSubject());

		textBodyInput.clear();
		textBodyInput.sendKeys(letter.getTestBody());

		if (isMailSaved()) {
			pressEscKey.perform();
		}
	}

	public DraftPage goToDrafPage() {
		getVisibleElement(draftLnk).click();
		return new DraftPage(getDriver());
	}
}
