package patterns.builder;

import businessobjects.Letter;

/**
 * Class with implementation pattern "Builder"
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public abstract class LetterBuilder {

	protected Letter letter = new Letter();

	public Letter getLetter() {
		return letter;
	}

	public abstract void buildTestAdress();

	public abstract void buildTestSubject();

	public abstract void buildTestBody();
}