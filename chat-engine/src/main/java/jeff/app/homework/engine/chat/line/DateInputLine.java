package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.BiConsumer;

public class DateInputLine<T> extends ChatInputLine<T> {

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public DateInputLine(BiConsumer<T, String> domainObjectSetter, String errorMessage) {
		super(domainObjectSetter, errorMessage);
	}

	@Override
	public boolean isInputValid(String inputText) {
		try {
			LocalDate.parse(inputText, dateTimeFormatter);
		} catch (DateTimeParseException e) {
			return false;
		}

		return true;
	}

	@Override
	public ChatAction getChatAction(T domainObject) {
		return ChatAction.textInputWithGuide("DD-MM-YYYY");
	}
	
}
