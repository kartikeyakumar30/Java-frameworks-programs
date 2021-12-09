package com.kk.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			
			// Read JSON file and map/convert to java POJO:
			// data/sample-lie.json
			//Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name and last name;
			System.out.println("First name : " + theStudent.getFirstName());
			System.out.println("Last name : " + theStudent.getLastName());
			
			//Print out Street and city
			Address tempAddress = theStudent.getAddress();
			System.out.println("Address - City : " + tempAddress.getCity());
			System.out.println("Address - Street : " + tempAddress.getStreet());
			
			//Print out languages
			System.out.println("Languages : ");
			for(String tempLang : theStudent.getLanguages()) {
				System.out.println("\t" + tempLang);
			}
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
