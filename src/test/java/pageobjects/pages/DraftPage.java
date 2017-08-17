package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import businessobjects.Letter;
import pageobjects.BasePage;

/**
 * Class described a draft mail page when you can see drafts
 * 
 * @author Ivan_Bulgakov
 *
 */
public class DraftPage extends BasePage {

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public DraftPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(xpath = "//div[@role='button' and contains(text(), 'Отправить')]")
	private WebElement sendBtn;

	public WebElement someTestMail(Letter letter) {
		return driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", letter.getTestSubject())));
	}

	public WebElement testAdressInput(Letter letter) {
		return driver.findElement(By.xpath(String.format("//span[contains(@email, '%s']", letter.getTestAdress())));
	}

	public WebElement testSubjInput(Letter letter) {
		return driver.findElement(By.xpath(String.format("//input[contains(@value, '%s']", letter.getTestSubject())));
	}

	public WebElement testTextBoxInput(Letter letter) {
		return driver.findElement(By.xpath(String.format("//div[text() = '%s']", letter.getTestBody())));
	}

	public void clickOnTestMail(Letter letter) {
		someTestMail(letter).click();
	}

	public boolean isTestMailAdressEmpty(String adress) {
		return driver.findElements(By.xpath(String.format("//span[contains(@email, '%s')]", adress))).isEmpty();
	}

	public boolean isTestMailSubjectEmpty(String subject) {
		return driver.findElements(By.xpath(String.format("//input[contains(@value, '%s')]", subject))).isEmpty();
	}

	public boolean isTestMailTextboxEmpty(String textBox) {
		return driver.findElements(By.xpath(String.format("//div[text() = '%s']", textBox))).isEmpty();
	}

	/**
	 * This method checks that draft mail is saved and clicks to button "Send
	 * mail"
	 * 
	 */
	public void sendMail() {
		sendBtn.click();
		if (mailSentAllert.isDisplayed()) {
			return;
		}
	}

	/**
	 * 
	 * @return new instance of SentMail page
	 */
	public SentMailPage goToSentPage() {
		sentMailPageLnk.click();
		return new SentMailPage(getDriver());
	}
}
