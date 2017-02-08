package scoresheet;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoreSheetTest1 {

	Scoresheet testSheet = new Scoresheet();
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Starting ScoreSheetTest\n");
	}
	
	/**
     * Tests two throws (the equivalent of a single frame assuming a strike has not been thrown).
     */
	@Test
	public void testTwoThrows() {
		System.out.println("Starting testTwoThrows\n");
		testSheet.throwBall(5);
		assertEquals(1, testSheet.getCurrentFrame());
		testSheet.throwBall(2);
		assertEquals(7, testSheet.getFrameScore(1));
		assertEquals(7, testSheet.getTotalScore());
		assertEquals(2, testSheet.getCurrentFrame());
		System.out.println("Ending testTwoThrows\n");
	}
	
	/**
     * Tests to ensure the following frame is counted in addition to the frame in which a spare
     * is thrown (Spare Frame Score + Following Frame Score) - this assumes it does not fall in
     * the final frame and the next throw is not a strike or spare.
     */
	@Test
	public void testSpareCountsNextFrameScore() {
		System.out.println("Starting testSpareCountsNextFrameScore\n");
		// throw a spare
		testSheet.throwBall(9);
		testSheet.throwBall(1);
		assertEquals(10, testSheet.getTotalScore());
		// throw a non-strike/non-spare
		testSheet.throwBall(7);
		assertEquals(24, testSheet.getTotalScore());
		assertEquals(2, testSheet.getCurrentFrame());
		System.out.println("Ending testSpareCountsNextFrameScore\n");
	}
	
	/**
     * Tests to ensure the following two frames are counted in addition to the frame in which a
     * strike is thrown (Strike Frame Score + Next Frame Score + Next Next Frame Score) - this
     * assumes it does not fall in the 9th or later frame and only one strike is thrown.
     */
	@Test
	public void testStrikeCountsNextFrameScores() {
		System.out.println("Starting testStrikeCountsNextFrameScores\n");
		// first frame (strike)
		testSheet.throwBall(10);
		// second frame
		testSheet.throwBall(6);
		testSheet.throwBall(2);
		// third frame
		testSheet.throwBall(0);
		testSheet.throwBall(9);
		assertEquals(44, testSheet.getTotalScore());
		System.out.println("Ending testStrikeCountsNextFrameScores\n");
	}
	
	/**
     * Tests to ensure that, on the tenth frame, the two additional throws are calculated (even
     * if they are themselves strikes).
     */
	@Test
	public void testStrikeOnLastFrames() {
		System.out.println("Starting testStrikeOnLastFrames\n");
		// first frame
		testSheet.throwBall(3);
		testSheet.throwBall(6);
		// second frame
		testSheet.throwBall(2);
		testSheet.throwBall(8);
		// third frame
		testSheet.throwBall(9);
		testSheet.throwBall(0);
		// fourth frame
		testSheet.throwBall(6);
		testSheet.throwBall(1);
		// fifth frame
		testSheet.throwBall(8);
		testSheet.throwBall(1);
		// sixth frame
		testSheet.throwBall(5);
		testSheet.throwBall(4);
		// seventh frame
		testSheet.throwBall(2);
		testSheet.throwBall(1);
		// eighth frame (strike + 2 last throws)
		testSheet.throwBall(10);
		// ninth frame (strike + 1 more throw)
		testSheet.throwBall(10);
		// last frame (strike, only 10 pts)
		testSheet.throwBall(10);
		assertEquals(115, testSheet.getTotalScore());
		assertEquals(11, testSheet.getCurrentFrame());
		System.out.println("Ending testStrikeOnLastFrames\n");
	}
	
	@AfterClass		
	public static void afterClass() {
		System.out.println("Ending ScoreSheetTest\n");
	}
}
