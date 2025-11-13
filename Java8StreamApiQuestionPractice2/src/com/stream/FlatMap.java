package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
	public static void main(String[] args) {
		
		
		// Unique Words from Sentences
		 
		List<String> list = Arrays.asList("I love java", "java is powerful","Streams loves java");
		List<String> word = list.stream().map(s->s.split(" "))    // break sentence into word
							.flatMap(Arrays::stream)  // flatten array in to single stream
							.map(String::toLowerCase)   // normalize and remove duplicate
							.distinct().collect(Collectors.toList());
		System.out.println(word);
	}

}
