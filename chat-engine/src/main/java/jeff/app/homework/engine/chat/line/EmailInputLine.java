package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.util.function.BiConsumer;
import java.util.regex.Pattern;

public class EmailInputLine<T> extends ChatInputLine<T, String> {

	// This regex is brutally simple, but fits for our purpose well
	private Pattern emailRegex = Pattern.compile("^.+@.+\\..+$");

	public EmailInputLine(BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
	}

	@Override
	public boolean isInputValid(String inputText) {
		return emailRegex.matcher(inputText).matches();
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
