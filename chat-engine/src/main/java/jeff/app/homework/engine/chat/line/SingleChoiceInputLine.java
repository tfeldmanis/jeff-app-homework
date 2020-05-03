package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.*;
import java.util.function.BiConsumer;

public class SingleChoiceInputLine<T> extends ChatInputLine<T, String> {

	private final Set<String> options;

	public SingleChoiceInputLine(List<String> options, BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
		this.options = Collections.unmodifiableSet(new LinkedHashSet<>(options));
	}

	@Override
	public boolean isInputValid(String inputText) {
		return options.contains(inputText);
	}

	@Override
	public String parseInput(String inputText) {
		return inputText;
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		return ChatAction.singleChoiceInput(new ArrayList<>(options));
	}

}
