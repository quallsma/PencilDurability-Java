package com.pillartechnology.mqualls;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PaperTest {


	@Test
	public void addText_shouldAddTextToPaper() {
		Paper paper = new Paper();

		paper.addText("text");

		assertThat(paper.getText(), is("text"));
	}

	@Test
	public void addText_shouldAddToText() {
		Paper paper = new Paper();

		paper.addText("sample");
		paper.addText(" text");

		assertThat(paper.getText(), is("sample text"));
	}
}