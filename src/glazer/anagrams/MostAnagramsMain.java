package glazer.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostAnagramsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedWord sw = new SortedWord();

		BufferedReader inputFile;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, String> wordsWSort = new HashMap<String, String>();
		String sortedWord = null;
		try {
			inputFile = new BufferedReader(new FileReader("US.dic"));
			String word;
			while ((word = inputFile.readLine()) != null) {
				sortedWord = sw.sort(word);
				wordsWSort.put(word, sortedWord);
				if (!(map.containsKey(sortedWord))) {
					map.put(sortedWord, 1);
				} else {
					int value = map.get(sortedWord);
					map.put(sortedWord, value + 1);
				}
			}
			inputFile.close();
		} catch (IOException e) {
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
