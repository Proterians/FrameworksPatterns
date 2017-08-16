package patterns.builder;

import businessobjects.Letter;

public abstract class LetterBuilder {

	protected Letter letter = new Letter();

	public Letter getLetter() {
		return letter;
	}

	public abstract void buildTestAdress();

	public abstract void buildTestSubject();

	public abstract void buildTestBody();
}