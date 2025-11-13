package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectFunction {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Learn","java", "deeply");
		//collect as a joining function
		String result = list.stream().collect(Collectors.joining(", "));
		System.out.println(result);
		
		System.out.println("============");
		
		// collect as a count
		
		Long count = list.stream().collect(Collectors.counting());
		System.out.println(count);
		
		System.out.println("=====================");
		
		// summing / averaging
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "John Doe", 25, 50000, "IT", "john@company.com"),
			    new Employee(102, "Alice Smith", 32, 70000, "HR", "alice@company.com"),
			    new Employee(103, "Bob Johnson", 28, 60000, "Finance", "bob@company.com"),
			    new Employee(104, "Mike Brown", 40, 80000, "IT", "mike@company.com"),
			    new Employee(105, "David Lee", 38, 90000, "Finance", "david@company.com"),
			    new Employee(106, "Sophia White", 29, 85000, "IT", "sophia@company.com")
			);
		
	Double salaryAvg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
	System.out.println(salaryAvg);
	
	Double salarySum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
	System.out.println(salarySum);
	
	System.out.println("==============groupingBy ==============");
	
	//Group by Department
	Map<String, List<Employee>> byDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	System.out.println(byDepartment);
	
	System.out.println("===========count by department=============");
	//Count by Department
	Map<String, Long> counting = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	System.out.println(counting);
	
	System.out.println("===========Average salary by Department==========");
	//Average salary by Department
Map<String, Double> avgDeptSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
System.out.println(avgDeptSalary);

	// Count Employees in IT Department
	long itDepartNo = employees.stream().filter(x->x.getDepartment().equals("IT")).count();
	System.out.println("number of IT department Emp : "+ itDepartNo);
	}

}
