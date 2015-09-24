package glazer.scrabbleDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		this.dictionary = new HashSet<String>();
		String line;
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader("US.dic"));
			while ((line = inputFile.readLine()) != null) {
				this.dictionary.add(line);
			}
			inputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param word
	 *            --the word the user entered
	 * @return true if the word exists in the dictionary or false if the word
	 *         doesn't exist
	 */
	public boolean contains(String word) {
		return this.dictionary.contains(word.toLowerCase());
	}
}
