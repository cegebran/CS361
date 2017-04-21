import static org.junit.Assert.*;
import org.junit.Test;

public class testPower {

	Chronotimer chronotimer = new Chronotimer();
	
	@Test
	public void chronotimerOffTestButtonPush(){
		chronotimer.newRun();
		
	}
	
	@Test
	public void chronotimerTurnOnTest(){
		chronotimer.power();
	}
	
}
