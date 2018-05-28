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

	@Test
	public void replaceWithWhiteSpace_shouldReplaceCharacterWithWhiteSpce() {
		paper.appendText("erase");

		paper.eraseCharacterAt(2);

		assertThat(paper.getText(), is("er se"));
	}

	@Test
	public void findOpenSpace_shouldReturnIndexForOpenSpace() {
		paper.appendText("An apple a day       the doctor away");

		assertThat(paper.findOpenSpace(), is(15));
	}

	@Test
	public void editAt_shouldReplaceCharacterAtIndexWithGivenCharacter() {
		paper.appendText(" pple");
		paper.editAt('A', 0);

		assertThat(paper.getText(), is("Apple"));
	}

	@Test
	public void editAt_shouldReplaceCharacterAtIndexWithSymbolIfCharacterIsOccupied() {
		paper.appendText("Apple");
		paper.editAt('B', 0);

		assertThat(paper.getText(), is("@pple"));
	}
}