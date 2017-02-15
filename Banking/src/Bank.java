import java.util.ArrayList;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Bank {
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	public void addAccount(int accountNumber, int pinCode){
		accounts.add(new Account(accountNumber, pinCode));
	}
	
	public void withdraw(double amount, Account account){
		
		if(account.balance < amount){
			System.out.println("Account does not have sufficient funds");
		}
		else{
			account.balance -= amount;
		}
	}
	
	public void deposit(double amount, Account account){
		account.balance += amount;
	}
	
	public Account validate(int accountNumber, int pinCode){
		java.util.Iterator<Account> it = accounts.iterator();
		while(it.hasNext()){
			Account tmp = it.next();
			if(tmp.accountNumber == accountNumber && tmp.pinCode == pinCode){
				return tmp;
			}
		}
		return null;
	}
	
	
}