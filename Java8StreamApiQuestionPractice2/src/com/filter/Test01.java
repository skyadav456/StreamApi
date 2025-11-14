package com.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test01 {
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
				
					/*	Extract Employee Names*/
				List<String> empName = employees.stream().map(n->n.getName()).collect(Collectors.toList());
				System.out.println(empName);
				
				System.out.println("==============================");
				
				//  Extract Cities
				List<String> cities = employees.stream().map(c->c.getAddress().getCity()).collect(Collectors.toList());
				System.out.println("Cities :" +cities);
				
				System.out.println("--------------------------------------------------------");
				
				/*  Convert Employee → EmployeeDTO  */
				List<EmployeeDTO> dtoList = employees.stream()
																					.map(emp->new EmployeeDTO(emp.getName(), emp.getSalary()))
																					.collect(Collectors.toList());
				System.out.println("emp DTO:  "+dtoList);
				
				System.out.println("----------------------------------------------------------");
				/*Increase Salary of Every Employee by 10%*/
				List<Double> newSalary = employees.stream().map(s->s.getSalary()*1.10).collect(Collectors.toList());
				System.out.println("Salary after increment: "+ newSalary);
				
				System.out.println("----------------------------------------------------------------");
				
				/*Convert all names to uppercase*/
				List<String> upperCaseName = employees.stream().map(n->n.getName().toUpperCase()).collect(Collectors.toList());
				System.out.println("Nmae after uppercase :"+ upperCaseName);
				
				System.out.println("----------------------------------------------------------------------");
				
				/*Extract Length of Each Name*/
				
				List<Integer> nameLength = employees.stream().map(n->n.getName().length()).collect(Collectors.toList());
				System.out.println("Name length list :" +nameLength);
				
				System.out.println("--------------------------------------------------------------------");
				
				/*Extract salaries of only ACTIVE employees*/
				
				List<Double> activeEmpSalary = employees.stream().filter(s->s.getStatus().equals("ACTIVE")).map(Employee::getSalary).collect(Collectors.toList());
				System.out.println("Active status salary :" + activeEmpSalary);
				
				System.out.println("--------------------------------------------------------------------------");
				
				/* =============Intermediate Operation : flatMap() ==================*/
				
				/*Extract All Project Names from All Employees*/
				
				List<String> projectList = employees.stream().flatMap(p->p.getProjects().stream()).collect(Collectors.toList());
				System.out.println("project list :" +projectList);
				
				System.out.println("------------------------------------------------------------------------");
				
				/*Count How Many Projects Are Running in Company*/
				
				long noOfProject = employees.stream().flatMap(p->p.getProjects().stream()).count();
				System.out.println(" No of Running Project :"+ noOfProject);
				System.out.println("-------------------------------------------");
				
				
				/*===== Topic :   sorted()========*/
				
				//  Sort Employees by Name
				
				/*List<Employee> sortedName = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
				System.out.println("Sorted Name: "+ sortedName);*/
				
				List<Employee> sortedByName = employees.stream()
																							.sorted(Comparator.comparing(Employee::getName))
																							.collect(Collectors.toList());
				System.out.println(sortedByName);
				
				// Sort Employees by Salary (Ascending)
				
				List<Employee> bySalary = employees.stream()
																				.sorted(Comparator.comparing(Employee::getSalary))
																				.collect(Collectors.toList());
				for (Employee employee : bySalary) {
					   System.out.println("Name :" + employee.getName() + ", " + "Salary: "+ employee.getSalary());
				}
				
				System.out.println("-----------------------------------------------------------------");
				// Sort Employees by Salary (Descending)
				
				List<Employee> sortedDescendingBySalary =employees.stream()
																												.sorted(Comparator.comparing(Employee::getSalary).reversed())
																												.collect(Collectors.toList());
				for (Employee employee : sortedDescendingBySalary) {
					 System.out.println("Name :" + employee.getName() + ", " + "Salary: "+ employee.getSalary());
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			}
}
