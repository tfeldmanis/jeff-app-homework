package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.line.ChatLine;

import java.util.ArrayList;
import java.util.List;

public class Chat<T> {

	private T domainObject;
	private final List<ChatLine> lines = new ArrayList<>();

	public Chat(T domainObject) {
		this.domainObject = domainObject;
	}

	public T process() {
		validateInternalState();

		return domainObject;
	}

	public void addLine(ChatLine line) {
		lines.add(line);
	}

	private void validateInternalState() {
		if (domainObject == null) {
			throw new IllegalStateException("Domain object has to be set");
		}

		if (lines.isEmpty()) {
			throw new IllegalStateException("There has to be at least one line in the chat");
		}
	}

}
