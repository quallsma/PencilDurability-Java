package com.pillartechnology.mqualls;

public class Pencil {

	private static final int DEFAULT_POINT_DURABILITY = 100;

	private Integer pointDurability;

	public Pencil() {
		this.pointDurability = DEFAULT_POINT_DURABILITY;
	}

	public void write(PaperInterface paper, String text) {
		String textForPaper = "";

		for(char character : text.toCharArray()){
			if(pointDurability > 0){
				textForPaper += character;
				if(!(character == ' ' || character == '\n'))
				{
					if(Character.isUpperCase(character))
						pointDurability-=2;
					else
						pointDurability--;
				}
			} else {
				textForPaper+=" ";
			}
		}

		paper.appendText(textForPaper);
	}

	public Integer getPointDurability() {
		return pointDurability;
	}

	public void setPointDurability(Integer pointDurability) {
		this.pointDurability = pointDurability;
	}
}
