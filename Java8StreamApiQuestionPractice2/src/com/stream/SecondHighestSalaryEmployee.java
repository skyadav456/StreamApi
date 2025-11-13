package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employees{
	String name ;
	double salary;
	
	
	public Employees(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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


	@Override
	public String toString() {
		return "Employees [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}

public class SecondHighestSalaryEmployee {

	public static void main(String[] args) {
	
		List<Employees> emp = Arrays.asList( new Employees("Sharad", 5000),
                new Employees("Rajesh", 7000),
                new Employees("Manish", 8000),
                new Employees("Neelu", 9000),
                new Employees("kalu", 8000));
		
		Double secondSalary = emp.stream()
													.map(e->e.getSalary())
													.distinct().sorted(Comparator.reverseOrder())
													.skip(1).findFirst().orElse(null);
		System.out.println(secondSalary);
		
		

	}

}
