package com.jblotus.spacestotabs;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

	public static StringBuffer parse(File file) {
		// TODO Auto-generated method stub
		System.out.println(file.getAbsolutePath());
		
		String inputString = ""; 
		//need to return a new file that has been parsed
		StringBuffer newFileContent = new StringBuffer("");
		
		Pattern p = Pattern.compile("^\\s+");	
		try {
				BufferedReader in = new BufferedReader(new FileReader(file));			
				String replaceString = null;
				while((inputString = in.readLine()) != null) {	
					
					Matcher m = p.matcher(inputString);
					boolean result= m.find();
					System.out.println(result);
					/**
					 * If we get a match on our regex test replace this string
					 */
					if (result) {
						newFileContent.append(m.replaceAll(" "));
					} else {
						newFileContent.append(inputString);
					}
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFileContent;    
			
	}

}
