package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import solutionsP.P1P2solution;

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		final int input = scanner.nextInt();
		scanner.close();

		switch(input){
		case 1: { 
			P1P2solution P1 = new P1P2solution("1");
			System.out.println("Final Set by P1:" + P1.intersectSets(unionFinder()));
			break;
		}
		}
	}

	private static MySet[] unionFinder() throws FileNotFoundException {
		String parentDirectory = "inputFiles"; 
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt")); 
		int n = parameters.nextInt(); 
		int m = parameters.nextInt();
		parameters.close();

		DataReader dr = new DataReader();
		Object[][][] dataFile = dr.readDataFiles();
		MySet[] t = new MySet[m];
		for(int j=0 ; j< m ; j++) {
			for( int i = 0; i<n ; i++) {
				t[j].add(dataFile[i][j]);
			}
		}
		return t;
	}
}
