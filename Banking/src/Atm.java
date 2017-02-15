import java.util.Scanner;
public class Atm {
	
	private Bank bankField;
	
	public Atm(Bank bankField){
		this.bankField = bankField;
	}
	

	public void start(){
		Scanner in = new Scanner(System.in);
		
		boolean w_d = false; // false for deposit
		System.out.println("Insert Card / Enter the account number");
		int accountNumber = in.nextInt();
		
		System.out.println("Enter the account PIN number");
		int pinNumber = in.nextInt();
		
		Account acctTemp = bankField.validate(accountNumber, pinNumber);
		double prevBal = acctTemp.balance;
		
		if(acctTemp == null){
			System.out.println("The account Number and the Pin do not match an account");
		}else{
		
			System.out.println("Withdrawl (W) or deposit (D)");
			String c_d = in.next();
		
			if(c_d.equals("W")){
				w_d = true;
			}	
		
			System.out.println("Enter the amount");
			double amount = in.nextDouble();
			
			if(w_d == true){	// withdrawl
				bankField.withdraw(amount, acctTemp);
			}else{	// deposit
				bankField.deposit(amount, acctTemp);
			}
			
			// print the receipt
			System.out.println("Account Number: " + accountNumber);
			System.out.println("Checking Account");
			System.out.println("--------------------------");
			System.out.println("Previous Balance: $" + prevBal);
			if(w_d == true){
				System.out.println("Withdrawl Amount: $" + amount);
			}else{
				System.out.println("Deposit Amount: $" + amount);
			}
			
			System.out.println("New Account Balance : $" + acctTemp.balance);
		}
		in.close();
	}
	
}