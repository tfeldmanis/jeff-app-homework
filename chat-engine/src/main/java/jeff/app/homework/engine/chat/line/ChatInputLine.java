package jeff.app.homework.engine.chat.line;

public abstract class ChatInputLine implements ChatLine {

	private String inputText;

	protected abstract String getGuide();

	protected abstract boolean isInputValid(String inputText);

	public boolean isInputValid() {
		return isInputValid(inputText);
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
}
