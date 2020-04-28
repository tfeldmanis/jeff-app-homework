package jeff.app.homework.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChatEngineTest {

	@Test
	void testHelloWorld() {
		assertEquals("Hello world!", new ChatEngine().helloWorld());
	}

}
