package com.pillartechnology.mqualls;

public class Pencil {

	private static final int DEFAULT_POINT_DURABILITY = 40000;
	private static final String WHITE_SPACE = " ";

	private Integer pointDurability;
	private Integer lengthValue;

	public Pencil(int defaultPointDurability, int defaultLengthValue) {
		setPointDurabilityToDefault(defaultPointDurability);
		this.lengthValue = defaultLengthValue;
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
			textForPaper.append(getCharacterToAppend(character));
		}
		return textForPaper.toString();
	}

	private String getCharacterToAppend(char character) {
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
			setPointDurabilityToDefault(DEFAULT_POINT_DURABILITY);
			lengthValue--;
		}
	}

	private void setPointDurabilityToDefault(int defaultPointDurability) {
		this.pointDurability = defaultPointDurability;
	}

	private boolean canPencilBeSharpen() {
		return lengthValue > 0;
	}
}
