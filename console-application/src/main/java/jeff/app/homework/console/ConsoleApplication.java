package jeff.app.homework.console;

import jeff.app.homework.engine.chat.Chat;
import jeff.app.homework.engine.chat.ChatPattern;
import jeff.app.homework.engine.chat.ChatPatternBuilder;
import jeff.app.homework.engine.chat.line.TextInputLine;

public class ConsoleApplication {

    public static void main(String[] args) {
        ChatPattern<LoanApplication> chatPattern = new ChatPatternBuilder<LoanApplication>()

                .addOutputLine("Hi there, I'm Jeff")
                .addOutputLine("Your new best friend for finding great loan offers!")
                .addOutputLine("First things first - let's get your account set up")
                .addOutputLine("What is your first name?")
                .addInputLine(new TextInputLine<>(LoanApplication::setFirstName, "First name cannot be blank"))
                .addOutputLine("And what is your last name?")
                .addInputLine(new TextInputLine<>(LoanApplication::setLastName, "Last name cannot be blank"))
                .addOutputLine("Nice to meet you, %s %s!", LoanApplication::getFirstName, LoanApplication::getLastName)

                .build();

        Chat<LoanApplication> chat = chatPattern.newChat(new LoanApplication());

        new ConsoleChatExecutor(chat).run();
    }

}
