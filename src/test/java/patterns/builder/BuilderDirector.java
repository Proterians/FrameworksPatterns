package patterns.builder;

import businessobjects.Letter;
/**
 * @author Ivan_Bulgakov
 *
 */
public class BuilderDirector {

	public static Letter buildLetter(LetterBuilder builder) {
		builder.buildTestAdress();
		builder.buildTestSubject();
		builder.buildTestBody();
		return builder.getLetter();
	}
}
