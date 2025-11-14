package com.filter;

import java.util.Arrays;
import java.util.List;

public class TerminalOperationMethod {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee(1, "Amit", "IT", 60000, "ACTIVE",
			            Arrays.asList("Project A", "Project B"),
			            new Address("Pune", "MH", "India")),

			    new Employee(2, "Raj", "HR", 35000, "INACTIVE",
			            Arrays.asList("Project X"),
			            new Address("Delhi", "DL", "India")),

			    new Employee(3, "Neha", "IT", 80000, "ACTIVE",
			            Arrays.asList("Project A", "Project C", "Project D"),
			            new Address("Mumbai", "MH", "India")),

			    new Employee(4, "John", "Finance", 50000, "ACTIVE",
			            Arrays.asList("Project Y", "Project Z"),
			            new Address("New York", "NY", "USA")),

			    new Employee(5, "Sara", "IT", 45000, "ACTIVE",
			            Arrays.asList("Project B"),
			            new Address("London", "LDN", "UK"))
			);
		
		//   forEach() Method 
		
		//  Print the names of ACTIVE employees in UPPERCASE.
		
		employees.stream().filter(s->"ACTIVE".equals(s.getStatus()))
										.map(n->n.getName().toUpperCase())
										.forEach(System.out::println);		
		
		
		
		
	}

}
