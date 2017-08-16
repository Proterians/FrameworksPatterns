package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.pages.AllMailPage;
import patterns.decorator.WebDriverDecorator;

public class BasePage {

	private static final String ACCOUNTS_GOOGLE_COM_SIGN_OUT_OPTIONS = ".//*[starts-with(@href,'https://accounts.google.com/SignOutOptions')]";
	protected WebDriverDecorator driver;

	public WebDriver getDriver() {
		return driver;
	}

	protected By delBtnLocator = By.xpath("//div[@aria-label='Удалить']");

	protected By accountOptionsBtnLocator = By.xpath(ACCOUNTS_GOOGLE_COM_SIGN_OUT_OPTIONS);
	protected By selectAllOptChkLocator = By
			.xpath("(//div[@data-tooltip='Выбрать' and @aria-label='Выбрать'])[last()]");

	@FindBy(xpath = ACCOUNTS_GOOGLE_COM_SIGN_OUT_OPTIONS)
	protected WebElement accountOptionsBtn;

	@FindBy(linkText = "Выйти")
	protected WebElement logoutBtn;

	@FindBy(xpath = "(//div[@data-tooltip='Выбрать' and @aria-label='Выбрать'])[last()]")
	protected WebElement selectAllOptChk;

	@FindBy(xpath = "(//div[@aria-label='Удалить']//div)[last()]")
	protected WebElement deleteBtn;

	@FindBy(name = "ok")
	protected WebElement submitBtn;

	@FindBy(xpath = "//a[contains(text(), 'Черновики')]")
	protected WebElement draftLnk;

	@FindBy(xpath = "//a[contains(text(), 'Вся почта')]")
	protected static WebElement allMailLnk;

	@FindBy(xpath = "//a[contains(text(), 'Отправленные')]")
	protected WebElement sentMailPageLnk;

	@FindBy(xpath = "//div[contains(text(), 'НАПИСАТЬ')]")
	protected WebElement writeLetterBtn;

	@FindBy(xpath = "//div[contains(text(), 'Письмо отправлено')]")
	protected WebElement mailSentAllert;

	public BasePage(WebDriver driver) {
		this.driver = (WebDriverDecorator) driver;
		PageFactory.initElements(driver, this);
	}

	public AllMailPage goToAllMailPage() {
		allMailLnk.click();
		return new AllMailPage(driver);
	}

	public WebElement getClickableElement(WebElement element) {
		return element = (new FluentWait<WebDriver>(driver).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class).withTimeout(30, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(element)));
	}

	public WebElement getVisibleElement(WebElement element) {
		return element = (new FluentWait<WebDriver>(driver).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class).withTimeout(30, TimeUnit.SECONDS)
				.until(ExpectedConditions.visibilityOf(element)));
	}

	public WebElement getVisibileOfElementLocated(By locator) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
