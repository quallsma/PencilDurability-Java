package com.pillartechnology.mqualls;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PencilTest {

	@Test
	public void write_shouldWriteTextOnPaper() {
		MockPaper paper = new MockPaper();
		Pencil pencil = new Pencil(paper);

		pencil.write("She sells sea shells");

		assertThat(paper.getAddTextCount(), is(1));
	}

	@Test
	public void write_shouldWriteMoreTextOnThePaper() {
		MockPaper paper = new MockPaper();
		Pencil pencil = new Pencil(paper);

		pencil.write("She sells sea shells");
		pencil.write(" down by the sea shore");

		assertThat(paper.getAddTextCount(), is(2));
	}
}