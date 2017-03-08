import static org.junit.Assert.*;
import org.junit.Test;

public class testPower {

	Chronotimer chronotimer = new Chronotimer();
	Run current = new Run(chronotimer.getIndividual(), chronotimer.getParallel());
	
	@Test
	public void chronotimerOffTestButtonPush(){
		chronotimer.newRun(chronotimer.getIndividual(), chronotimer.getParallel());
		
	}
	
	@Test
	public void chronotimerTurnOnTest(){
		chronotimer.power();
	}
	
}
