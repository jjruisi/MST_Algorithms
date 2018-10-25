package edu.ncsu.csc316.transportation_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayList;

public class HighwayReader {
	
	public static ArrayList<Highway> readHighways(String fileName) {
		
		Scanner scan;
		try {
			scan = new Scanner(new FileInputStream(fileName), "UTF8");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("FNF");
		}
		
		ArrayList<Highway> list = new ArrayList<Highway>();
		
		while (scan.hasNextLine()) {
			
			String line = scan.nextLine();
			Scanner s = new Scanner(line);
			
			int a = s.nextInt();
			int b = s.nextInt();
			double c = s.nextDouble();
			double d = s.nextDouble();
			
			Highway h = new Highway(a, b, c, d);
			list.add(h);
			
			s.close();
		}
		
		scan.close();
		return list;
	}

}
