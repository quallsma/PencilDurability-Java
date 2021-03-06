package com.pillartechnology.mqualls;

public class Pencil {

	private static final Integer DEFAULT_POINT_DURABILITY = 40000;
	private static final String WHITE_SPACE = " ";

	private Integer pointDurability;
	private Integer lengthValue;
	private Integer eraserDurability;

	public Pencil(Integer defaultPointDurability, Integer defaultLengthValue, Integer eraserDurability) {
		setPointDurabilityToDefault(defaultPointDurability);
		this.lengthValue = defaultLengthValue;
		this.eraserDurability = eraserDurability;
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

	public Integer getEraserDurability() {
		return eraserDurability;
	}

	public void setEraserDurability(Integer eraserDurability) {
		this.eraserDurability = eraserDurability;
	}

	public void write(String text, PaperInterface paper) {
		paper.appendText(getTextToAppendToPaper(text));
	}

	public void sharpen() {
		if(canPencilBeSharpen()){
			setPointDurabilityToDefault(DEFAULT_POINT_DURABILITY);
			lengthValue--;
		}
	}

	public void erase(String instance, PaperInterface paper) {
		Integer lastOccurrenceOfInstance = paper.findLastOccurrence(instance);

		for(int index = instance.length() - 1; index >= 0 && eraserDurability > 0; index--){
			paper.eraseCharacterAt(lastOccurrenceOfInstance + index);
			eraserDurability--;
		}
	}

	public void edit(String word, PaperInterface paper) {
		Integer openSpaceIndex = paper.findOpenSpace();
		char[] chars = word.toCharArray();

		for(int index = 0; index < word.length() ;index++) {
			paper.editAt(chars[index], openSpaceIndex + index);
		}

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

	private void setPointDurabilityToDefault(Integer defaultPointDurability) {
		this.pointDurability = defaultPointDurability;
	}

	private boolean canPencilBeSharpen() {
		return lengthValue > 0;
	}
}
