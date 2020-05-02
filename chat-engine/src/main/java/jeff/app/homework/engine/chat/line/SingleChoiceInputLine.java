package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.List;
import java.util.function.BiConsumer;

public class SingleChoiceInputLine<T> extends ChatInputLine<T> {

	private final List<String> options;

	public SingleChoiceInputLine(List<String> options, BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
		this.options = options;
	}

	@Override
	public boolean isInputValid(String inputText) {
		return true;
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		return ChatAction.singleChoiceInput(options);
	}

}
