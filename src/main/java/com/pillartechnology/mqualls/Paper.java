package com.pillartechnology.mqualls;

public class Paper implements PaperInterface {

	private static final Character WHITE_SPACE = ' ';

	private String text;

	public Paper() {
		this.text = "";
	}

	public String getText() {
		return text;
	}

	public void appendText(String text) {
		this.text += text;
	}

	public Integer findLastOccurrence(String instance) {
		return text.lastIndexOf(instance);
	}

	public void eraseCharacterAt(Integer index) {
		editAt(WHITE_SPACE, index);
	}

	public Integer findOpenSpace() {
		return text.indexOf("  ") + 1;
	}

	public void editAt(char character, Integer index) {
		StringBuilder originalText = new StringBuilder(text);
		character = getCharacterToReplaceWith(character, index);
		originalText.setCharAt(index, character);

		this.text = originalText.toString();
	}

	private char getCharacterToReplaceWith(char character, Integer index){
		return character == WHITE_SPACE || text.charAt(index) == WHITE_SPACE ? character : '@';
	}
}
