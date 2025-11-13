package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmpTest01 {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "John Doe", 25, 50000, "IT", "john@company.com"),
			    new Employee(102, "Alice Smith", 32, 70000, "HR", "alice@company.com"),
			    new Employee(103, "Bob Johnson", 28, 60000, "Finance", "bob@company.com"),
			    new Employee(104, "Mike Brown", 40, 80000, "IT", "mike@company.com"),
			    new Employee(105, "David Lee", 38, 90000, "Finance", "david@company.com"),
			    new Employee(106, "Sophia White", 29, 85000, "IT", "sophia@company.com")
			);

		
		//Employees older than 30
		List<Employee> age = employees.stream().filter(e->e.age>30).collect(Collectors.toList());
		age.forEach(System.out::println);
		
		System.out.println("============================================");
		//Employees in IT department with salary > 60k
		
		employees.stream().filter(e->e.department.equals("IT"))
										.filter(e->e.salary>60000)
										.collect(Collectors.toList())
										.forEach(System.out::println);
		
		System.out.println("============================================");
		
		// Employee name having salary greater than 60k
		
		employees.stream().filter(e->e.salary>60000)
										.map(e->e.name).collect(Collectors.toList())
										.forEach(System.out::println);
		
		System.out.println("==============================================");
		
		// First employee with salary > 70K
		
		employees.stream().filter(e->e.salary>40000).findFirst().ifPresent(System.out::println);

		System.out.println("=============================");
		
		//Filter & sort employees by salary
		
		employees.stream().filter(e->e.salary>25000)
										.sorted(Comparator.comparingDouble(e->e.salary))
										.forEach(System.out::println);
		
		System.out.println("=================================");
		
		//From a list of employees, find emails of employees who belong to "IT" department.
		employees.stream().filter(e->e.department.equals("IT"))
										.map(e->e.email).forEach(System.out::println);;
		
		System.out.println("======================================");
		
		// //From a list of employees, find first character of the name of employees of "IT"department
		
		employees.stream().filter(e->e.department.equals("IT"))
										.map(e->e.name.charAt(0))
										.forEach(System.out::println);
		
		System.out.println("==============================");
		
		//From a list of employees, get the salary incremented by 10% for employees in HR.
		
		employees.stream().filter(e->e.department.equals("HR"))
										.map(e->e.salary*1.1)
										.forEach(System.out::println);
		
		System.out.println("================================");
		
		//From a list of employees, get IDs of employees whose salary is between 50k and 70k.
		
		employees.stream().filter(e->e.salary>=50000 && e.salary<=70000)
										.map(e->e.id)
										.forEach(System.out::println);
		
	 System.out.println("==========================================");
	 
	 //From a list of employees, get the average salary of employees with age < 30.
	 
	 OptionalDouble avgSalary = employees.stream().filter(e->e.age<30).mapToDouble(e->e.salary).average();
	 System.out.println("Average salary age>30  is : "+ avgSalary);
	 
	 
	 System.out.println("===============================");
	 
	 //From a list of employees, get the name lengths of employees with salary > 80k and sort them descending.
	 
	 employees.stream().filter(e->e.salary>80000)
	 								.map(n->n.name.length())
	 								.sorted(Comparator.reverseOrder())
	 								.collect(Collectors.toList())
	 								.forEach(System.out::println);;
	 								
	 System.out.println("=============================");
	 
	 //From a list of employees, get a Map<Name, Salary> for employees in IT.
	 
	 Map<String, Double> map = employees.stream().filter(e->e.department.equals("IT"))
	 								.collect(Collectors.toMap(e->e.name,e->e.salary));
	 System.out.println(map);
		
	}

}
