package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

 class Emp {
	private int id;
	private String name;
	private double salary;
	private String department;
	private String city; 
	private int age; 
	private String email; 
	private LocalDate dateOfJoining; 
	
	public Emp(int id, String name, double salary, String department, String city, int age, String email,
			LocalDate dateOfJoining) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.city = city;
		this.age = age;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	// equals() and hashCode() based on id
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Emp))
			return false;
		Emp emp = (Emp) o;
		return id == emp.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// toString() method
	@Override
	public String toString() {
		return "Emp{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + ", department='" + department
				+ '\'' + ", city='" + city + '\'' + ", age=" + age + ", email='" + email + '\'' + ", dateOfJoining="
				+ dateOfJoining + '}';
	}
}

public class EmployessExample {

	public static void main(String[] args) {

		List<Emp> employees = Arrays.asList(
				new Emp(1, "Alice", 5000, "IT", "New York", 28, "alice@example.com", LocalDate.of(2021, 5, 10)),
				new Emp(2, "Bob", 7000, "Finance", "Chicago", 32, "bob@example.com", LocalDate.of(2019, 3, 15)),
				new Emp(3, "Charlie", 8000, "IT", "New York", 29, "charlie@example.com", LocalDate.of(2020, 7, 20)),
				new Emp(4, "David", 9000, "HR", "Los Angeles", 35, "david@example.com", LocalDate.of(2018, 1, 10)),
				new Emp(5, "Eve", 8000, "Finance", "Chicago", 31, "eve@example.com", LocalDate.of(2022, 2, 5)),
				new Emp(6, "Frank", 6000, "HR", "Los Angeles", 27, "frank@example.com", LocalDate.of(2021, 6, 25)),
				new Emp(7, "Grace", 10000, "IT", "New York", 33, "grace@example.com", LocalDate.of(2017, 11, 12)),
				new Emp(8, "Hannah", 7500, "Finance", "Chicago", 30, "hannah@example.com", LocalDate.of(2020, 9, 18)),
				new Emp(9, "Ishan", 9500, "IT", "New York", 34, "ishan@example.com", LocalDate.of(2016, 4, 3)),
				new Emp(10, "Judy", 6500, "HR", "Los Angeles", 28, "judy@example.com", LocalDate.of(2019, 12, 1)));

		// Get a list of employee names who earn more than 80k.
		employees.stream().filter(e -> e.getSalary() > 80000).map(Emp::getName).forEach(System.out::println);

		System.out.println("-------------------------------------------------");

		// Find the sum of all salaries of employees in the IT department.
		double TotalItSalary = employees.stream().filter(e -> e.getDepartment().equals("IT"))
				.mapToDouble(Emp::getSalary).sum();
		System.out.println(TotalItSalary);

		System.out.println("----------------------------------------------------");

		//Get distinct cities from a list of employees.
		employees.stream().map(Emp::getCity)
										.distinct()
										.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		//Count how many employees are older than 30.
		long count = employees.stream().filter(e->e.getAge()>30).count();
		System.out.println("employees are older than 30: "+count);
		
		System.out.println("----------------------------");
		
		//Get the employee with the maximum salary.
		
		Optional<Emp> max = employees.stream().max(Comparator.comparingDouble(Emp::getSalary));
		max.ifPresent(emp->
					System.out.println("Max salary of emp is  :"+ emp)
				);
		
		System.out.println("------------------------------");
		
		//Find the second highest salary from employees.
		
		Optional<Emp> secondHighest = employees.stream().
																					sorted(Comparator.comparingDouble(Emp::getSalary).reversed())
																					.distinct().skip(1).findFirst();
		 System.out.println("Second Highest Salary of emp: "+secondHighest);
		 // using map function - second highest salary  
		 
		 Optional<Double> SecondMaxSlary = employees.stream()
				 																		.map(Emp::getSalary)
				 																		.distinct()
				 																		.sorted(Comparator.reverseOrder())
				 																		.skip(1)
				 																		.findFirst();
		 System.out.println(SecondMaxSlary.get());
		 
		 System.out.println("-----------------------------------");
		 
		 //Group employees by department and count them.
		 Map<String, Long> departmentEmployee = employees.stream().collect(Collectors.groupingBy(Emp::getDepartment,Collectors.counting()));
		 System.out.println(departmentEmployee);
		 
		 System.out.println("---------------------------------");
		 
		 //Find the highest-paid employee in each department.
		 
		 Map<String, Optional<Emp>> highestPaid = employees.stream().collect(Collectors.groupingBy(
				 																									Emp::getDepartment,
				 																									Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary))));
		 highestPaid.forEach((dept,salary)->
		 		salary.ifPresent(emp->
			System.out.println("dept:"+ dept + "salary: "+ emp)));
		 
		 System.out.println("---------------------------------------");
		 
		 //Get the average salary of employees younger than 30.
		 Double averageSalary = employees.stream().filter(age->age.getAge()<30)
				 													.collect(Collectors.averagingDouble(Emp::getSalary));
		 System.out.println(averageSalary);
		 
		 System.out.println("---------------------------------------");
		 
		 
		 
		 
	}

}
