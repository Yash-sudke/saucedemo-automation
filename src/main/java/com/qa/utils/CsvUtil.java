package com.qa.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
	
	public static Object[][] getTestData(String filePath) {
		
        List<Object[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                data.add(values);  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }
}
