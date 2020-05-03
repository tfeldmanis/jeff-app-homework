package jeff.app.homework.engine.chat.line;

import java.util.function.BiConsumer;

public abstract class ChatInputLine<T, I> implements ChatLine<T> {

	private BiConsumer<T, I> domainObjectSetter;
	private String errorMessage;

	public ChatInputLine(BiConsumer<T, I> domainObjectSetter, String errorMessage) {
		this.domainObjectSetter = domainObjectSetter;
		this.errorMessage = errorMessage;
	}

	public abstract boolean isInputValid(String inputText);

	public abstract I parseInput(String inputText);

	public void processInput(T domainObject, I input) {
		domainObjectSetter.accept(domainObject, input);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
