package businessobjects;

/**
 * The class is used to create a new letter with properties <b>testAdress</b>,
 * <b>testSubject</b>, <b>testBody</b>
 * 
 * @author Ivan_Bulgakov
 */


public class Letter {

	private String testAdress;
	private String testSubject;
	private String testBody;

	public String getTestAdress() {
		return testAdress;
	}

	public void setTestAdress(String testAdress) {
		this.testAdress = testAdress;
	}

	public String getTestSubject() {
		return testSubject;
	}

	public void setTestSubject(String testSubject) {
		this.testSubject = testSubject;
	}

	public String getTestBody() {
		return testBody;
	}

	public void setTestBody(String testBody) {
		this.testBody = testBody;
	}

	@Override
	public String toString() {
		return String.format("Letter [testAdress=%s, testSubject=%s, testBody=%s]", testAdress, testSubject, testBody);
	}

}