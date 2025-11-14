package com.filter;
import java.util.List;
import java.util.Objects;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String status;                       // ACTIVE / INACTIVE
    private List<String> projects;        // nested list
    private Address address;              // nested object
    
    
	public Employee(int id, String name, String department, double salary, String status, List<String> projects,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.status = status;
		this.projects = projects;
		this.address = address;
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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<String> getProjects() {
		return projects;
	}


	public void setProjects(List<String> projects) {
		this.projects = projects;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
	    return "Employee{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", department='" + department + '\'' +
	            ", salary=" + salary +
	            ", status='" + status + '\'' +
	            ", address=" + address +
	            ", projects=" + projects +
	            '}';
	}
	    @Override
	    public boolean equals(Object o) {
	    	if(this==o) return true;
	    	if(o ==null || getClass()!=o.getClass()) return false;
	    	Employee emp = (Employee)o;
	    	return id ==emp.id;
	    }
	    
	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
    
	
}
