package com.pillartechnology.mqualls;

public class Paper implements PaperInterface {
	private String text;

	public Paper() {
		this.text = "";
	}

	public String getText() {
		return text;
	}

	public void addText(String text) {
		this.text += text;
	}
}
