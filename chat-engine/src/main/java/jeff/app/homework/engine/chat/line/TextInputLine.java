package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.function.BiConsumer;

public class TextInputLine<T> extends ChatInputLine<T, String> {

	public TextInputLine(BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
	}

	@Override
	public boolean isInputValid(String inputText) {
		return !inputText.isBlank();
	}

	@Override
	public String parseInput(String inputText) {
		return inputText;
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		return ChatAction.textInput();
	}

}
