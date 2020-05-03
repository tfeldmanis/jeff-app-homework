package jeff.app.homework.engine.chat;

import jeff.app.homework.engine.chat.action.ChatAction;
import jeff.app.homework.engine.chat.action.ChatActionType;
import jeff.app.homework.engine.chat.line.DateInputLine;
import jeff.app.homework.engine.chat.line.EmailInputLine;
import jeff.app.homework.engine.chat.line.SingleChoiceInputLine;
import jeff.app.homework.engine.chat.line.TextInputLine;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChatTest {

	@Test
	void positiveFlowWithAllInputTypes() {
		ChatPattern<TestingPojo> chatPattern = new ChatPatternBuilder<TestingPojo>()
				.addOutputLine("Hi! 👋")
				.addInputLine(new TextInputLine<>(TestingPojo::setText, ""))
				.addInputLine(new EmailInputLine<>(TestingPojo::setEmail, ""))
				.addInputLine(new DateInputLine<>(TestingPojo::setDate, ""))
				.addInputLine(new SingleChoiceInputLine<>(List.of("Home","Car"), TestingPojo::setSingleChoice, ""))
				.build();

		TestingPojo testingPojo = new TestingPojo();
		Chat<TestingPojo> chat = chatPattern.newChat(testingPojo);

		assertAction(chat.getNextAction(), ChatActionType.TEXT_OUTPUT, "Hi! 👋");
		assertAction(chat.getNextAction(), ChatActionType.TEXT_INPUT);
		chat.receiveInput("Jon Doe");

		assertAction(chat.getNextAction(), ChatActionType.TEXT_INPUT);
		chat.receiveInput("test@mailinator.com");

		assertAction(chat.getNextAction(), ChatActionType.TEXT_INPUT_WITH_GUIDE, "DD-MM-YYYY");
		chat.receiveInput("30-01-1990");

		assertAction(chat.getNextAction(), ChatActionType.SINGLE_CHOICE_INPUT, List.of("Home","Car"));
		chat.receiveInput("Car");

		assertAction(chat.getNextAction(), ChatActionType.FINISH);

		assertEquals(testingPojo.getText(), "Jon Doe");
		assertEquals(testingPojo.getEmail(), "test@mailinator.com");
		assertEquals(testingPojo.getDate(), LocalDate.of(1990, 1, 30));
		assertEquals(testingPojo.getSingleChoice(), "Car");
	}

	@Test
	void validationFlow() {
		ChatPattern<TestingPojo> chatPattern = new ChatPatternBuilder<TestingPojo>()
				.addInputLine(new TextInputLine<>(TestingPojo::setText, "Wrong text input!"))
				.build();

		TestingPojo testingPojo = new TestingPojo();
		Chat<TestingPojo> chat = chatPattern.newChat(testingPojo);

		assertAction(chat.getNextAction(), ChatActionType.TEXT_INPUT);
		assertAction(chat.receiveInput(" ").orElseThrow(), ChatActionType.ERROR_OUTPUT, "Wrong text input!");

		assertAction(chat.getNextAction(), ChatActionType.TEXT_INPUT);
		chat.receiveInput("Jon Doe");

		assertAction(chat.getNextAction(), ChatActionType.FINISH);

		assertEquals(testingPojo.getText(), "Jon Doe");
	}

	@Test
	void unableToReceiveInputIfNotWaitingForIt() {
		ChatPattern<TestingPojo> chatPattern = new ChatPatternBuilder<TestingPojo>()
				.addInputLine(new TextInputLine<>(TestingPojo::setText, ""))
				.build();

		Chat<TestingPojo> chat = chatPattern.newChat(new TestingPojo());

		assertThrows(
				IllegalStateException.class,
				() -> chat.receiveInput("Jon Doe"),
				"Chat not waiting for input"
		);
	}

	@Test
	void notPossibleToCreateEmptyChat() {
		assertThrows(
				IllegalStateException.class,
				() -> new ChatPatternBuilder<TestingPojo>().build(),
				"Chat pattern has to contain at least one line"
		);
	}

	@Test
	void unableToSpawnChatFromNonCompletedPattern() {
		assertThrows(
				IllegalStateException.class,
				() -> new ChatPattern<TestingPojo>().newChat(new TestingPojo()),
				"Pattern has to be completed before creating chat instances"
		);
	}

	private void assertAction(ChatAction action, ChatActionType type) {
		assertEquals(type, action.getChatActionType());
		assertNull(action.getText());
		assertNull(action.getOptions());
	}

	private void assertAction(ChatAction action, ChatActionType type, String text) {
		assertEquals(type, action.getChatActionType());
		assertEquals(text, action.getText());
		assertNull(action.getOptions());
	}

	private void assertAction(ChatAction action, ChatActionType type, List<String> options) {
		assertEquals(type, action.getChatActionType());
		assertNull(action.getText());
		assertEquals(options, action.getOptions());
	}

}
