package com.streamCreation;

import java.util.Arrays;
import java.util.List;

public class IntermediateOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> emp= Arrays.asList(
												new Employee("Amit", 60000, "IT"),
											    new Employee("John", 45000, "HR"),
											    new Employee("Neha", 75000, "Finance"),
											    new Employee("Sita", 50000, "IT")
												);
		
		
		// Filter Employees by Salary
		emp.stream().filter(p->p.getSalary()>50000).
												map(Employee::getName).
												forEach(System.out::println);
		
		System.out.println("============");
		//  Convert Employee Names to Uppercase
		emp.stream().map(Employee::getName)
								.map(String::toUpperCase)
								.forEach(System.out::println);
		
		
		

	}

}
