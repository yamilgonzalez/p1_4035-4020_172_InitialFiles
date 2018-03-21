package experimentalClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.ArrayList;

import dataGenerator.DataGenerator;

public class ExperimentController {
	private int n; 					   // number of companies
	private int m; 					   // number of crime events
	private int iSize;          	   // initial size for experimentation
	private int fSize; 				   // final size for experimentation
	private int iStep; 				   //increment of sizes
	private int rep; 				   //number of repetitions for each size

	private ArrayList<StrategiesTimeCollection<Integer>> resultsPerStrategy; 

	public ExperimentController(int n, int m, int iSize, int fSize,int iStep, int rep) { 
		this.n = n;
		this.m = m;
		this.iSize = iSize;
		this.fSize = fSize;
		this.iStep = iStep;
		this.rep = rep;
		resultsPerStrategy = new ArrayList<>();
	}
	public void addStrategy(StrategiesTimeCollection<Integer> strategy) { 
		resultsPerStrategy.add(strategy); 
	}
	public void run() throws CloneNotSupportedException, FileNotFoundException { 
		if (resultsPerStrategy.isEmpty())
			throw new IllegalStateException("No strategy has been added."); 
		for (int size=iSize; size<=fSize; size+= iStep) { 
			for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) 
				strategy.resetSum();    

			for (int r = 0; r<rep; r++) {

				Integer[][][] dataSet = (Integer[][][]) generateData(n, m, size);  

				for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) {	
					long startTime = System.nanoTime();  
					strategy.runTrial(dataSet);                
					long endTime = System.nanoTime();    

					int estimatedTime = (int) (endTime-startTime);   
					strategy.incSum(estimatedTime);    				
				}
			}	
			for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy)
				strategy.add( new AbstractMap.SimpleEntry<Integer, Float>
				(size, (strategy.getSum()/((float) rep)))
						); 
		}

	}
	private Object[][][] generateData(int n, int m, int size) {
		DataGenerator dg = new DataGenerator(n,m,size);
		Object[][][] data = dg.generateData();  

		return data;
	}
	public void saveResults() throws FileNotFoundException { 
		
		PrintStream out = new PrintStream(new File("experimentalResults", "allResults.txt"));
		out.print("Size");
		for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy) 
			out.print("\t" + trc.getStrategyName()); 
		out.println();

		int numberOfExperiments = resultsPerStrategy.get(0).size(); 
		for (int i=0; i<numberOfExperiments; i++) {
			out.print(resultsPerStrategy.get(0).get(i).getKey());
			for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy)
				out.print("\t" + trc.get(i).getValue());
			out.println(); 
		}
			
		out.close();
		
	}
}