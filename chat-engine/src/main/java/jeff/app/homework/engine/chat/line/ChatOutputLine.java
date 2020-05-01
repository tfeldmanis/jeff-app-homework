package jeff.app.homework.engine.chat.line;

public class ChatOutputLine implements ChatLine {

	private String text;

	public ChatOutputLine(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
