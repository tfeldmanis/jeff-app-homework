package jeff.app.homework.console;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleApplicationTest {

	@Test
	void fullConsoleFlow() {

		PrintStream printStream = mock(PrintStream.class);
		Scanner scanner = mock(Scanner.class);
		ConsoleChatExecutor consoleChatExecutor = new ConsoleChatExecutor(printStream, scanner);

		setupConsoleInputs(scanner);
		LoanApplication loanApplication = ConsoleApplication.run(consoleChatExecutor);

		verify(printStream).println("🤖: Hi there, I'm Jeff 👋");
		verify(printStream).println("🤖: Please enter correct email");
		verify(printStream).println("🤖: Nice, I already have some options for you");
		verify(printStream, times(6)).print("👧: ");

		assertEquals("Jon", loanApplication.getFirstName());
		assertEquals("Doe", loanApplication.getLastName());
		assertEquals("jon.doe@mailinator.com", loanApplication.getEmail());
		assertEquals(LocalDate.of(1990, 2, 1), loanApplication.getDateOfBirth());
		assertEquals("Big Event", loanApplication.getLoanPurpose());
	}

	private void setupConsoleInputs(Scanner scanner) {
		when(scanner.nextLine())
				.thenReturn("Jon")
				.thenReturn("Doe")
				.thenReturn("jon.doe@")
				.thenReturn("jon.doe@mailinator.com")
				.thenReturn("01-02-1990")
				.thenReturn("Big Event");
	}

}
