package com.pillartechnology.mqualls;

public class Paper implements PaperInterface {
	private String text;

	public Paper() {
		this.text = "";
	}

	public String getText() {
		return text;
	}

	@Override
	public Integer findLastOccurrence(String instance) {
		return text.lastIndexOf(instance);
	}

	public void appendText(String text) {
		this.text += text;
	}
}
