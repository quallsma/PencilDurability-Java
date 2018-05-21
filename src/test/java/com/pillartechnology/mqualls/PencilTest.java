package com.pillartechnology.mqualls;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PencilTest {

	private static final int DEFAULT_POINT_DURABILITY = 100;

	private MockPaper paper;

	@Before
	public void setUp() {
		paper = new MockPaper();
	}

	@Test
	public void write_shouldWriteTextOnPaper() {
		Pencil pencil = new Pencil();

		pencil.write( paper, "She sells sea shells");

		assertThat( paper.getAppendTextCount(), is(1));
		assertThat( paper.getText(), is("She sells sea shells"));
	}

	@Test
	public void write_shouldWriteMoreTextOnThePaper() {
		Pencil pencil = new Pencil();

		pencil.write( paper,"She sells sea shells");
		pencil.write( paper, " down by the sea shore");

		assertThat( paper.getAppendTextCount(), is(2));
		assertThat( paper.getText(), is("She sells sea shells down by the sea shore"));
	}

	@Test
	public void constructor_shouldConstructPencilWithPointDurability() {
		Pencil pencil = new Pencil(10);

		assertThat(pencil.getPointDurability(), is(10));
	}

	@Test
	public void constructor_shouldConstructPencilWithDefaultPointDurabilityFromEmptyConstructor() {
		Pencil pencil = new Pencil();

		assertThat(pencil.getPointDurability(), is(DEFAULT_POINT_DURABILITY));
	}

	@Test
	public void write_shouldDegradePointDurabilityUntilDullPoint() {
		Pencil pencil = new Pencil(5);

		pencil.write(paper, "write");

		assertThat(pencil.getPointDurability(), is(0));
		assertThat(paper.getAppendTextCount(), is(1));
		assertThat(paper.getText(), is("write"));
	}
}