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
		StringBuilder originalText = new StringBuilder(text);
		originalText.setCharAt(index, WHITE_SPACE);

		this.text = originalText.toString();
	}
}
