package pageobjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import businessobjects.Letter;
import pageobjects.BasePage;

/**
 * Class described a page when you can see inbox emails and write new ones
 * 
 * @author Ivan_Bulgakov
 *
 */
public class InboxPage extends BasePage {

	private Actions builder = new Actions(driver.getInternalDriver());
	private Action pressEscKey = builder.sendKeys(Keys.ESCAPE).build();

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
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

	/**
	 * Is a mail saved or not? This method avoids the problem of having to parse
	 * an element's "style" attribute.
	 * 
	 * @return <b>true</b> if element saved <b>false</b> if element not saved
	 */
	public boolean isMailSaved() {
		return getVisibleElement(saveAlert).isDisplayed();
	}

	/**
	 * Click to element to write new letter
	 */
	public void clickToWriteLetter() {
		writeLetterBtn.click();
	}

	/**
	 * Method performs click on the button "Write new letter", fill in form with
	 * 3 fields and close after save
	 * 
	 * @param letter
	 *            - instance of Letter
	 */
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

	/**
	 * This method performs click on the link "Drafts" and go to the Draft page
	 * 
	 * @return new instance of Draft page
	 */
	public DraftPage goToDrafPage() {
		getVisibleElement(draftLnk).click();
		return new DraftPage(getDriver());
	}
}
