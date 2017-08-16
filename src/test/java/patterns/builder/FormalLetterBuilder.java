package patterns.builder;

import java.util.Date;

public class FormalLetterBuilder extends LetterBuilder {

	@Override
	public void buildTestAdress() {
		letter.setTestAdress("test_student2017@mail.ru");
	}

	@Override
	public void buildTestSubject() {
		letter.setTestSubject(
				String.format("%s_%d", "Formal letter", new Date().getTime()));
	}

	@Override
	public void buildTestBody() {
		letter.setTestBody("Some formal text.");
	}
}