package com.streamCreation;

import java.awt.Window.Type;
import java.util.List;

public class ChangingDataType {
	
	public static void main(String[] args) {
		
		/*Changing Data Type*/
		List<String> data=List.of("10","20","40","50");
		List<Integer> intData = data.stream().map(Integer::parseInt).toList();
		System.out.println(intData);
	}

}
