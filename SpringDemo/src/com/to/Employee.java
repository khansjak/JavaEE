package com.to;

public class Employee {
	private int employeeId;
	private String employeeName;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		System.out.println("Setting : Employee name called.");
		this.employeeName = employeeName;
	}
	
	public Employee() {
		super();
		System.out.println("Default constructor called");
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		System.out.println("Parameterized Constructor called !");
	}
	
	

}
