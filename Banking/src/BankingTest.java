import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankingTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting BankingTest\n");
	}
	
	/**
     * Successful validation and withdrawal of $20 from account 1234
     */
	@Test
	public void withdrawTest() {
		
	}
	
	/**
     * Successful validation and withdrawal of $80 from account 1234
     */
	@Test
	public void withdrawFullAmountTest() {
		System.out.println("Starting testThrowOn11thFrame\n");
		
		System.out.println("Ending testThrowOn11thFrame\n");
	}
	
	/**
     * Incorrect validation on account 6789
     */
	@Test
	public void incorrectValidationTest() {
		System.out.println("Starting testThrowOn11thFrame\n");
		
		System.out.println("Ending testThrowOn11thFrame\n");
	}
	
	/**
     * Successful deposit of $20 to account 6789
     */
	@Test
	public void depositAccounTest() {
		System.out.println("Starting testThrowOn11thFrame\n");
		
		System.out.println("Ending testThrowOn11thFrame\n");
	}
	
	@AfterClass		
	public static void afterClass() {
		System.out.println("Ending BankingTest\n");
	}
	
}