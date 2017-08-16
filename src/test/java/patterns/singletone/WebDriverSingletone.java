package patterns.singletone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletone {

	private static WebDriver driver;

	private WebDriverSingletone() {

	}

	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}