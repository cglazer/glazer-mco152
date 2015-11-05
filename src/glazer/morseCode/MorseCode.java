package glazer.morseCode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
	private char[] alphabet;
	private String[] morseCode;
	private HashMap<Character, String> encode;
	private HashMap<String, Character> decode;

	public MorseCode() {
		this.alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', ' ' };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--..", "  " };
		this.encode = new HashMap<Character, String>();
		for (int i = 0; i < alphabet.length; i++) {
			encode.put(alphabet[i], morseCode[i]);
		}
		this.decode = new HashMap<String, Character>();
		for (int i = 0; i < alphabet.length; i++) {
			decode.put(morseCode[i], alphabet[i]);
		}
	}

	public String encode(String message) {
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			// if(encode.containsKey(message.charAt(i))
			for (Map.Entry<Character, String> entry : encode.entrySet()) {
				if (message.toLowerCase().charAt(i) == entry.getKey()) {
					if (i == 0 || message.charAt(i - 1) == ' ') {
						code.append(entry.getValue());
						break;
					} else {
						code.append(" ");
						code.append(entry.getValue());
						break;
					}
				}
			}
		}
		return code.toString();
	}

	public String decode(String code) {
		StringBuilder message = new StringBuilder();
		String[] messageWords = code.split("   ");
		for (int y = 0; y < messageWords.length; y++) {
			String[] wordLetters = messageWords[y].split(" ");
			for (int i = 0; i < wordLetters.length; i++) {
				for (Map.Entry<String, Character> entry : decode.entrySet()) {
					if (wordLetters[i].equals(entry.getKey())) {
						message.append(entry.getValue());
						break;
					}
				}
			}
			if (messageWords.length - 1 > y) {
				message.append(" ");
			}
		}
		return message.toString();
	}
}
