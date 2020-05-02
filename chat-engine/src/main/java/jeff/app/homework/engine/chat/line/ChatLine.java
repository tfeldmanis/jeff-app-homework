package jeff.app.homework.engine.chat.line;

import jeff.app.homework.engine.chat.action.ChatAction;

public interface ChatLine<T> {

	ChatAction getChatAction(T domainObject);

}
