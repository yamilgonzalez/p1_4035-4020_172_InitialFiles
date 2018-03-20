package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import solutionsP.P1P2solution;

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length!=0) {
			switch(args[0]){
			case "1": { 
				IntersectionFinder P1 = new P1P2solution("1");
				System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder()));
				break;
			}
			}
		}
	}

	private static MySet[] unionFinder() throws FileNotFoundException {

		String parentDirectory = "inputFiles"; 
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();

		MySet[] t = new MySet[m];
		MySet TemporarySet = new Set1();

		for (int j=0; j<m; j++) { 
			for (int i=0; i<n; i++) {
				String fileName = "F_" + i + "_" + j + ".txt"; 
				Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
				while (inputFile.hasNext())
					TemporarySet.add(inputFile.nextInt());
				inputFile.close();  
			}
			t[j] = TemporarySet;
		}
		return t;
	}
}
