public class Employee implements Comparable<Employee> {
	private String lname;
	private String fname;
	private String phone;
	private String department;

	public Employee(String lname, String fname, String phone, String department){
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
		this.department = department;
	}
	
	public String toString(){
		return lname + "," + fname + " " + phone + " " + department;
	}

	@Override
	public int compareTo(Employee o) {
		return this.lname.compareTo(o.lname);
	}



}