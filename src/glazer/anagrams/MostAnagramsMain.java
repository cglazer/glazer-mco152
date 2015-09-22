package glazer.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagramsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedWord sw = new SortedWord();
		Scanner inputFile;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, String> wordsWSort = new HashMap<String, String>();
		String word = null;
		String sortedWord = null;
		try {
			inputFile = new Scanner(new File("US.dic"));
			while (inputFile.hasNext()) {
				word = inputFile.next();
				sortedWord = sw.sort(word);
				wordsWSort.put(word, sortedWord);
				if (!(map.containsKey(sortedWord))) {
					map.put(sortedWord, 1);
				} else {
					int value = map.get(sortedWord);
					map.put(sortedWord, value + 1);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int highest = 0;
		String same = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue().compareTo(highest) > 0) {
				highest = entry.getValue();
				same = entry.getKey();
			}
		}
		for (Map.Entry<String, String> s : wordsWSort.entrySet()) {
			if (s.getValue().equalsIgnoreCase(same)) {
				System.out.println(s.getKey());
			}
		}
	}
}
