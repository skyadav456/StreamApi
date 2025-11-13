package com.streamCreation;

import java.util.Arrays;
import java.util.List;

public class ExtractDomainName {
		public static void main(String[] args) {
			
			 List<String> email = Arrays.asList("sharad@gmail.com","rajesh@yahoo.com","manish@hotmail.com");
			 List<String> domainList = email.stream().map(e->e.substring(e.indexOf("@")+1)).toList();
			 System.out.println(domainList);
			 
			 
		}
}
