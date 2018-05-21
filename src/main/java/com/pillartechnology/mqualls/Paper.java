package com.pillartechnology.mqualls;

public class Paper implements PaperInterface {
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
}
