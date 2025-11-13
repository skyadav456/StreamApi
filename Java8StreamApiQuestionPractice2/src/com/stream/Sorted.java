package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Sorted {
	public static void main(String[] args) {
		
		// Natural Sorting
		
		List<Integer> list = Arrays.asList(2,5,3,6,11,8,9,12);
		 list.stream().sorted().forEach(System.out::println);;
		 
		System.out.println("===========================");
		
		List<String> name =Arrays.asList("Rajesh","Anil","Vivek","Manish","Sharad");	
		name.stream().sorted().forEach(System.out::println);
		
		System.out.println("=======================");
		
		// Reverse Order Sorting  -- use Comparator.reverseOrder()   funcrion
		
		List<Integer> num = Arrays.asList(5,6,3,6,1,8,9,2);
		num.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
		//  custom sorting  -- sorted(Comparator.comaparing(.......)
		
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "John Doe", 25, 50000, "IT", "john@company.com"),
			    new Employee(102, "Alice Smith", 32, 70000, "HR", "alice@company.com"),
			    new Employee(103, "Bob Johnson", 28, 60000, "Finance", "bob@company.com"),
			    new Employee(104, "Mike Brown", 40, 80000, "IT", "mike@company.com"),
			    new Employee(105, "David Lee", 38, 90000, "Finance", "david@company.com"),
			    new Employee(106, "Sophia White", 29, 85000, "IT", "sophia@company.com")
			);
		
		// sort by salary in ascending order
		
	employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
									.forEach(System.out::println);;
									
		System.out.println("===============================");							
		
	// sort by descending order 
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
							.reversed()).forEach(System.out::println);
		System.out.println("==============================");
		// sort employee by name
		employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		
		System.out.println("========================================");
		
		// Sort employees by Department, then by Name:
		
		employees.stream().sorted(Comparator.comparing(Employee::getDepartment)
										.thenComparing(Employee::getName)).
										forEach(System.out::println);
		
		System.out.println("=====================================");
		//  Sort employees by Salary (Descending), then by Name (Ascending)
		
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
										.thenComparing(Employee::getName))
										.forEach(System.out::println);
	}

}
