package com.sathya.jdbcs;

public class Test {
	public static void main(String[] args) {
//		Employee employee = new Employee(1,"ravi",116.25);
//		System.out.println(employee);
//		
//		Employee employee2 = new Employee();
//		
//		employee2.setEmpId(2);
//		employee2.setEmpName("suresh");
//		employee2.setEmpSalary(1116.16);
//		
//		System.out.println(employee2);
		
//		Employee employee = Employee.builder()
//									.empId(3).empName("rakesh").empSalary(116.25)
//									.build();
//		System.out.println(employee);
		
		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setEmpName(null);
		employee.setEmpSalary(116.25);
		
		System.out.println(employee);
	}
}
