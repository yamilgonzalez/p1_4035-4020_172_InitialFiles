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
/**
 * 
 * @author Maria A. Marrero
 * @author Yamil J. Gonzalez
 *
 */

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length!=0) { //The user selected a strategy
			switch(args[0]){
			case "1": { //Strategy by P1 Selected
				IntersectionFinder P1 = new P1P2solution("1");
				System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder(args[0])));
				break;
			}
			case "2": { //Strategy by P2 Selected
				IntersectionFinder P2 = new P1P2solution("2");
				System.out.println("Final Set by P2:" + P2.intersectSets(unionFinder(args[0])));
				break;
			}
			case "3": { //Strategy by P3 Selected
				IntersectionFinder P3 = new P3solution("3");
				System.out.println("Final Set by P3:" + P3.intersectSets(unionFinder(args[0])));
				break;
			}
			case "4": { //Strategy by P4 Selected
				IntersectionFinder P4 = new P4solution("4");
				System.out.println("Final Set by P4:" + P4.intersectSets(unionFinder(args[0])));
				break;
			}
			}
		}
		else { //The user did not selected a strategy, apply all
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
/**
 * Reads all files and finds the union set of the numbers of each crime event and stores them in 
 * an array of sets
 * @param argument the strategy selected by user
 * @return the array of Sets, the type depends of the strategy selected
 * @throws FileNotFoundException
 */
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