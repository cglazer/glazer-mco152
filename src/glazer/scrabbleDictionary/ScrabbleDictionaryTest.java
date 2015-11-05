package glazer.scrabbleDictionary;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {
	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary s = ScrabbleDictionary.getInstance();
		Assert.assertTrue(s.contains("Hello"));
	}

}
