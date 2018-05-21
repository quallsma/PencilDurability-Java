package com.pillartechnology.mqualls;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PencilTest {

	@Test
	public void write_shouldWriteTextOnPaper() {
		MockPaper paper = new MockPaper();
		Pencil pencil = new Pencil();

		pencil.write( paper, "She sells sea shells");

		assertThat(paper.getAddTextCount(), is(1));
		assertThat(paper.getText(), is("She sells sea shells"));
	}

	@Test
	public void write_shouldWriteMoreTextOnThePaper() {
		MockPaper paper = new MockPaper();
		Pencil pencil = new Pencil();

		pencil.write( paper,"She sells sea shells");
		pencil.write( paper, " down by the sea shore");

		assertThat(paper.getAddTextCount(), is(2));
		assertThat(paper.getText(), is("She sells sea shells down by the sea shore"));
	}
}