package com.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distict {
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
			            new Address("London", "LDN", "UK")));
						
					//  Find the Unique Project Names
						List<String> uniqueProject = employees.stream().flatMap(p->p.getProjects().stream()).distinct()
										.collect(Collectors.toList());
						System.out.println(uniqueProject);
						
				  System.out.println("------------------------------------------------");
				  
				  // Unique Departments
				  List<String> uniqueDepartment = employees.stream().map(d->d.getDepartment()).distinct().collect(Collectors.toList());
				  System.out.println("Unique Department :" +uniqueDepartment);
				  
				  System.out.println("------------------------------------------------");
				  
				  // Unique Cities of Employees
				  
				  List<String> uniqueCity = employees.stream().map(c->c.getAddress().getCity()).distinct().collect(Collectors.toList());
				  System.out.println("Unique city : "+ uniqueCity);
				  
				  System.out.println("---------------------------------------------");
				  
				  //  Unique Active Status Values 
				  List<String> uniqueStatus = employees.stream().map(s->s.getStatus()).distinct().collect(Collectors.toList());
				  System.out.println("Unique Status :"+ uniqueStatus);
				  
						
						

		
	}
}
