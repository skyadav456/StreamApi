package com.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemoveNullValue {
	public static void main(String[] args) {
		
		/*Remove null values using filter(Objects::nonNull)
		 * Objects.nonNull() is a built-in method that returns:
		 * true -->if object is not null
		 * false--> if object is null
		 * */
		
		List<String> names = Arrays.asList("Rahul", null, "Amit", null, "Sita");
		List<String> withoutNull = names.stream().filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println(withoutNull);
		
	}

}
