package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.action.ChatAction;
import jeff.app.homework.engine.chat.line.ChatInputLine;
import jeff.app.homework.engine.chat.line.ChatLine;

import java.util.Optional;

public class Chat<T> {

	private final ChatPattern<T> pattern;
	private final T domainObject;
	private int nextLine = 0;
	private boolean waitingForInput = false;

	public Chat(ChatPattern<T> pattern, T domainObject) {
		this.pattern = pattern;
		this.domainObject = domainObject;
	}

	public ChatAction getNextAction() {

		if (waitingForInput) {
			return pattern.getLine(nextLine - 1).getChatAction(domainObject);
		}

		if (nextLine >= pattern.lineCount()) {
			return ChatAction.finish();
		}

		ChatLine<T> nextLine = pattern.getLine(this.nextLine++);
		if (nextLine instanceof ChatInputLine) {
			waitingForInput = true;
		}

		return nextLine.getChatAction(domainObject);
	}

	public <I> Optional<ChatAction> receiveInput(String input) {

		if (!waitingForInput) {
			throw new IllegalStateException("Chat not waiting for input");
		}

		ChatInputLine<T, I> curInputLine = (ChatInputLine<T, I>) pattern.getLine(nextLine - 1);
		if (!curInputLine.isInputValid(input)) {
			return Optional.of(ChatAction.errorOutput(curInputLine.getErrorMessage()));
		}

		curInputLine.processInput(domainObject, curInputLine.parseInput(input));
		waitingForInput = false;
		return Optional.empty();
	}

}
