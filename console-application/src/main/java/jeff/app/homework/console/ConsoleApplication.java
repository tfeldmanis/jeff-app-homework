package jeff.app.homework.console;

import jeff.app.homework.engine.chat.Chat;
import jeff.app.homework.engine.chat.ChatPattern;
import jeff.app.homework.engine.chat.ChatPatternBuilder;
import jeff.app.homework.engine.chat.line.DateInputLine;
import jeff.app.homework.engine.chat.line.EmailInputLine;
import jeff.app.homework.engine.chat.line.SingleChoiceInputLine;
import jeff.app.homework.engine.chat.line.TextInputLine;

import java.util.List;

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

            .addOutputLine("%s, what's your email address?", LoanApplication::getFirstName)
            .addInputLine(new EmailInputLine<>(LoanApplication::setEmail, "Please enter correct email"))
            .addOutputLine("Fantastic. We are 70%% done with the setup!")
            .addOutputLine("Your age is another important value for finding the best offers. Please enter your date of birth")
            .addInputLine(new DateInputLine<>(LoanApplication::setDateOfBirth, "The date is not valid"))

            .addOutputLine("And what do you need the money for?")
            .addInputLine(new SingleChoiceInputLine<>(List.of("Home","Car","Holidays","Big Event"), LoanApplication::setLoanPurpose, "Please enter one of the provided values"))
            .addOutputLine("Nice, I already have some options for you")

            .build();

        Chat<LoanApplication> chat = chatPattern.newChat(new LoanApplication());

        new ConsoleChatExecutor(chat).run();
    }

}
