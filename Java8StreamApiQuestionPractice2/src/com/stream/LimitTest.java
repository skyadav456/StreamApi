package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LimitTest {
		public static void main(String[] args) {
			
			List<Employee> employees = Arrays.asList(
				    new Employee(101, "John Doe", 25, 50000, "IT", "john@company.com"),
				    new Employee(102, "Alice Smith", 32, 70000, "HR", "alice@company.com"),
				    new Employee(103, "Bob Johnson", 28, 60000, "Finance", "bob@company.com"),
				    new Employee(104, "Mike Brown", 40, 80000, "IT", "mike@company.com"),
				    new Employee(105, "David Lee", 38, 90000, "Finance", "david@company.com"),
				    new Employee(106, "Sophia White", 29, 85000, "IT", "sophia@company.com")
				);
			
			// find the Top 3 salaries
			
			employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
											.reversed()).limit(3).forEach(System.out::println);
		}
}
