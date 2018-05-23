package com.pillartechnology.mqualls;

import com.sun.deploy.util.StringUtils;

public class Pencil {

	private static final int DEFAULT_POINT_DURABILITY = 40000;
	private static final int DEFAULT_LENGTH_VALUE = 100;
	private static final String WHITE_SPACE = " ";

	private Integer pointDurability;
	private Integer lengthValue;

	public Pencil() {
		setPointDurabilityToDefault();
		this.lengthValue = DEFAULT_LENGTH_VALUE;
	}

	public Integer getPointDurability() {
		return pointDurability;
	}

	public void setPointDurability(Integer pointDurability) {
		this.pointDurability = pointDurability;
	}

	public Integer getLengthValue() {
		return lengthValue;
	}

	public void setLengthValue(Integer lengthValue) {
		this.lengthValue = lengthValue;
	}

	public void write(PaperInterface paper, String text) {
		paper.appendText(getTextToAppendToPaper(text));
	}

	private String getTextToAppendToPaper(String text) {
		StringBuilder textForPaper = new StringBuilder();

		for(char character : text.toCharArray()){
			textForPaper.append(getCharacterToAppend(textForPaper, character));
		}
		return textForPaper.toString();
	}

	private String getCharacterToAppend(StringBuilder textForPaper, char character) {
		if(isPointDurable()){
			DegradePointDurability(character);
			return String.valueOf(character);
		} else {
			return WHITE_SPACE;
		}
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

	public void sharpen() {
		if(canPencilBeSharpen()){
			setPointDurabilityToDefault();
			lengthValue--;
		}
	}

	private void setPointDurabilityToDefault() {
		this.pointDurability = DEFAULT_POINT_DURABILITY;
	}

	private boolean canPencilBeSharpen() {
		return lengthValue > 0;
	}
}
