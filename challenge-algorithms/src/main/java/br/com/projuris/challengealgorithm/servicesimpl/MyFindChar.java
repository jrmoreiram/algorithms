package br.com.projuris.challengealgorithm.servicesimpl;

public class MyFindChar {
	public static char findChar(String word) {
		char character;
		for (int i = 0; i < word.length(); i++) {
			character = word.charAt(i);
			for (int j = i + 1; j < word.length(); j++) {
				if (character != word.charAt(j)) {
					return character;
				}
			}
		}
		return ' ';
	}
}
