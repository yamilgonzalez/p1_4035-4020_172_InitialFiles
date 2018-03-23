package p1MainClasses;

import java.io.FileNotFoundException;

import experimentalClasses.ExperimentController;
import experimentalClasses.StrategiesTimeCollection;
import solutionsP.P1P2solution;
import solutionsP.P3solution;
import solutionsP.P4solution;
/**
 * 
 * @author pedroirivera-vega
 * Modified By
 * @author Maria A. Marrero 802-15-4204 Sec 090
 * @author Yamil J. Gonzalez 802-15-3112 Sec 090
 */
public class Part2Main {
	public static void main (String[] args) throws CloneNotSupportedException, FileNotFoundException {
		int[] parms = {10,50,1000,50000,1000,200};  //default values
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
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2solution("P1")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2solution("P2")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3solution("P3")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4solution("P4")));

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
