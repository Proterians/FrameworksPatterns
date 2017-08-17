package pageobjects.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import businessobjects.Letter;
import pageobjects.BasePage;

/**
 * Class described a sent mail page when you can see sent mails
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public class SentMailPage extends BasePage {

	/**
	 * This method performs search WebElements on the page and returns list of
	 * them which matches xPath expression(in this case = particular email)
	 * 
	 * @param letter
	 *            - instance of Letter
	 * @return List of WebElements
	 */
	private List<WebElement> recieverLnks(Letter letter) {
		return getDriver().findElements(By.xpath(String.format("//span[@email='%s']", letter.getTestAdress())));
	}

	/**
	 * Constructor with lazy initialization of @see PageFactory
	 * 
	 * @param driver
	 *            - instance of WebDriver
	 */
	public SentMailPage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * 
	 * @return new instance of AllMail page
	 */
	@Override
	public AllMailPage goToAllMailPage() {
		allMailLnk.click();
		getVisibleElement(accountOptionsBtn);
		return new AllMailPage(getDriver());
	}

	/**
	 * This method finds all web elements on the page with appropriate
	 * attribute, generate List<WebElement>, compare elements with given String
	 * pattern and returns if element matches
	 * 
	 * @return matches element
	 * @param letter
	 *            - instance of class letter.java
	 * @param attribute
	 *            - name of html attribute
	 *
	 */
	public String getRecieverAdress(Letter letter, String attribute) {
		List<WebElement> list = recieverLnks(letter);
		String message = null;
		for (Iterator<WebElement> iterator = list.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			if (webElement.getAttribute(attribute).equalsIgnoreCase(letter.getTestAdress())) {
				message = webElement.getAttribute(attribute);
			}
		}
		return message;
	}
}
