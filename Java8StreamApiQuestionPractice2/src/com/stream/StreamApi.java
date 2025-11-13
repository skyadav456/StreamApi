package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamApi {

	public static void main(String[] args) {
		
		//second highest salary using Streams?
		
		List<Integer> salaries = Arrays.asList(5000,6000,4000,8000,9000,7000,12000);
		Integer secondHighSalary = salaries.stream()
																	.distinct()
																	.sorted(Comparator.reverseOrder())
																	.skip(1)
																	.findFirst().orElse(null);
		System.out.println(secondHighSalary);
	}

}
