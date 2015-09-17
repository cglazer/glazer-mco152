package glazer.scrabbleDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {
	private ArrayList<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {
		this.dictionary = new ArrayList<String>();
		Scanner inputFile = new Scanner(new File("US.dic"));
		while (inputFile.hasNext()) {
			this.dictionary.add(inputFile.next());
		}
		inputFile.close();

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
