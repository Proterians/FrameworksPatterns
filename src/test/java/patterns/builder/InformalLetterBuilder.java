package patterns.builder;

import java.util.Date;
/**
 * Class with implementation pattern "Builder"
 * 
 * @author Ivan_Bulgakov
 * @CreateDate July, 24, 2017
 * @UpdateDate August, 17, 2017
 * @UpdatedBy Ivan_Bulgakov
 */
public class InformalLetterBuilder extends LetterBuilder {

	@Override
	public void buildTestAdress() {
		letter.setTestAdress("ya.testingtest@yandex.ru");
	}

	@Override
	public void buildTestSubject() {
		letter.setTestSubject(
				String.format("%s_%d", "Informal letter", new Date().getTime()));
	}

	@Override
	public void buildTestBody() {
		letter.setTestBody("Some informal text.");
	}
}