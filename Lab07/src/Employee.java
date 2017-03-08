public class Employee {
	private String lname;
	private String fname;
	private int phone;
	private String department;

	public Employee(String lname, String fname, int phone, String department){
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
		this.department = department;
	}
	
	public String toString(){
		return lname + "," + fname + phone + " " + department;
	}
}