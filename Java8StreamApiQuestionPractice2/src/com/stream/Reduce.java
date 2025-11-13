package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(2,3,4,1,5,6,3);
		Optional<Integer> sum = num.stream().reduce((a,b)->a+b);
		System.out.println(sum.get());
		
		System.out.println("===================");
		
		Integer sums = num.stream().reduce(0,(a,b)->a+b);
		System.out.println(sums);
		
		System.out.println("==================");
		
		//Find maximum number
		
		Integer max = num.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
		System.out.println(max);
		
		System.out.println("=================");
		
		//Concatenate strings
		List<String> string = Arrays.asList("Java", "Streams", "API");
		String con = string.stream().reduce("",(a,b)->a +" "+b);
		System.out.println(con);
		
		System.out.println("==========================");
		
		//Reduce on Custom Objects (Employee salary sum)
		
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "John Doe", 25, 50000, "IT", "john@company.com"),
			    new Employee(102, "Alice Smith", 32, 70000, "HR", "alice@company.com"),
			    new Employee(103, "Bob Johnson", 28, 60000, "Finance", "bob@company.com"),
			    new Employee(104, "Mike Brown", 40, 80000, "IT", "mike@company.com"),
			    new Employee(105, "David Lee", 38, 90000, "Finance", "david@company.com"),
			    new Employee(106, "Sophia White", 29, 85000, "IT", "sophia@company.com")
			);
		
		Double salarySum = employees.stream().map(Employee::getSalary).reduce(0.0,(a,b)->a+b);
		System.out.println(salarySum);
	}
}
