package com.pillartechnology.mqualls;

public interface PaperInterface {
	void appendText(String text);
	String getText();

	Integer findLastOccurrence(String instance);
}
