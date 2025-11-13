package com.streamCreation;

import java.util.UUID;
import java.util.stream.Stream;

public class UniqueOrderId {
	
	public static void main(String[] args) {
		Stream<String> uuid = Stream.generate(()-> "ORD-"+UUID.randomUUID()).limit(5);
		uuid.forEach(System.out::println);
	}
}
