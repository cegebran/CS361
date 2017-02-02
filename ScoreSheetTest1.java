import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreSheetTest1 {

	Scoresheet a = new Scoresheet();
	
	@Test
	public void testTwoThrows() {
		a.throwBall(5);
		a.throwBall(2);
		assertEquals(7, a.getTotalScore());
		assertEquals(2, a.getCurrentFrame());
	}
	
	@Test
	public void testSpareCountsNextFrameScore() {
		a.throwBall(9);
		a.throwBall(1);
		a.throwBall(7);
		assertEquals(24, a.getTotalScore());
		assertEquals(2, a.getCurrentFrame());
	}
	
	@Test
	public void testStrikeCountsNextFrameScores() {
		a.throwBall(10);
		a.throwBall(6);
		a.throwBall(2);
		a.throwBall(0);
		a.throwBall(9);
		assertEquals(44, a.getTotalScore());
	}
	
	@Test
	public void testStrikeOnLastFrames() {
		// first frame
		a.throwBall(3);
		a.throwBall(6);
		// second frame
		a.throwBall(2);
		a.throwBall(8);
		// third frame
		a.throwBall(9);
		a.throwBall(0);
		// fourth frame
		a.throwBall(6);
		a.throwBall(1);
		// fifth frame
		a.throwBall(8);
		a.throwBall(1);
		// sixth frame
		a.throwBall(5);
		a.throwBall(4);
		// seventh frame
		a.throwBall(2);
		a.throwBall(1);
		// eighth frame
		a.throwBall(10);
		// ninth frame
		a.throwBall(10);
		// last frame
		a.throwBall(10);
		assertEquals(115, a.getTotalScore());
		assertEquals(11, a.getCurrentFrame());
	}

}
