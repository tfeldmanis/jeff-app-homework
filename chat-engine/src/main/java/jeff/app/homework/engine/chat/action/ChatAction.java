package jeff.app.homework.engine.chat.action;

import java.util.List;

public class ChatAction {

	public static ChatAction textOutput(String text) {
		return new ChatAction(ChatActionType.TEXT_OUTPUT, text, null);
	}

	public static ChatAction errorOutput(String text) {
		return new ChatAction(ChatActionType.ERROR_OUTPUT, text, null);
	}

	public static ChatAction textInput() {
		return new ChatAction(ChatActionType.TEXT_INPUT, null, null);
	}

	public static ChatAction textInputWithGuide(String text) {
		return new ChatAction(ChatActionType.TEXT_INPUT_WITH_GUIDE, text, null);
	}

	public static ChatAction singleChoiceInput(List<String> options) {
		return new ChatAction(ChatActionType.SINGLE_CHOICE_INPUT, null, options);
	}

	public static ChatAction finish() {
		return new ChatAction(ChatActionType.FINISH, null, null);
	}

	private final ChatActionType chatActionType;
	private final String text;
	private final List<String> options;

	private ChatAction(ChatActionType chatActionType, String text, List<String> options) {
		this.chatActionType = chatActionType;
		this.text = text;
		this.options = options;
	}

	public ChatActionType getChatActionType() {
		return chatActionType;
	}

	public String getText() {
		return text;
	}

	public List<String> getOptions() {
		return options;
	}
}
