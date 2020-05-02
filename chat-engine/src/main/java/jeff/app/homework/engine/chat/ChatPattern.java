package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.line.ChatLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatPattern<T> {
	private List<ChatLine<T>> lines = new ArrayList<>();
	private boolean completed;

	public Chat<T> newChat(T domainObject) {

		if (!completed) {
			throw new IllegalStateException("Pattern has to be completed before creating chat instances");
		}

		return new Chat<>(this, domainObject);
	}

	void addLine(ChatLine<T> line) {
		lines.add(line);
	}

	ChatLine<T> getLine(int index) {
		return lines.get(index);
	}

	int lineCount() {
		return lines.size();
	}

	void complete() {

		if (lineCount() == 0) {
			throw new IllegalStateException("Chat pattern has to contain at least one line");
		}

		this.lines = Collections.unmodifiableList(this.lines);
		this.completed = true;
	}

}
