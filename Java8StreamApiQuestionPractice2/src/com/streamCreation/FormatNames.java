package com.streamCreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FormatNames {
	
	public static void main(String[] args) {
		
		/*Format Names (String Transformation
		 * [sharad","manish","raju"]  ---> [Sharad, Manish, Raju]
		 * */
		
		List<String> names = Arrays.asList("sharad","manish","raju");
		List<String> nameList = names.stream().map(n->n.substring(0,1).toUpperCase() +n.substring(1)).toList();
		System.out.println(nameList);
	}

}
