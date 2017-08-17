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

/**
 * KInd of PageObject class with definition a Gmail base page, in which elements
 * described with using TestNG annotation and lazy initialization of PageFactory
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
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

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public BasePage(WebDriver driver) {
		this.driver = (WebDriverDecorator) driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Allows go to All mail page on any step of tests
	 * 
	 * @return new instance of AllMail page
	 */
	public AllMailPage goToAllMailPage() {
		allMailLnk.click();
		return new AllMailPage(driver);
	}

	/**
	 * An expectation for checking an element is visible and enabled such that
	 * you can click it.
	 *
	 * @param element
	 *            the WebElement
	 * @return the (same) WebElement once it is clickable (visible and enabled)
	 */
	public WebElement getClickableElement(WebElement element) {
		return element = (new FluentWait<WebDriver>(driver).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class).withTimeout(30, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * An expectation for checking that an element, known to be present on the
	 * DOM of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 *
	 * @param element
	 *            the WebElement
	 * @return the (same) WebElement once it is visible
	 */
	public WebElement getVisibleElement(WebElement element) {
		return element = (new FluentWait<WebDriver>(driver).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(Exception.class).withTimeout(30, TimeUnit.SECONDS)
				.until(ExpectedConditions.visibilityOf(element)));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a
	 * page and visible. Visibility means that the element is not only displayed
	 * but also has a height and width that is greater than 0.
	 *
	 * @param locator
	 *            used to find the element
	 * @return the WebElement once it is located and visible
	 */
	public WebElement getVisibileOfElementLocated(By locator) {
		return (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
