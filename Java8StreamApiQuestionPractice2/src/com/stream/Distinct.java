package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
	public static void main(String[] args) {
		 List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 10, 50, 30);
		 
		 numbers.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		 
		 System.out.println("=====================================");
		 //Distinct Strings
		 List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
		 names.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		 
		 System.out.println("==================================");
		 
		 List<Integer> num = Arrays.asList(12,34,21,56,21);
		 num.stream().limit(3).forEach(System.out::println);
	}
}
