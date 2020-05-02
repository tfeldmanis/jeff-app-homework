package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.line.ChatInputLine;
import jeff.app.homework.engine.chat.line.ChatLine;
import jeff.app.homework.engine.chat.line.ChatOutputLine;

import java.util.function.Function;

public class ChatPatternBuilder<T> {

	private final ChatPattern<T> pattern;

	public ChatPatternBuilder() {
		this.pattern = new ChatPattern<>();
	}

	@SafeVarargs
	public final ChatPatternBuilder<T> addOutputLine(String textPattern, Function<T, String>... placeholderProviders) {
		pattern.addLine(new ChatOutputLine<>(textPattern, placeholderProviders));
		return this;
	}

	public ChatPatternBuilder<T> addInputLine(ChatInputLine<T> line) {
		pattern.addLine(line);
		return this;
	}

	public ChatPattern<T> build() {
		pattern.complete();
		return pattern;
	}

}
