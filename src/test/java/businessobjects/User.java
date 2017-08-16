package businessobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class User {

	private static final String ERROR_MSG = "Error! File with properties does not exist!";
	private static final String KEY_WORD_USER_PASSWORD = "user.password";
	private static final String KEY_WORD_USER_LOGIN = "user.login";
	private static final String ACCOUNT_PROPERTIES_PATH = "src/test/resources/account.properties";
	private String login;
	private String password;

	public User() {
		FileInputStream fis;
		Properties property = new Properties();
		try {
			fis = new FileInputStream(ACCOUNT_PROPERTIES_PATH);
			property.load(fis);

			login = property.getProperty(KEY_WORD_USER_LOGIN, "testtesterovryazan@gmail.com");
			password = property.getProperty(KEY_WORD_USER_PASSWORD, "testfortesters");
		} catch (IOException e) {
			System.err.println(ERROR_MSG);
		}
		return;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return String.format("User [login=%s, password=%s]", login, password);
	}

}
