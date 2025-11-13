package com.streamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ByCollection {
	public static void main(String[] args) {
		
		// by Collection
		List<Integer> list = List.of(10,20,30,40);
		list.stream().forEach(System.out::println);
		
		//By Arrays
		System.out.println("=============By Array============");
		String[] cities= {"Delhi","UP","Varanasi"};
		Stream<String> stream = Arrays.stream(cities);
		stream.forEach(System.out::println);
		
		// bY Stream.of()
		System.out.println("=========By Stream.of()==========");
		Stream<Integer> num= Stream.of(10,30,40,50);
		num.forEach(System.out::println);
		
		//By Stream.generate()
		System.out.println("=========By Stream.generate()=================");   // infinite stream
		
		Stream<Double> random = Stream.generate(Math::random).limit(3);
		random.forEach(System.out::println);
		
		// By Stream.iterate()
		System.out.println("=======By Stream.iterate()============");
		
		Stream<Integer> number = Stream.iterate(1, n->n+2).limit(5);
		number.forEach(System.out::println);
}
	}


