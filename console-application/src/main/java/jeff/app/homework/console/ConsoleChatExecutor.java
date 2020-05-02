package jeff.app.homework.console;

import jeff.app.homework.engine.chat.Chat;
import jeff.app.homework.engine.chat.action.ChatAction;
import jeff.app.homework.engine.chat.action.ChatActionType;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleChatExecutor {

	private final PrintStream consoleOut;
	private final Scanner consoleIn;
	private final Chat<?> chat;

	public ConsoleChatExecutor(Chat<?> chat) {
		this.consoleOut = System.out;
		this.consoleIn = new Scanner(System.in);
		this.chat = chat;
	}

	public void run() {
		ChatAction curChatAction = chat.getNextAction();
		while (curChatAction.getChatActionType() != ChatActionType.FINISH) {
			executeAction(curChatAction);
			curChatAction = chat.getNextAction();
		}
	}

	private void executeAction(ChatAction chatAction) {
		switch (chatAction.getChatActionType()) {
			case TEXT_OUTPUT:
			case ERROR_OUTPUT:
				printLine(chatAction.getText());
				break;
			case TEXT_INPUT:
				readLine();
				break;
			case TEXT_INPUT_WITH_GUIDE:
				printLine(chatAction.getText());
				readLine();
				break;
			case SINGLE_CHOICE_INPUT:
				printLine("Possible options are: " + chatAction.getOptions());
				readLine();
				break;
		}
	}

	private void printLine(String text) {
		consoleOut.println(text);
	}

	private void readLine() {
		Optional<ChatAction> chatErrorAction = chat.receiveInput(consoleIn.nextLine());
		chatErrorAction.ifPresent(this::executeAction);
	}

}
