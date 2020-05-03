package jeff.app.homework.engine.chat.line;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputLineValidationTests {

	@Test
	void textInputLine() {
		TextInputLine<?> line = new TextInputLine<>((a, b) -> {}, "");

		assertFalse(line.isInputValid(""));
		assertFalse(line.isInputValid("  "));

		assertTrue(line.isInputValid("a"));
		assertTrue(line.isInputValid("abc123"));
	}

	@Test
	void textEmailLine() {
		EmailInputLine<?> line = new EmailInputLine<>((a, b) -> {}, "");

		assertFalse(line.isInputValid(""));
		assertFalse(line.isInputValid("  "));
		assertFalse(line.isInputValid("@gmail.com"));
		assertFalse(line.isInputValid("test@gmail."));
		assertFalse(line.isInputValid("@gmail."));
		assertFalse(line.isInputValid("test@gmail"));

		assertTrue(line.isInputValid("test@gmail.com"));
		assertTrue(line.isInputValid("jon.doe@inbox.lv"));
	}

	@Test
	void dateInputLine() {
		DateInputLine<?> line = new DateInputLine<>((a, b) -> {}, "");

		assertFalse(line.isInputValid(""));
		assertFalse(line.isInputValid("  "));
		assertFalse(line.isInputValid("---"));
		assertFalse(line.isInputValid("2016-01-01"));
		assertFalse(line.isInputValid("12-12-12"));
		assertFalse(line.isInputValid("02-30-2000"));
		assertFalse(line.isInputValid("15-13-2000"));

		assertTrue(line.isInputValid("12-06-2000"));
		assertTrue(line.isInputValid("01-01-1990"));
	}

	@Test
	void singleChoiceInputLine() {
		SingleChoiceInputLine<?> line = new SingleChoiceInputLine<>(List.of("Travel", "Construction"), (a, b) -> {}, "");

		assertFalse(line.isInputValid(""));
		assertFalse(line.isInputValid("  "));
		assertFalse(line.isInputValid("Leisure"));

		assertTrue(line.isInputValid("Travel"));
		assertTrue(line.isInputValid("Construction"));
	}

}
