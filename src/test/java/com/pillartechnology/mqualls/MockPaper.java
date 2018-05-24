package com.pillartechnology.mqualls;

public class MockPaper implements PaperInterface {

	private String text;
	private Integer appendTextCount;
	private Integer findLastOccurrenceCount;
	private Integer eraseCharacterAtCount;

	public MockPaper(){
		this.text = "";
		this.appendTextCount = 0;
		this.findLastOccurrenceCount = 0;
		this.eraseCharacterAtCount = 0;
	}

	public String getText() {
		return this.text;
	}

	public void appendText(String text) {
		this.appendTextCount++;
		this.text += text;
	}

	public Integer findLastOccurrence(String instance) {
		findLastOccurrenceCount++;
		return text.lastIndexOf(instance);
	}

	public void eraseCharacterAt(Integer index) {
		StringBuilder originalText = new StringBuilder(text);
		originalText.setCharAt(index, ' ');
		this.text = originalText.toString();
		eraseCharacterAtCount++;
	}

	public Integer getAppendTextCount() {
		return appendTextCount;
	}

	public Integer getFindLastOccurrenceCOunt() {
		return findLastOccurrenceCount;
	}

	public Integer getEraseCharacterAtCount() {
		return eraseCharacterAtCount;
	}
}
