package com.pillartechnology.mqualls;

public class Pencil {

	private static final int DEFAULT_POINT_DURABILITY = 100;

	private Integer pointDurability;

	public Pencil() {
		this.pointDurability = DEFAULT_POINT_DURABILITY;
	}

	public Pencil(Integer pointDurability) {
		this.pointDurability = pointDurability;
	}

	public void write(PaperInterface paper, String text) {
		paper.appendText(text);

		this.pointDurability-=text.length();
	}

	public Integer getPointDurability() {
		return pointDurability;
	}
}
