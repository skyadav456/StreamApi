package com.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SkipAndLimit {
		
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
				
		//  get first 3 employee
		
		List<Employee> firstThree = employees.stream().limit(3).collect(Collectors.toList());
		System.out.println(firstThree);
		
		System.out.println("-----------------------------");
		
		// TOP 3 highest salary employees
		List<Employee> highestSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
										.limit(3).collect(Collectors.toList());
		for(Employee emp:highestSalary) {
//			System.out.println( "First three highest salary employee  are -");
			System.out.println("Name :" + emp.getName() +"," + "Salary :" + emp.getSalary());
		}
		
		System.out.println("--------------------------------------");
		
		//Get last 3 employees
		 List<Employee> last3 = employees.stream().skip(Math.max(0, employees.size()-3)).collect(Collectors.toList());
		 System.out.println(last3);
		
		System.out.println("------------------------------------------");
		
		// Get 5 unique project names
		List<String> projectList = employees.stream()
											.flatMap(emp -> emp.getProjects().stream())
												.distinct() .limit(5)
												.collect(Collectors.toList());
		System.out.println(projectList);
		
		System.out.println("--------------------------------------");
		
		/*Primitive Streams
		 * mapToInt() 
		 * mapToDouble()
		 * mapToLong()
		 */
		
		//  Total Salary of All Employees
		double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println(totalSalary);
		
		System.out.println("---------------------------------------");
		
		/*     Average Salary   */
		double average = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
		System.out.println("Average Salary: "+ average);
		System.out.println("-------------------------------------------");
		
		/*Highest Salary (max)*/
		double maxSalary = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
		System.out.println("max salary :" +maxSalary);
		System.out.println("--------------------------------------");
		
		/*Count Projects of Each Employee*/
		IntStream projectCount = employees.stream().mapToInt(e->e.getProjects().size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
	}
}
