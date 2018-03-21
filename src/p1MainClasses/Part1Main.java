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
import solutionsP.P4solution;


public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length!=0) {
			switch(args[0]){
			case "1": { 
				IntersectionFinder P1 = new P1P2solution("1");
				MySet TemporarySet = new Set1();
				System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder(args[0])));
				break;
			}
			case "2": {
				IntersectionFinder P2 = new P1P2solution("2");
				MySet TemporarySet = new Set2();
				System.out.println("Final Set by P2:" + P2.intersectSets(unionFinder(args[0])));
				break;
			}
			case "3": {
				IntersectionFinder P3 = new P3solution("3");
				MySet TemporarySet = new Set2();
				System.out.println("Final Set by P3:" + P3.intersectSets(unionFinder(args[0])));
				break;
			}
			case "4": {
				IntersectionFinder P4 = new P4solution("4");
				MySet TemporarySet = new Set2();
				System.out.println("Final Set by P4:" + P4.intersectSets(unionFinder(args[0])));
				break;
			}
			}
		}
		else {
			IntersectionFinder P1 = new P1P2solution("1");
			IntersectionFinder P2 = new P1P2solution("2");
			IntersectionFinder P3 = new P3solution("3");
			IntersectionFinder P4 = new P4solution("4");
			System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder("1")));
			System.out.println("Final Set by P2:" + P2.intersectSets(unionFinder("2")));
			System.out.println("Final Set by P3:" + P3.intersectSets(unionFinder("3")));
			System.out.println("Final Set by P4:" + P4.intersectSets(unionFinder("4")));
		}
	}

	private static MySet[] unionFinder(String argument) throws FileNotFoundException {

		String parentDirectory = "inputFiles"; 
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();
		
		

		MySet[] t = new MySet[m];

		for (int j=0; j<m; j++) { 
			for (int i=0; i<n; i++) {
				t[j] = new Set2();
				if(argument.equals("1")) t[j] = new Set1();

				
				String fileName = "F_" + i + "_" + j + ".txt"; 
				Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
				while (inputFile.hasNext())
					t[j].add(inputFile.nextInt());
				inputFile.close();  
			}
		}
		return t;
	}
}