package p1MainClasses;

import java.io.FileNotFoundException;

import experimentalClasses.ExperimentController;
import experimentalClasses.StrategiesTimeCollection;
import solutionsP.P1P2solution;
import solutionsP.P3solution;
import solutionsP.P4solution;

public class Part2Main {
	public static void main (String[] args) throws CloneNotSupportedException {
		int[] parms = {10,50,1000,50000,1000,200};
		//companies, crime events, min size, max size, size increment, number of trials per size/strategy

		//if the user provides an input, change default values
		if (args.length > 6)
			System.out.println("Unexpected number of parameters. Must be <= 6.");
		for (int i=0; i<args.length; i++)
			parms[i] = Integer.parseInt(args[i]);
		// Parm1: number of companies
		// Parm2: number of crime events
		// Parm3: initial size
		// Parm4: final size 
		// Parm5: increment of sizes
		// Parm6: repetitions for each size
		ExperimentController ec = new ExperimentController(parms[0], parms[1], parms[2], parms[3],parms [4], parms[5]); 
		/**/	
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2solution("1")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2solution("2")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3solution("3")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4solution("4")));

		/**/

		ec.run();    // run the experiments on all the strategies added to the controller object (ec)

		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
