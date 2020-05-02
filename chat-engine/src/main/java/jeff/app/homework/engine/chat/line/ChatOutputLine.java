package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.List;
import java.util.function.Function;

public class ChatOutputLine<T> implements ChatLine<T> {

	private final String textPattern;
	private final List<Function<T, String>> placeholderProviders;

	@SafeVarargs
	public ChatOutputLine(String textPattern, Function<T, String>... placeholderProviders) {
		this.textPattern = textPattern;
		this.placeholderProviders = List.of(placeholderProviders);
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		Object[] placeholderValues = placeholderProviders.stream()
				.map(pp -> pp.apply(domainObject))
				.toArray();

		String formattedText = String.format(textPattern, placeholderValues);
		return ChatAction.textOutput(formattedText);
	}

}
