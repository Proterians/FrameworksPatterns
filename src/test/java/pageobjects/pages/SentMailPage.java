package pageobjects.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import businessobjects.Letter;
import pageobjects.BasePage;

public class SentMailPage extends BasePage {

	private List<WebElement> recieverLnks(Letter letter) {
		return getDriver().findElements(By.xpath(String.format("//span[@email='%s']", letter.getTestAdress())));
	}

	public SentMailPage(WebDriver webDriver) {
		super(webDriver);
	}

	public AllMailPage goToAllMailPage() {
		allMailLnk.click();
		getVisibleElement(accountOptionsBtn);
		return new AllMailPage(getDriver());
	}

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
