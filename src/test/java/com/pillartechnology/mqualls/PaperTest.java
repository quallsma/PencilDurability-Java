package com.pillartechnology.mqualls;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PaperTest {


	@Test
	public void appendText_shouldAppendTextToPaper() {
		Paper paper = new Paper();

		paper.appendText("text");

		assertThat(paper.getText(), is("text"));
	}

	@Test
	public void appendText_shouldAppendMoreTextToPaper() {
		Paper paper = new Paper();

		paper.appendText("sample");
		paper.appendText(" text");

		assertThat(paper.getText(), is("sample text"));
	}
}