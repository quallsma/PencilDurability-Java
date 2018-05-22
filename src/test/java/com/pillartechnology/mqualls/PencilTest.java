package com.pillartechnology.mqualls;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PencilTest {

	private static final int DEFAULT_POINT_DURABILITY = 100;

	private MockPaper paper;

	private Pencil pencil;

	@Before
	public void setUp() {
		paper = new MockPaper();
		pencil = new Pencil();
	}

	@Test
	public void write_shouldWriteTextOnPaper() {
		pencil.write( paper, "She sells sea shells");

		assertThat( paper.getAppendTextCount(), is(1));
		assertThat( paper.getText(), is("She sells sea shells"));
	}

	@Test
	public void write_shouldWriteMoreTextOnThePaper() {
		pencil.write( paper,"She sells sea shells");
		pencil.write( paper, " down by the sea shore");

		assertThat( paper.getAppendTextCount(), is(2));
		assertThat( paper.getText(), is("She sells sea shells down by the sea shore"));
	}

	@Test
	public void constructor_shouldConstructPencilWithDefaultPointDurabilityFromEmptyConstructor() {
		assertThat(pencil.getPointDurability(), is(DEFAULT_POINT_DURABILITY));
	}

	@Test
	public void write_shouldDegradePointDurabilityUntilDullPointWithGivenPointDurability() {
		pencil.setPointDurability(5);

		pencil.write(paper, "write");

		assertThat(pencil.getPointDurability(), is(0));
		assertThat(paper.getAppendTextCount(), is(1));
		assertThat(paper.getText(), is("write"));
	}

	@Test
	public void write_shouldDegradePointDurabiltyAndWriteWhiteSpacesWhenFullyDegraded() {
		pencil.setPointDurability(3);

		pencil.write(paper, "write");

		assertThat(pencil.getPointDurability(), is(0));
		assertThat(paper.getAppendTextCount(), is(1));
		assertThat(paper.getText(), is("wri  "));
	}
}