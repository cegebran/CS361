
public class Account {
	int accountNumber;
	int pinCode;
	double balance;
	
	public Account(int accountNumber, int pinCode){
		this.accountNumber = accountNumber;
		this.pinCode = pinCode;
		this.balance = 0;
	}

	public boolean validate(int pinInput){
		boolean bResult = false;
		if(this.pinCode == pinInput){
			bResult = true;
		}
	    return bResult;
	}
}
