package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
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
		if (args.length > 1)
			System.out.println("Unexpected number of parameters. Must be 1.");
		
		if (args.length!=0) { //The user selected a strategy
			switch(args[0]){
			case "1": { //Strategy by P1 Selected
				IntersectionFinder P1 = new P1P2solution("P1");
				System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder(args[0])));
				break;
			}
			case "2": { //Strategy by P2 Selected
				IntersectionFinder P2 = new P1P2solution("P2");
				System.out.println("Final Set by P2:" + P2.intersectSets(unionFinder(args[0])));
				break;
			}
			case "3": { //Strategy by P3 Selected
				IntersectionFinder P3 = new P3solution("P3");
				System.out.println("Final Set by P3:" + P3.intersectSets(unionFinder(args[0])));
				break;
			}
			case "4": { //Strategy by P4 Selected
				IntersectionFinder P4 = new P4solution("P4");
				System.out.println("Final Set by P4:" + P4.intersectSets(unionFinder(args[0])));
				break;
			}
			}
		}
		else { //The user did not selected a strategy, apply all
			IntersectionFinder P1 = new P1P2solution("P1");
			IntersectionFinder P2 = new P1P2solution("P2");
			IntersectionFinder P3 = new P3solution("P3");
			IntersectionFinder P4 = new P4solution("P4");
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
		DataReader dr = new DataReader();
		Object [][][] dataSet = dr.readDataFiles();
		MySet[] t = new MySet[dataSet[0].length];
		
		for(int j = 0 ; j<dataSet[0].length ; j++) {
			t[j] = new Set2();                           //initializes the set as Set2
			if(argument.equals("1")) t[j] = new Set1();  //if the args is "1" then it is changed to Set1
			for(int i =0 ; i<dataSet.length ; i++) {
				for( int k=0 ; k< dataSet[i][j].length; k++) {
					t[j].add(dataSet[i][j][k]);
				}
			}
		}
		return t;
	}
}