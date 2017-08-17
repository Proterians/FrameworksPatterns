package patterns.decorator;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * Implementation of pattern "Decorator" for Interface "WebDriver"
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public class WebDriverDecorator implements WebDriver {

	private WebDriver driver;

	public WebDriverDecorator(WebDriver driver) {
		this.driver = driver;
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		Reporter.log(
				String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl(), true));
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}

	public WebDriver getInternalDriver() {
		return driver;
	}

	/**
	 * 
	 * Is this element displayed or not? This method avoids the problem of
	 * having to parse an element's "style" attribute. Returns:Whether or not
	 * the element is displayed
	 * 
	 * @param locator
	 *            - By expression
	 * @return true if element presented or false if not
	 * @throws InterruptedException
	 */
	public boolean isElementPresent(By locator) throws InterruptedException {

		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Is this element displayed or not? This method avoids the problem of
	 * having to parse an element's "style" attribute. Returns:Whether or not
	 * the element is displayed
	 * 
	 * @param element
	 *            - WebElement
	 * @return <b>true</b> if element presented or <b>false</b> if not
	 * @throws InterruptedException
	 */
	public boolean isElementPresent(WebElement element) throws InterruptedException {

		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
