package com.pillartechnology.mqualls;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PencilTest {

	private static final int DEFAULT_POINT_DURABILITY = 40000;
	private static final int DEFAULT_LENGTH_VALUE = 100;
	private static final int DEFAULT_ERASER_DURABILITY = 100;

	private MockPaper paper;

	private Pencil pencil;

	@Before
	public void setUp() {
		paper = new MockPaper();
		pencil = new Pencil(DEFAULT_POINT_DURABILITY, DEFAULT_LENGTH_VALUE, DEFAULT_ERASER_DURABILITY);
	}

	@Test
	public void constructWithDefaultValues() {
		assertThat(pencil.getPointDurability(), is(DEFAULT_POINT_DURABILITY));
		assertThat(pencil.getLengthValue(), is(DEFAULT_LENGTH_VALUE));
		assertThat(pencil.getEraserDurability(), is(DEFAULT_ERASER_DURABILITY));
	}

	@Test
	public void write_shouldWriteTextOnPaper() {
		pencil.write("She sells sea shells", paper);

		assertThat( paper.getAppendTextCount(), is(1));
		assertThat( paper.getText(), is("She sells sea shells"));
	}

	@Test
	public void write_shouldWriteMoreTextOnThePaper() {
		pencil.write("She sells sea shells", paper);
		pencil.write(" down by the sea shore", paper);

		assertThat( paper.getAppendTextCount(), is(2));
		assertThat( paper.getText(), is("She sells sea shells down by the sea shore"));
	}

	@Test
	public void write_shouldDegradePointDurabilityAndWriteWhiteSpacesWhenFullyDegraded() {
		pencil.setPointDurability(3);

		pencil.write("write", paper);

		assertThat(pencil.getPointDurability(), is(0));
		assertThat(paper.getText(), is("wri  "));
	}

	@Test
	public void write_shouldNotDegradePointDurabilityWhenGivenEitherWhiteSpaceOrNewLine() {
		pencil.write("text \nhere", paper);

		assertThat(pencil.getPointDurability(), is(DEFAULT_POINT_DURABILITY - 8));
	}

	@Test
	public void write_shouldDegradeTwiceAsMuchForCapitalLetters() {
		pencil.setPointDurability(4);

		pencil.write("Text", paper);

		assertThat(pencil.getPointDurability(), is(0));
		assertThat(paper.getText(), is("Tex "));
	}

	@Test
	public void sharpen_shouldResetThePointDurabilityToDefaultValue() {
		pencil.setPointDurability(0);

		pencil.sharpen();

		assertThat(pencil.getPointDurability(), is(DEFAULT_POINT_DURABILITY));
	}

	@Test
	public void sharpen_shouldReducePencilLengthValue() {
		pencil.sharpen();

		assertThat(pencil.getLengthValue(), is(DEFAULT_LENGTH_VALUE - 1));
	}

	@Test
	public void sharpen_shouldNotResetPointDurabilityIfPencilIsTooShort() {
		pencil.setLengthValue(0);
		pencil.setPointDurability(0);

		pencil.sharpen();

		assertThat(pencil.getLengthValue(), is(0));
		assertThat(pencil.getPointDurability(), is(0));
	}

	@Test
	public void erase_shouldEraseWordFromPaper() {
		pencil.write("How much wood would a woodchuck chuck if a woodchuck could chuck wood?", paper);

		pencil.erase("chuck", paper);

		assertThat(paper.getText(), is("How much wood would a woodchuck chuck if a woodchuck could       wood?"));
		assertThat(paper.getFindLastOccurrenceCOunt(), is(1));
		assertThat(paper.getEraseCharacterAtCount(), is(5));
	}

	@Test
	public void erase_shouldEraseWordFromPaperAfterFirstErase() {
		pencil.write("How much wood would a woodchuck chuck if a woodchuck could chuck wood?", paper);

		pencil.erase("chuck", paper);
		pencil.erase("chuck", paper);

		assertThat(paper.getText(), is("How much wood would a woodchuck chuck if a wood      could       wood?"));
		assertThat(paper.getFindLastOccurrenceCOunt(), is(2));
		assertThat(paper.getEraseCharacterAtCount(), is(10));
	}
}