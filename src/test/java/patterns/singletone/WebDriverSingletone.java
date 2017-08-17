package patterns.singletone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Implementation of pattern "Singleton" for Interface "WebDriver"
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public class WebDriverSingletone {

	private static WebDriver driver;

	/**
	 * Private constructor
	 */
	private WebDriverSingletone() {

	}

	/**
	 * Public constructor returns new instance if driver is null or current
	 * driver if it already exist
	 * 
	 * @return
	 */
	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}