import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoreSheetTest2 {
	Scoresheet testSheet = new Scoresheet();
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting ScoreSheetTest2\n");
	}
	
	/**
     * Tests one throw (the equivalent of a single frame assuming a strike has not been thrown).
     */
	@Test
	public void testOneThrow() {
		System.out.println("Starting testOneThrow\n");
		testSheet.throwBall(5);
		assertEquals(5, testSheet.getFrameScore(1));
		assertEquals(5, testSheet.getTotalScore());
		System.out.println("Ending testOneThrow\n");
	}
    
	/**
     * Tests three throws (the equivalent of a single frame and the first throw of the next frame,
     * assuming there are no strikes or spares).
     */
	@Test
	public void testThreeThrows() {
		System.out.println("Starting testThreeThrows\n");
		testSheet.throwBall(2);
		testSheet.throwBall(7);
		testSheet.throwBall(4);
		assertEquals(9, testSheet.getFrameScore(1));
		assertEquals(4, testSheet.getFrameScore(2));
		assertEquals(13,testSheet.getTotalScore());
		System.out.println("Ending testThreeThrows\n");
	}
	
	/**
     * Tests that the frame moves after a strike has been thrown so that there is no second
     * throw paired with a perfect 10-pin knockdown.
     */
	@Test
	public void testStrikeMovesToNextFrame() {
		System.out.println("Starting testStrikeMovesToNextFrame\n");
		testSheet.throwBall(10);
		assertEquals(10, testSheet.getTotalScore());
		testSheet.throwBall(3);
		testSheet.throwBall(4);
		assertEquals(24, testSheet.getTotalScore());
		assertEquals(3, testSheet.getCurrentFrame());
		System.out.println("Ending testStrikeMovesToNextFrame\n");
	}
	
	/**
     * Tests to ensure that a spare thrown on the final frame still allows and scores one final
     * throw (per final frame bowling rules).
     */
	@Test
	public void testSpareOnLastFrame() {
		System.out.println("Starting testSpareOnLastFrame\n");
		for (int i = 0; i < 18; i++) {
			testSheet.throwBall(2);
		}
		testSheet.throwBall(1);
		testSheet.throwBall(9);
		assertEquals(46, testSheet.getTotalScore());
		System.out.println("Ending testSpareOnLastFrame\n");
	}
	
	/**
     * Tests to make sure an exception is thrown if an eleventh frame is added to the total.
     */
	@Test
	public void testThrowOn11thFrame() {
		System.out.println("Starting testThrowOn11thFrame\n");
		for (int i = 0; i < 20; i++) {
			testSheet.throwBall(1);
		}
		try {
			//Trying to throw on 11th frame
			testSheet.throwBall(1);
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
		}
		System.out.println("Ending testThrowOn11thFrame\n");
	}
	
	//TODO Implement Handlers for various exceptions
	
	@AfterClass		
	public static void afterClass() {
		System.out.println("Ending ScoreSheetTest2\n");
	}
}
