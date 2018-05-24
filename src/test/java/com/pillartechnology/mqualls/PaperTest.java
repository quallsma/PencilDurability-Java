package com.pillartechnology.mqualls;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PaperTest {

	private Paper paper;

	@Before
	public void setUp() {
		paper = new Paper();
	}

	@Test
	public void appendText_shouldAppendTextToPaper() {
		paper.appendText("text");

		assertThat(paper.getText(), is("text"));
	}

	@Test
	public void appendText_shouldAppendMoreTextToPaper() {
		paper.appendText("sample");
		paper.appendText(" text");

		assertThat(paper.getText(), is("sample text"));
	}

	@Test
	public void findLastOccurrence_shouldFindTheLastInstanceOfString() {
		paper.appendText("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

		Integer actual = paper.findLastOccurrence("chuck");

		assertThat(actual, is(59));
	}
}