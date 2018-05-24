package com.pillartechnology.mqualls;

public class MockPaper implements PaperInterface {

	private String text;
	private Integer appendTextCount;

	public MockPaper(){
		this.text = "";
		this.appendTextCount = 0;
	}

	@Override
	public void appendText(String text) {
		this.appendTextCount++;
		this.text += text;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public Integer findLastOccurrence(String instance) {
		return null;
	}

	public Integer getAppendTextCount() {
		return appendTextCount;
	}
}
