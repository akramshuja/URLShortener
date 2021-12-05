package com.shorturl.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class URLFileResource {
	
	public static List<String> readFromFile() throws IOException
	{
		createFileIfNotExists();
		
		List<String> lines = Collections.emptyList();
		lines = Files.readAllLines(Paths.get("urlMap.txt"), StandardCharsets.UTF_8);
		
		return lines;
	    
	}

	public static void writeToFile(String str) throws IOException
	{
		createFileIfNotExists();
		
		BufferedWriter out = new BufferedWriter(new FileWriter("urlMap.txt", true));
        out.write(str);
        out.write("\n");
        out.close();
	}
	
	private static void createFileIfNotExists() throws IOException {
		
		new File("urlMap.txt").createNewFile();
	}

}
