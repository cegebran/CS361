package com.example;

public class Employee implements Comparable<Object>{
	
	private String firstName;
	private String lastName;
	private String department;
	private String phoneNumber;
	private String title;
	private String gender;
	
	public Employee(String firstName, String lastName, String department, String phoneNum, String titleName, String genderType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNumber = phoneNum;
		this.title = titleName;
		this.gender = genderType;
	}
	
	@Override
	public String toString() {
		return title + " " + firstName + " " + lastName + " in " + department + " has phone number of " + phoneNumber + " is " + gender;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Employee) {
			Employee other = (Employee) o;
			return lastName.compareTo(other.lastName);
		}
		return 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDepartment() {
		return department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getGender() {
		return gender;
	}

}
