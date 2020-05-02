package jeff.app.homework.engine.chat.line;

import java.util.function.BiConsumer;

public abstract class ChatInputLine<T> implements ChatLine<T> {

	private BiConsumer<T, String> domainObjectSetter;
	private String errorMessage;

	public ChatInputLine(BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		this.domainObjectSetter = domainObjectSetter;
		this.errorMessage = errorMessage;
	}

	public abstract boolean isInputValid(String inputText);

	public void processInput(T domainObject, String input) {
		domainObjectSetter.accept(domainObject, input);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
