
/*to get the subject of student */

package com.flatmap;

import java.util.List;

public class Student {
	private int id;
	private List<String> subject;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	
	
	public Student(int id, List<String> subject) {
		super();
		this.id = id;
		this.subject = subject;
	}
	
	
	public static void main(String[] args) {
		List<Student> student= List.of(
													new Student(101, List.of("Math", "Science")),
													new Student(102, List.of("English", "Science")),
												    new Student(103, List.of("History", "Civics"))	);
		
		List<String> subjectList = student.stream()
																.flatMap(p->p.getSubject().stream())
																.distinct()
																.sorted()
																.toList();
		System.out.println(subjectList);
	}

}
