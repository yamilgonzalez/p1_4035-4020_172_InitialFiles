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
		
		//Create an array of intersection finders 
		IntersectionFinder[] intFind = new IntersectionFinder[4]; 
		//initialize each of them
		intFind[0] = new P1P2solution("P1");
		intFind[1] = new P1P2solution("P2");
		intFind[2] = new P3solution("P3");
		intFind[3] = new P4solution("P4"); 

		if (args.length!=0) { //The user selected a strategy
			int strategy = Integer.parseInt(args[0])-1;
			System.out.println("Final set by " + intFind[strategy].getName()+":" + intFind[strategy].intersectSets(unionFinder(args[0])));
		}
		else { //The user did not selected a strategy, apply all
			for(int i = 0; i<intFind.length ; i++){
				System.out.println("Final set by " + intFind[i].getName()+":" + intFind[i].intersectSets(unionFinder(Integer.toString(i+1))));
			}
		}

	}
	/**
	 * Reads all files and finds the union set of the numbers of each crime event and stores them in 
	 * an array of sets
	 * @param argument the strategy receiving the set
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