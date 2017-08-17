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
public class BuilderDirector {

	public static Letter buildLetter(LetterBuilder builder) {
		builder.buildTestAdress();
		builder.buildTestSubject();
		builder.buildTestBody();
		return builder.getLetter();
	}
}
