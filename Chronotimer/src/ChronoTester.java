import static org.junit.Assert.*;
import org.junit.Test;

public class ChronoTester {

	@Test
	public void powerOn_Test(){
		Chronotimer c1 = new Chronotimer();
		assertEquals(false, c1.getPower());
		c1.power();
		assertEquals(true,c1.getPower());
		c1.power();
		assertEquals(false,c1.getPower());
	}
	
	@Test
	public void event_Test(){
		Chronotimer c2 = new Chronotimer();
		c2.power();
		assertEquals(true, c2.getIndividual());
		assertEquals(false, c2.getParallel());
		c2.setEvent("PARIND");
		assertEquals(false, c2.getIndividual());
		assertEquals(true, c2.getParallel());
		c2.setEvent("IND");
		assertEquals(true, c2.getIndividual());
		assertEquals(false, c2.getParallel());
	}
	
	@Test
	public void reset_InitialState_Toggle_Start_Test(){
		Chronotimer c3 = new Chronotimer();
		c3.power();
		
		// initial state on power on
		assertEquals(true, c3.getPower());
		assertEquals(true, c3.getIndividual());
		assertEquals(false, c3.getParallel());

		assertEquals(false, c3.getChannelOne().getOn());
		assertEquals(false, c3.getChannelTwo().getOn());
		assertEquals(false, c3.getChannelThree().getOn());
		assertEquals(false, c3.getChannelFour().getOn());
		assertEquals(false, c3.getChannelFive().getOn());
		assertEquals(false, c3.getChannelSix().getOn());
		assertEquals(false, c3.getChannelSeven().getOn());
		assertEquals(false, c3.getChannelEight().getOn());
		assertEquals(true, c3.getChannelOne().getStart());
		assertEquals(false, c3.getChannelTwo().getStart());
		assertEquals(true, c3.getChannelThree().getStart());
		assertEquals(false, c3.getChannelFour().getStart());
		assertEquals(true, c3.getChannelFive().getStart());
		assertEquals(false, c3.getChannelSix().getStart());
		assertEquals(true, c3.getChannelSeven().getStart());
		assertEquals(false, c3.getChannelEight().getStart());
		assertNotNull(c3.getTimer());
		assertNull(c3.getCurrentRun());
		
		// make changes to test
		c3.getChannelOne().toggle();
		c3.getChannelTwo().toggle();
		c3.getChannelThree().toggle();
		c3.getChannelFour().toggle();
		c3.getChannelFive().toggle();
		c3.getChannelSix().toggle();
		c3.getChannelSeven().toggle();
		c3.getChannelEight().toggle();
		assertEquals(true, c3.getChannelOne().getOn());
		assertEquals(true, c3.getChannelTwo().getOn());
		assertEquals(true, c3.getChannelThree().getOn());
		assertEquals(true, c3.getChannelFour().getOn());
		assertEquals(true, c3.getChannelFive().getOn());
		assertEquals(true, c3.getChannelSix().getOn());
		assertEquals(true, c3.getChannelSeven().getOn());
		assertEquals(true, c3.getChannelEight().getOn());
		
		c3.getChannelOne().state();
		c3.getChannelTwo().state();
		c3.getChannelThree().state();
		c3.getChannelFour().state();
		c3.getChannelFive().state();
		c3.getChannelSix().state();
		c3.getChannelSeven().state();
		c3.getChannelEight().state();
		assertEquals(false, c3.getChannelOne().getStart());
		assertEquals(true, c3.getChannelTwo().getStart());
		assertEquals(false, c3.getChannelThree().getStart());
		assertEquals(true, c3.getChannelFour().getStart());
		assertEquals(false, c3.getChannelFive().getStart());
		assertEquals(true, c3.getChannelSix().getStart());
		assertEquals(false, c3.getChannelSeven().getStart());
		assertEquals(true, c3.getChannelEight().getStart());
		
		c3.newRun(c3.getIndividual(), c3.getParallel());
		assertNotNull(c3.getRuns());
		
		c3.setEvent("PARIND");
		
		c3.reset();
		
		// test back to original states after the reset of the changes
		assertEquals(true, c3.getPower());
		assertEquals(true, c3.getIndividual());
		assertEquals(false, c3.getParallel());
		assertEquals(false, c3.getChannelOne().getOn());
		assertEquals(false, c3.getChannelTwo().getOn());
		assertEquals(false, c3.getChannelThree().getOn());
		assertEquals(false, c3.getChannelFour().getOn());
		assertEquals(false, c3.getChannelFive().getOn());
		assertEquals(false, c3.getChannelSix().getOn());
		assertEquals(false, c3.getChannelSeven().getOn());
		assertEquals(false, c3.getChannelEight().getOn());
		assertEquals(true, c3.getChannelOne().getStart());
		assertEquals(false, c3.getChannelTwo().getStart());
		assertEquals(true, c3.getChannelThree().getStart());
		assertEquals(false, c3.getChannelFour().getStart());
		assertEquals(true, c3.getChannelFive().getStart());
		assertEquals(false, c3.getChannelSix().getStart());
		assertEquals(true, c3.getChannelSeven().getStart());
		assertEquals(false, c3.getChannelEight().getStart());
		assertNotNull(c3.getTimer());
		assertNull(c3.getCurrentRun());
	}
	
	@Test
	public void Time_Test(){
		Chronotimer c4 = new Chronotimer();
		c4.power();
		assertNotNull(c4.getTimer());
	}
	
	@Test
	public void newRun_endRun_Test(){
		Chronotimer c5 = new Chronotimer();
		c5.power();
		assertNull(c5.getCurrentRun());
		c5.newRun(c5.getIndividual(), c5.getParallel());
		assertNotNull(c5.getCurrentRun());
		c5.endRun();
		assertNull(c5.getCurrentRun());
	}
	
	@Test
	public void toggle_Test(){
		// toggle channels from the chronotimer
		Chronotimer c6=  new Chronotimer();
		
		// test tog on channels before the chronotimer has been turned on
		c6.toggleChannel("1");
		c6.toggleChannel("2");
		c6.toggleChannel("3");
		c6.toggleChannel("4");
		c6.toggleChannel("5");
		c6.toggleChannel("6");
		c6.toggleChannel("7");
		c6.toggleChannel("8");
		assertEquals(false, c6.getChannelOne().getOn());
		assertEquals(false, c6.getChannelTwo().getOn());
		assertEquals(false, c6.getChannelThree().getOn());
		assertEquals(false, c6.getChannelFour().getOn());
		assertEquals(false, c6.getChannelFive().getOn());
		assertEquals(false, c6.getChannelSix().getOn());
		assertEquals(false, c6.getChannelSeven().getOn());
		assertEquals(false, c6.getChannelEight().getOn());
		
		c6.power();
		
		// after chronotimer has been turned on
		c6.toggleChannel("1");
		c6.toggleChannel("2");
		c6.toggleChannel("3");
		c6.toggleChannel("4");
		c6.toggleChannel("5");
		c6.toggleChannel("6");
		c6.toggleChannel("7");
		c6.toggleChannel("8");
		assertEquals(true, c6.getChannelOne().getOn());
		assertEquals(true, c6.getChannelTwo().getOn());
		assertEquals(true, c6.getChannelThree().getOn());
		assertEquals(true, c6.getChannelFour().getOn());
		assertEquals(true, c6.getChannelFive().getOn());
		assertEquals(true, c6.getChannelSix().getOn());
		assertEquals(true, c6.getChannelSeven().getOn());
		assertEquals(true, c6.getChannelEight().getOn());
	}
	
	@Test
	public void Runs_Test1(){
		Chronotimer c7 = new Chronotimer();
		c7.power();
		c7.toggleChannel("1");
		c7.toggleChannel("2");
		c7.newRun(c7.getIndividual(), c7.getParallel());
		assertEquals(true, c7.num("111"));
		
		assertEquals(true, c7.start());
		assertEquals(true, c7.finish());
	}
	
	// ConcurrentModificationException with 3 racers starting in a row and then error on the first finish command
	
	// continue additional run tests with greater complexity

}
