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