package glazer.scrabbleDictionary;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {
@Test
public void testContains() throws FileNotFoundException{
	ScrabbleDictionary s= new ScrabbleDictionary();
	
	Assert.assertTrue(s.contains("Hello"));
}
}
