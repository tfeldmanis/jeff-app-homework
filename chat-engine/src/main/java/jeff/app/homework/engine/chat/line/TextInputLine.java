package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.function.BiConsumer;

public class TextInputLine<T> extends ChatInputLine<T> {

	public TextInputLine(BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
	}

	@Override
	public boolean isInputValid(String inputText) {
		return true;
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		return ChatAction.textInput();
	}

}
