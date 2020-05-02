package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.line.ChatLine;

public class ChatPatternBuilder<T> {

	private final ChatPattern<T> pattern;

	public ChatPatternBuilder() {
		this.pattern = new ChatPattern<>();
	}

	public void addLine(ChatLine<T> line) {
		pattern.addLine(line);
	}

	public ChatPattern<T> build() {
		pattern.complete();
		return pattern;
	}

}
