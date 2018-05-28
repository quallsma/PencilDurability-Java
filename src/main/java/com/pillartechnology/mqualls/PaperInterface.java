package com.pillartechnology.mqualls;

public interface PaperInterface {

	String getText();

	void appendText(String text);

	Integer findLastOccurrence(String instance);

	void eraseCharacterAt(Integer index);

	Integer findOpenSpace();

	void editAt(char character, Integer index);
}
