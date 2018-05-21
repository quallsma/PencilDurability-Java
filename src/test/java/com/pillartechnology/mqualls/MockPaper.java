package com.pillartechnology.mqualls;

public class MockPaper implements PaperInterface {

	private String text;
	private Boolean spy;
	private Integer addTextCount;

	public MockPaper(){
		this.text = "";
		this.addTextCount = 0;
	}

	@Override
	public void appendText(String text) {
		this.addTextCount++;
		this.text += text;
	}

	@Override
	public String getText() {
		return this.text;
	}

	public Integer getAddTextCount() {
		return addTextCount;
	}
}
