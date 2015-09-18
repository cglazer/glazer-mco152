package glazer.morseCode;

import java.util.HashMap;

public class MorseCode {
	private char[] alphabet;
	private String[] morseCode;

	public MorseCode() {
		this.alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--..", "|" };
		HashMap<Character, String> encode = new HashMap<Character, String>();
		for (int i = 0; i < alphabet.length; i++) {
			encode.put(alphabet[i], morseCode[i]);
		}
		HashMap<String, Character> decode = new HashMap<String, Character>();
		for (int i = 0; i < alphabet.length; i++) {
			decode.put(morseCode[i], alphabet[i]);
		}
	}

	public String encode(String message) {
		StringBuilder code = new StringBuilder();
		code.append("");
		if (message.charAt(0) == ' ') {
			code.append("   ");

		} else {
			for (int j = 0; j < this.alphabet.length; j++) {
				if (message.toLowerCase().toLowerCase().charAt(0) == this.alphabet[j]) {
					code.append(this.morseCode[j]);
					break;
				}
			}
		}
		for (int i = 1; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				code.append("   ");
			} else {
				for (int j = 0; j < this.alphabet.length; j++) {
					if (message.toLowerCase().charAt(i) == this.alphabet[j]) {
						if (message.charAt(i - 1) == ' ') {
							code.append(this.morseCode[j]);
							break;
						} else {
							code.append(" ");
							code.append(this.morseCode[j]);
							break;
						}
					}
				}
			}
		}

		return code.toString();
	}

	public String decode(String code) {
		StringBuilder message = new StringBuilder();
		message.append("");
		String[] messageWords = code.split("   ");
		for (int y = 0; y < messageWords.length; y++) {
			String[] wordLetters = messageWords[y].split(" ");
			for (int i = 0; i < wordLetters.length; i++) {
				for (int j = 0; j < this.morseCode.length; j++) {
					if (wordLetters[i].equalsIgnoreCase(this.morseCode[j])) {
						message.append(this.alphabet[j]);
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
