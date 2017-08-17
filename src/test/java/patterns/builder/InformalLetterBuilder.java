package patterns.builder;

import java.util.Date;
/**
 * @author Ivan_Bulgakov
 *
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