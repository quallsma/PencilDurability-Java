package com.pillartechnology.mqualls;

public class Pencil {

	private static final int DEFAULT_POINT_DURABILITY = 100;
	private static final String WHITE_SPACE = " ";

	private Integer pointDurability;

	public Pencil() {
		this.pointDurability = DEFAULT_POINT_DURABILITY;
	}

	public Integer getPointDurability() {
		return pointDurability;
	}

	public void setPointDurability(Integer pointDurability) {
		this.pointDurability = pointDurability;
	}

	public void write(PaperInterface paper, String text) {
		paper.appendText(getTextToAppendToPaper(text));
	}

	private String getTextToAppendToPaper(String text) {
		StringBuilder textForPaper = new StringBuilder();

		for(char character : text.toCharArray()){
			if(isPointDurable()){
				textForPaper.append(character);
				DegradePointDurability(character);
			} else {
				textForPaper.append(WHITE_SPACE);
			}
		}
		return textForPaper.toString();
	}

	private void DegradePointDurability(char character) {
		if(characterIsNotWhiteSpaceOrNewLine(character))
			pointDurability -= Character.isUpperCase(character) ? 2 : 1;
	}

	private boolean characterIsNotWhiteSpaceOrNewLine(char character) {
		return !(Character.isWhitespace(character) || character == '\n');
	}

	private boolean isPointDurable() {
		return pointDurability > 0;
	}
}
