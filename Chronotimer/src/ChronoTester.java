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
		assertEquals(true, c2.getIndividual());
		assertEquals(true, c2.getParallel());
		c2.setEvent("IND");
		assertEquals(true, c2.getIndividual());
		assertEquals(false, c2.getParallel());
		c2.setEvent("GRP");
		assertEquals(false, c2.getIndividual());
		assertEquals(false, c2.getParallel());
		c2.setEvent("PARGRP");
		assertEquals(false, c2.getIndividual());
		assertEquals(true, c2.getParallel());
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
		
		assertEquals(1, c3.newRun());
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
		assertEquals(1, c5.newRun());
		assertNotNull(c5.getCurrentRun());
		assertTrue(c5.endRun(false));
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
		assertEquals(1, c7.newRun());
		assertEquals(1, c7.num("111"));
		
		assertEquals(true, c7.start());
		assertEquals(true, c7.finish());
	}
	
	@Test
	public void DNF_Test(){
		Chronotimer c8 = new Chronotimer();
		c8.power();
		c8.toggleChannel("1");
		c8.toggleChannel("2");
		assertEquals(1, c8.newRun());
		c8.num("111");
		assertEquals(true, c8.start());
		assertEquals(111, c8.dnf());
		assertTrue(c8.endRun(false));
		c8.power();
	}
	
	@Test
	public void DNF_2_Racers_Start_Finish_Test(){
		Chronotimer c9 = new Chronotimer();
		c9.power();
		c9.toggleChannel("1");
		c9.toggleChannel("2");
		assertEquals(1, c9.newRun());
		c9.num("11");
		c9.num("22");
		assertEquals(true, c9.start());
		assertEquals(true, c9.start());
		assertEquals(11, c9.dnf());
		assertEquals(22, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("33");
		c9.num("44");
		assertEquals(true, c9.start());
		assertEquals(33, c9.dnf());
		assertEquals(true, c9.start());
		assertEquals(44, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("55");
		c9.num("66");
		assertEquals(true, c9.start());
		assertEquals(true, c9.finish());
		assertEquals(true, c9.start());
		assertEquals(66, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("77");
		c9.num("88");
		assertEquals(true, c9.start());
		assertEquals(true, c9.finish());
		assertEquals(true, c9.start());
		assertEquals(88, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("99");
		c9.num("11");//changed from "00"
		assertEquals(true, c9.start());
		assertEquals(99, c9.dnf());
		assertEquals(true, c9.start());
		assertEquals(true, c9.finish());
		assertTrue(c9.endRun(false));
	}
	
	@Test
	public void DNF_2_Racers_Trig_Test(){
		Chronotimer c9 = new Chronotimer();
		c9.power();
		c9.toggleChannel("1");
		c9.toggleChannel("2");
		assertEquals(1, c9.newRun());
		c9.num("11");
		c9.num("22");
		assertEquals(11, c9.trigger("1"));
		assertEquals(22, c9.trigger("1"));
		assertEquals(11, c9.dnf());
		assertEquals(22, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("33");
		c9.num("44");
		assertEquals(33, c9.trigger("1"));
		assertEquals(33, c9.dnf());
		assertEquals(44, c9.trigger("1"));
		assertEquals(44, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("55");
		c9.num("66");
		assertEquals(55, c9.trigger("1"));
		assertEquals(55, c9.trigger("2"));
		assertEquals(66, c9.trigger("1"));
		assertEquals(66, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("77");
		c9.num("88");
		assertEquals(77, c9.trigger("1"));
		assertEquals(77, c9.trigger("2"));
		assertEquals(88, c9.trigger("1"));
		assertEquals(88, c9.dnf());
		assertTrue(c9.endRun(false));
		
		assertEquals(1, c9.newRun());
		c9.num("99");
		c9.num("00");
		assertEquals(99, c9.trigger("1"));
		assertEquals(99, c9.dnf());
		assertEquals(00, c9.trigger("1"));
		assertEquals(00, c9.trigger("2"));
		assertTrue(c9.endRun(false));
	}
	
	@Test
	public void DNF_3_InRow_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(3, c0.getCurrentRun().getEndQueue().size());
		assertEquals(12, c0.dnf());
		assertEquals(13, c0.dnf());
		assertEquals(14, c0.dnf());
	}
	
	
	@Test
	public void Finish_3_InRow_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(3, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.finish());
		assertEquals(true, c0.finish());
		assertEquals(true, c0.finish());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
	}
	
	@Test
	public void Start_Finish_2_Start_Finish_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(2, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.finish());
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.finish());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.start());
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.finish());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
	}
	
	@Test
	public void Start_Finish_1_Start_DNF_2_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(true, c0.start());
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.finish());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.start());
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(true, c0.start());
		assertEquals(2, c0.getCurrentRun().getEndQueue().size());
		assertEquals(13, c0.dnf());
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(14, c0.dnf());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
	}
	
	@Test
	public void trig1_trig2_2_trig1_trig2_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(12, c0.trigger("1"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(13, c0.trigger("1"));
		assertEquals(2, c0.getCurrentRun().getEndQueue().size());
		assertEquals(12, c0.trigger("2"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(13, c0.trigger("2"));
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
		assertEquals(14, c0.trigger("1"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(14, c0.trigger("2"));
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
	}
	
	@Test
	public void trig1_trig2_2_trig1_dnf_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("12");
		c0.num("13");
		c0.num("14");
		assertEquals(12, c0.trigger("1"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(13, c0.trigger("1"));
		assertEquals(2, c0.getCurrentRun().getEndQueue().size());
		assertEquals(12, c0.trigger("2"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(13, c0.trigger("2"));
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
		assertEquals(14, c0.trigger("1"));
		assertEquals(1, c0.getCurrentRun().getEndQueue().size());
		assertEquals(14, c0.dnf());
		assertEquals(0, c0.getCurrentRun().getEndQueue().size());
	}
	
	@Test
	public void add_same_num_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertEquals(1, c0.newRun());
		assertEquals(1, c0.num("12"));
		assertEquals(-3, c0.num("12"));
	}
	
	@Test
	public void functions_with_power_off_Test(){
		// all functionalities 
		Chronotimer c0 = new Chronotimer();
		assertEquals(false, c0.setEvent("IND"));
		assertEquals(-1, c0.dnf());
		assertEquals(false, c0.toggleChannel("1"));
		assertEquals(0, c0.trigger("1"));
		assertEquals(false, c0.start());
		assertEquals(false, c0.finish());
	}
	
	@Test
	public void parallel_two_racers_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("PARIND");
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		c0.toggleChannel("3");
		c0.toggleChannel("4");
		assertEquals(2, c0.newRun());	// set to parallel
		c0.num("111");
		c0.num("222");
		assertEquals(111, c0.trigger("1"));
		assertEquals(222, c0.trigger("3"));
		assertEquals(111, c0.trigger("2"));
		assertEquals(222, c0.trigger("4"));
	}
	
	@Test
	public void parallel_faulty_trigger_operations_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("PARIND");
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		c0.toggleChannel("3");
		c0.toggleChannel("4");
		assertEquals(2, c0.newRun());	// set to parallel
		c0.num("111");
		c0.num("222");
		c0.num("333");
		assertEquals(0, c0.trigger("4"));
		assertEquals(111, c0.trigger("1"));
		assertEquals(222, c0.trigger("3"));
		assertEquals(333, c0.trigger("3"));
		assertEquals(0, c0.trigger("3"));
		assertEquals(222, c0.trigger("4"));
		assertEquals(333, c0.trigger("4"));
		assertEquals(0, c0.trigger("4"));
		assertEquals(111, c0.trigger("2"));
		assertEquals(0, c0.trigger("2"));
		assertEquals(0, c0.trigger("4"));
		assertEquals(0, c0.trigger("1"));
		assertEquals(0, c0.trigger("3"));
	}
	
	@Test
	public void parallel_faulty_trigger_high_channel_numbers_operations_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("PARIND");
		c0.toggleChannel("5");
		c0.toggleChannel("6");
		c0.toggleChannel("7");
		c0.toggleChannel("8");
		assertEquals(2, c0.newRun());	// set to parallel
		c0.num("111");
		c0.num("222");
		c0.num("333");
		assertEquals(0, c0.trigger("8"));
		assertEquals(111, c0.trigger("5"));
		assertEquals(222, c0.trigger("7"));
		assertEquals(333, c0.trigger("7"));
		assertEquals(0, c0.trigger("7"));
		assertEquals(222, c0.trigger("8"));
		assertEquals(333, c0.trigger("8"));
		assertEquals(0, c0.trigger("8"));
		assertEquals(111, c0.trigger("6"));
		assertEquals(0, c0.trigger("6"));
		assertEquals(0, c0.trigger("8"));
		assertEquals(0, c0.trigger("5"));
		assertEquals(0, c0.trigger("7"));
	}
	
	@Test
	public void parallel_faulty_trigger_middle_channel_numbers_operations_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("PARIND");
		c0.toggleChannel("3");
		c0.toggleChannel("4");
		c0.toggleChannel("5");
		c0.toggleChannel("6");
		assertEquals(2, c0.newRun());	// set to parallel
		c0.num("111");
		c0.num("222");
		c0.num("333");
		assertEquals(0, c0.trigger("6"));
		assertEquals(111, c0.trigger("3"));
		assertEquals(222, c0.trigger("5"));
		assertEquals(333, c0.trigger("5"));
		assertEquals(0, c0.trigger("5"));
		assertEquals(222, c0.trigger("6"));
		assertEquals(333, c0.trigger("6"));
		assertEquals(0, c0.trigger("6"));
		assertEquals(111, c0.trigger("4"));
		assertEquals(0, c0.trigger("4"));
		assertEquals(0, c0.trigger("6"));
		assertEquals(0, c0.trigger("3"));
		assertEquals(0, c0.trigger("5"));
	}
	
	@Test
	public void dnf_on_empty_run_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("111");
		assertEquals(0, c0.dnf());
	}
	
	@Test
	public void parallel_run_dnf_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("PARIND");
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		c0.toggleChannel("3");
		c0.toggleChannel("4");
		assertEquals(2, c0.newRun());	// set to parallel
		c0.num("111");
		c0.num("222");
		c0.num("333");
		assertEquals(0, c0.dnf());
		assertEquals(111, c0.trigger("1"));
		assertEquals(222, c0.trigger("3"));
		assertEquals(111, c0.dnf());
		assertEquals(333, c0.trigger("1"));
		assertEquals(222, c0.trigger("4"));
		assertEquals(333, c0.trigger("2"));
	}
	
	@Test
	public void run_Number_Test(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		c0.setEvent("IND");
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(1, c0.newRun());
		c0.num("111");
		assertEquals(1,c0.getRuns().get(0).getRunNumber());
		c0.start();
		c0.finish();
		assertTrue(c0.endRun(false));
		assertEquals(1, c0.newRun());
		assertEquals(1,c0.num("222"));
		assertEquals(2,c0.getRuns().get(1).getRunNumber());
		c0.start();
		c0.finish();
		assertTrue(c0.endRun(false));
	}
	
	@Test
	public void failing_newRun(){
		Chronotimer c0 = new Chronotimer();
		assertEquals(0, c0.newRun());	// power not on
		c0.power();
		assertEquals(1, c0.newRun());
		assertEquals(0, c0.newRun());	// new run already in progress so cannot create another at the same time
	}
	
	@Test
	public void failing_endRun(){
		Chronotimer c0 = new Chronotimer();
		assertEquals(false, c0.endRun(false));	// power not on
		c0.power();
		assertEquals(false, c0.endRun(false));	// new run already in progress so cannot create another at the same time
	}
	
	@Test
	public void failing_passing_export(){
		Chronotimer c0 = new Chronotimer();
		assertEquals(false, c0.export("results.txt"));	// power not on
		c0.power();
		assertEquals(true, c0.export("results.txt"));	// new run already in progress so cannot create another at the same time
	}
	
	@Test
	public void test_cancel_outputs(){
		Chronotimer c0 = new Chronotimer();
		assertEquals(-2, c0.cancel());	// power not on
		c0.power();
		assertEquals(0, c0.cancel());	// no current run to cancel
		assertEquals(1, c0.newRun());
		assertEquals(-1, c0.cancel());	// no racer currently making their run to cancel
		assertEquals(1,c0.num("123"));
		c0.toggleChannel("1");
		c0.start();
		assertEquals(123, c0.cancel());	// racer bib number returned when currently making a run
	}
	
	// Newly added Group Functionality Tests
	@Test
	public void test_Group(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.setEvent("GRP"));
		assertEquals(3,c0.newRun());
		assertEquals(0, c0.num("111"));
		assertEquals(0, c0.num("222"));
		assertEquals(0, c0.num("333"));
		assertFalse(c0.start());
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertTrue(c0.start());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
	}
	
	@Test
	public void test_Group2(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.setEvent("GRP"));
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(3,c0.newRun());
		assertTrue(c0.start());
		assertFalse(c0.start());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertFalse(c0.start());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertEquals(1, c0.num("111"));
		assertEquals(1, c0.num("222"));
		assertEquals(1, c0.num("333"));
		assertEquals(1, c0.num("444"));
		assertEquals(1, c0.num("555"));
		assertEquals(1, c0.num("888"));
		assertEquals(1, c0.num("122"));
		assertEquals(0, c0.num("144"));	// no more finished racers to add a bib # to
		assertTrue(c0.endRun(false));
		assertFalse(c0.start());
		assertFalse(c0.finish());
		assertTrue(c0.setEvent("IND"));
		assertTrue(c0.setEvent("PARIND"));
		assertTrue(c0.setEvent("GRP"));
		c0.power();
	}
	
	@Test
	public void test_Group3(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.setEvent("GRP"));
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(3,c0.newRun());
		assertTrue(c0.start());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertEquals(1, c0.num("111"));
		assertEquals(1, c0.num("222"));
		assertEquals(-3, c0.num("111"));	// 111 already a bib number in the run
		assertEquals(1, c0.num("555"));
		assertTrue(c0.endRun(false));
		assertFalse(c0.start());
		assertFalse(c0.finish());
		assertTrue(c0.setEvent("IND"));
		assertTrue(c0.setEvent("PARIND"));
		assertTrue(c0.setEvent("GRP"));
		c0.power();
	}
	
	@Test
	public void test_Group4(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.setEvent("GRP"));
		c0.toggleChannel("1");
		c0.toggleChannel("2");
		assertEquals(3,c0.newRun());
		assertTrue(c0.start());
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertEquals(1, c0.num("111"));
		assertEquals(1, c0.num("222"));
		assertTrue(c0.finish());
		assertEquals(1, c0.num("333"));
		assertTrue(c0.finish());
		assertTrue(c0.finish());
		assertEquals(1, c0.num("555"));
		assertTrue(c0.finish());
		assertEquals(1, c0.num("888"));
		assertEquals(1, c0.num("122"));
		assertEquals(0, c0.num("888"));
		assertTrue(c0.finish());
		assertEquals(1, c0.num("144"));
		assertTrue(c0.endRun(false));
		assertFalse(c0.start());
		assertFalse(c0.finish());
		assertTrue(c0.setEvent("IND"));
		assertTrue(c0.setEvent("PARIND"));
		assertTrue(c0.setEvent("GRP"));
		c0.power();
	}
	
	@Test
	public void test_Reset_after_Event(){
		Chronotimer c = new Chronotimer();
		c.power();
		c.setEvent("PARGRP");
		c.reset();
		assertTrue(c.getIndividual());
		assertFalse(c.getParallel());
	}
	
	@Test
	public void test_Reset(){
		Chronotimer c = new Chronotimer();
		c.power();
		assertTrue(c.toggleChannel("1"));
		assertTrue(c.toggleChannel("2"));
		assertTrue(c.toggleChannel("3"));
		assertTrue(c.toggleChannel("4"));
		assertTrue(c.toggleChannel("5"));
		assertTrue(c.toggleChannel("6"));
		assertTrue(c.toggleChannel("7"));
		assertTrue(c.toggleChannel("8"));
		assertNull(c.getCurrentRun());
		c.newRun();
		assertNotNull(c.getCurrentRun());
		c.reset();
		assertFalse(c.getChannelOne().getOn());
		assertFalse(c.getChannelTwo().getOn());
		assertFalse(c.getChannelThree().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertNull(c.getCurrentRun());
	}
	
	@Test
	public void reset_Reset(){
		Chronotimer c = new Chronotimer();
		assertTrue(c.power());
		assertTrue(c.reset());
		assertTrue(c.reset());
		assertFalse(c.getChannelOne().getOn());
		assertFalse(c.getChannelTwo().getOn());
		assertFalse(c.getChannelThree().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertNull(c.getCurrentRun());
	}
	
	@Test
	public void reset_After_Race(){
		Chronotimer c = new Chronotimer();
		c.power();
		assertTrue(c.toggleChannel("1"));
		assertTrue(c.toggleChannel("2"));
		assertTrue(c.toggleChannel("3"));
		assertTrue(c.toggleChannel("4"));
		assertTrue(c.toggleChannel("5"));
		assertTrue(c.toggleChannel("6"));
		assertTrue(c.toggleChannel("7"));
		assertTrue(c.toggleChannel("8"));
		assertNull(c.getCurrentRun());
		c.newRun();
		c.num("1");
		c.num("2");
		assertEquals(1, c.trigger("1"));
		assertEquals(2, c.trigger("1"));
		assertEquals(1, c.trigger("2"));
		assertEquals(2, c.trigger("2"));
		c.endRun(false);
		c.reset();
		assertFalse(c.getChannelOne().getOn());
		assertFalse(c.getChannelTwo().getOn());
		assertFalse(c.getChannelThree().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertNull(c.getCurrentRun());
	}
	
	@Test
	public void test_Reset_Time(){
		Chronotimer c = new Chronotimer();
		c.power();
		assertTrue(c.setTime("2:30:02"));
		assertEquals("02:30:02.00" , Time.convertRealTime(c.getTimer().getCurrentTime()));
		assertTrue(c.reset());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("12:00:01.00" , Time.convertRealTime(c.getTimer().getCurrentTime()));
	}
	
	@Test
	public void test_Reset_On(){
		Chronotimer c = new Chronotimer();
		assertTrue(c.power());
		c.reset();
		assertFalse(c.getChannelOne().getOn());
		assertFalse(c.getChannelTwo().getOn());
		assertFalse(c.getChannelThree().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertNull(c.getCurrentRun());
	}
	
	@Test
	public void reset_During_Race(){
		Chronotimer c = new Chronotimer();
		assertTrue(c.power());
		assertTrue(c.setEvent("GRP"));
		assertEquals(3, c.newRun());
		assertTrue(c.toggleChannel("1"));
		assertTrue(c.toggleChannel("2"));
		assertEquals(11111, c.trigger("1"));
		assertTrue(c.reset());
		assertFalse(c.getChannelOne().getOn());
		assertFalse(c.getChannelTwo().getOn());
		assertFalse(c.getChannelThree().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertFalse(c.getChannelFour().getOn());
		assertNull(c.getCurrentRun());
	}
	
	@Test
	public void test_Reset_Off(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.reset());
	}
	
	@Test
	public void test_Swap(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.toggleChannel("1"));
		assertTrue(c0.toggleChannel("2"));
		assertTrue(c0.setEvent("IND"));
		assertEquals(1, c0.newRun());
		c0.num("111");
		c0.num("222");
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertTrue(c0.swap());
		assertEquals(222, c0.trigger("2"));
		assertEquals(111, c0.trigger("2"));
		assertTrue(c0.endRun(false));
		c0.power();
	}
	
	@Test
	public void test_Swap2(){
		Chronotimer c0 = new Chronotimer();
		c0.power();
		assertTrue(c0.toggleChannel("1"));
		assertTrue(c0.toggleChannel("2"));
		assertTrue(c0.setEvent("IND"));
		assertEquals(1, c0.newRun());
		c0.num("111");
		c0.num("222");
		c0.num("333");
		c0.num("444");
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertEquals(true, c0.start());
		assertTrue(c0.swap());
		assertEquals(222, c0.trigger("2"));
		assertTrue(c0.swap());
		assertEquals(333, c0.trigger("2"));
		assertTrue(c0.swap());
		assertEquals(444, c0.trigger("2"));
		assertFalse(c0.swap());
		assertEquals(111, c0.trigger("2"));
	}
	
	@Test
	public void test_Cancel_GRP(){
		Chronotimer c1 = new Chronotimer();
		c1.power();
		c1.setEvent("GRP");
		c1.newRun();
		assertTrue(c1.toggleChannel("1"));
		assertTrue(c1.toggleChannel("2"));
		assertEquals(11111, c1.trigger("1"));
		assertEquals(-3, c1.cancel());
	}
	
	@Test
	public void test_Cancel_IND(){
		Chronotimer c2 = new Chronotimer();
		c2.power();
		c2.newRun();
		assertTrue(c2.toggleChannel("1"));
		assertTrue(c2.toggleChannel("2"));
		assertEquals(1, c2.num("1"));
		assertEquals(1, c2.num("2"));
		assertEquals(-1, c2.cancel());
		assertEquals(1, c2.trigger("1"));
		assertEquals(2, c2.trigger("1"));
		assertEquals(2, c2.cancel());
		assertEquals(2, c2.trigger("1"));
		assertEquals(1, c2.trigger("2"));
		assertEquals(2, c2.trigger("2"));
	}
	
	@Test
	public void endRun_Power_Off(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.endRun(false));
	}
	
	@Test
	public void endRun_Turned_On(){
		Chronotimer c = new Chronotimer();
		assertTrue(c.power());
		assertFalse(c.endRun(false));
	}
	
	@Test
	public void endRun_All_Events(){
		Chronotimer c = new Chronotimer();
		assertTrue(c.power());
		c.newRun();
		c.endRun(false);
		assertEquals(1, c.getRuns().size());
		c.setEvent("PARIND");
		c.newRun();
		c.endRun(false);
		assertEquals(2, c.getRuns().size());
		c.setEvent("GRP");
		c.newRun();
		c.endRun(false);
		assertEquals(3, c.getRuns().size());
		c.setEvent("PARGRP");
		c.newRun();
		c.endRun(false);
		assertEquals(4, c.getRuns().size());
	}
	
	@Test
	public void endRun_Twice(){
		Chronotimer c = new Chronotimer();
		c.power();
		c.newRun();
		assertTrue(c.endRun(false));
		assertFalse(c.endRun(false));
	}
	
	// Test Plans 7, 8, 9
	// Brandon Cegelski
	// Test Plan 7
	@Test
	public void power_on_from_off_test(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.getPower());
		assertTrue(c.power());
		assertTrue(c.getPower());
	}
	
	@Test
	public void power_on_from_on_test(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.getPower());
		assertTrue(c.power());
		assertTrue(c.getPower());
		assertFalse(c.power());
		assertFalse(c.getPower());
	}
	
	@Test
	public void power_off_from_on_test(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.getPower());
		assertTrue(c.power());
		assertTrue(c.getPower());
		assertFalse(c.power());
		assertFalse(c.getPower());
	}
	
	@Test
	public void power_off_from_off_test(){
		Chronotimer c = new Chronotimer();
		assertFalse(c.getPower());
		assertTrue(c.power());
		assertTrue(c.getPower());
		assertFalse(c.power());
		assertFalse(c.getPower());
	}
	
	// Test Plan 8
	
}
