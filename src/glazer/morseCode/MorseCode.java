package glazer.morseCode;

public class MorseCode {
	private char[] alphabet;
	private String[] morseCode;

	public MorseCode() {
		this.alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', '0' };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--..", "|" };
	}

	public String encode(String message) {
		String code = "";
		if (message.charAt(0) == ' ') {
			code += "   ";

		} else {
			for (int j = 0; j < this.alphabet.length; j++) {
				if (message.toLowerCase().toLowerCase().charAt(0) == this.alphabet[j]) {
					code += this.morseCode[j];
					break;
				}
			}
		}
		for (int i = 1; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				code += "   ";
			} else {
				for (int j = 0; j < this.alphabet.length; j++) {
					if (message.toLowerCase().charAt(i) == this.alphabet[j]) {
						if (message.charAt(i - 1) == ' ') {
							code += this.morseCode[j];
							break;
						} else {
							code += " " + this.morseCode[j];
							break;
						}
					}
				}
			}
		}

		return code;
	}

	public String decode(String code) {
		String message = "";
		String[] messageWords = code.split("   ");
		for (int y = 0; y < messageWords.length; y++) {
			String[] wordLetters = messageWords[y].split(" ");
			for (int i = 0; i < wordLetters.length; i++) {
				for (int j = 0; j < this.morseCode.length; j++) {
					if (wordLetters[i].equalsIgnoreCase(this.morseCode[j])) {
						message += this.alphabet[j];
						break;
					}
				}
			}
			if (messageWords.length - 1 > y) {
				message += " ";
			}
		}
		return message;
	}

}
