package glazer.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {
	MorseCode m = new MorseCode();

	@Test
	public void testEncode() {

		Assert.assertEquals(m.encode("Hello how are you"),
				".... . .-.. .-.. ---   .... --- .--   .- .-. .   -.-- --- ..-");
	}

	@Test
	public void testDecode() {

		Assert.assertEquals(
				m.decode(".... . .-.. .-.. ---   .... --- .--   .- .-. .   -.-- --- ..-"),
				"hello how are you");
	}

}
