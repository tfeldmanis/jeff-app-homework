package jeff.app.homework.engine.chat.line;

public class DateInputLine extends ChatInputLine {

	@Override
	protected String getGuide() {
		return null;
	}

	@Override
	protected boolean isInputValid(String inputText) {
		return false;
	}
	
}
