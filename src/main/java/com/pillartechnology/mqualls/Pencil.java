package com.pillartechnology.mqualls;

public class Pencil {

	private PaperInterface paper;

	public Pencil(PaperInterface paper) {
		this.paper = paper;
	}

	public void write(String text) {
		this.paper.addText(text);
	}
}
