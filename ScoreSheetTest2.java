import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ScoreSheetTest2 {
	Scoresheet testSheet = new Scoresheet();
	
	@BeforeClass
	public static void beforeClass(){ //this was missing static keyword
		System.out.println("Starting ScoreSheetTest2\n");
	}
	
	@Test
	public void testOneThrow() {
		System.out.println("Starting testOneThrow\n");
		testSheet.throwBall(5);
		testSheet.throwBall(2);
		assertEquals(7, testSheet.getFrameScore(1));
		assertEquals(7, testSheet.getTotalScore());
		System.out.println("Ending testOneThrow\n");
	}
    
	@Test
	public void testThreeThrows() {
		System.out.println("Starting testThreeThrows\n");
		testSheet.throwBall(2);
		testSheet.throwBall(7);
		testSheet.throwBall(4);
		testSheet.throwBall(2);
		testSheet.throwBall(1);
		testSheet.throwBall(2);
		assertEquals(3, testSheet.getFrameScore(3));
		assertEquals(18,testSheet.getTotalScore());
		System.out.println("Ending testThreeThrows\n");
	}
	
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
	
	@Test
	public void testSpareOnLastFrame() {
		System.out.println("Starting testSpareOnLastFrame\n");
		for(int i = 0; i < 18; i++){
			testSheet.throwBall(2);
		}
		testSheet.throwBall(1);
		testSheet.throwBall(9);
		assertEquals(46, testSheet.getTotalScore());
		System.out.println("Ending testSpareOnLastFrame\n");
	}
	
	@Test
	public void testThrowOn11thFrame() {
		System.out.println("Starting testThrowOn11thFrame\n");
		for(int i = 0; i < 20; i++){
			testSheet.throwBall(1);
		}
		try{
			testSheet.throwBall(1);//Trying to throw on 11th frame
		}catch(Exception e){
			assertTrue(e instanceof RuntimeException);
		}
		System.out.println("Ending testThrowOn11thFrame\n");
	}
	
	//TODO Implement Handlers for various exceptions
	
	@AfterClass		
	public static void afterClass(){		//this was missing static keyword
		System.out.println("Ending ScoreSheetTest2\n");
	}
}
