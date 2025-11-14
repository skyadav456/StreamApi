package com.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitSentencesintoWords {

	public static void main(String[] args) {
			
		List<String> sentences = Arrays.asList(
		        "Java Stream API is powerful",
		        "flatMap helps to flatten data",
		        "We are learning Streams"
		);
		
		List<String> words = sentences.stream()
															.flatMap(sentence->Arrays.stream(sentence.split(" ")))
															.collect(Collectors.toList());
		System.out.println(words);

	}

}
