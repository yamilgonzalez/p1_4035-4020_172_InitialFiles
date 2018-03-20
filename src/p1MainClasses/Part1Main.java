package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import solutionsP.P1P2solution;
import solutionsP.P3solution;


public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length!=0) {
			switch(args[0]){
			case "1": { 
				IntersectionFinder P1 = new P1P2solution("1");
				MySet TemporarySet = new Set1();
				System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder(TemporarySet)));
				break;
			}
			case "2": {
				IntersectionFinder P2 = new P1P2solution("2");
				MySet TemporarySet = new Set2();
				System.out.println("Final Set by P2:" + P2.intersectSets(unionFinder(TemporarySet)));
				break;
			}
			case "3": {
				IntersectionFinder P3 = new P3solution("3");
				MySet TemporarySet = new Set2();
				System.out.println("Final Set by P3:" + P3.intersectSets(unionFinder(TemporarySet)));
				break;
			}
			}
		}
	}

	private static MySet[] unionFinder(MySet TemporarySet) throws FileNotFoundException {

		String parentDirectory = "inputFiles"; 
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();

		MySet[] t = new MySet[m];

		for (int j=0; j<m; j++) { 
			for (int i=0; i<n; i++) {
				String fileName = "F_" + i + "_" + j + ".txt"; 
				Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
				while (inputFile.hasNext())
					TemporarySet.add(inputFile.nextInt());
				inputFile.close();  
			}
			t[j] = (MySet)TemporarySet;
		}
		return t;
	}
}
