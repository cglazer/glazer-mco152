package glazer.anagrams;

import java.util.Arrays;

public class SortedWord {
	private char[] chars;

	public SortedWord() {
	this.chars= null;
	}

	public String sort(String word) {
		this.chars = word.toCharArray();
		Arrays.sort(this.chars);
		return new String(this.chars);
	}
}
