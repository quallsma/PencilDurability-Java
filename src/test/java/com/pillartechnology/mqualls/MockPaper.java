package com.pillartechnology.mqualls;

public class MockPaper implements PaperInterface {

	private String text;
	private Integer appendTextCount;

	public MockPaper(){
		this.text = "";
		this.appendTextCount = 0;
	}

	public String getText() {
		return this.text;
	}

	public void appendText(String text) {
		this.appendTextCount++;
		this.text += text;
	}

	public Integer findLastOccurrence(String instance) {
		return null;
	}

	public Integer getAppendTextCount() {
		return appendTextCount;
	}

	public void eraseCharacterAt(Integer index) {

	}
}
