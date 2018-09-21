package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Counting implements Interface {
	
	public String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

	public String[] splitText() {
		String englishText = loadFromFile(new File("English.in.txt"));
		String[] arrayOne = englishText.split(" ");
		return arrayOne;
	}

	public void countRepeatingWords(String[] arrayOne) {
		// converting from array to ArrayList
		List<String> stringList = new ArrayList<String>();
		for (String s : arrayOne) {
			stringList.add(s);
		}

		HashMap<String, Integer> hmSelected = new HashMap<>();
		int repeatedWords = 0;
		for (int i = 0; i < stringList.size(); i++) {
			repeatedWords = Collections.frequency(stringList, stringList.get(i));
			if (repeatedWords > 1) {
				for (int j = 0; j < stringList.size(); j++) {
					if (!stringList.get(i).equals(stringList.get(j))) {
						hmSelected.put(stringList.get(i), repeatedWords);
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("This is the result: ");
		Set<Map.Entry<String, Integer>> hms = hmSelected.entrySet();
		for (Map.Entry<String, Integer> hmse : hms) {
			System.out.println(hmse.getKey() + "\t" + hmse.getValue());
		}
	}
}
