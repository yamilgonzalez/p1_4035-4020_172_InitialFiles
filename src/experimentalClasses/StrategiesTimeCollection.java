package experimentalClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class StrategiesTimeCollection<E> 
extends ArrayList<Map.Entry<Integer, Float>> { 
    private IntersectionFinder<E> strategy;    
    private float sum;   

    
    public StrategiesTimeCollection(IntersectionFinder<E> strategy) { 
        this.strategy = strategy; 
    } 
    
    public String getStrategyName() { 
        return strategy.getName(); 
    }
    
    public void runTrial(Object [][][] data) throws FileNotFoundException { 
    	int m = data[0].length;
    	MySet[] t = new MySet[m];

    	for(int j = 0; j < data[0].length ; j++) {
    		t[j] = new Set2();
    		if(getStrategyName().equals("P1")) t[j] = new Set1();
    		for(int i = 0; i < data.length ; i++ )
    			for(int k = 0; k < data[i][j].length; k++){
    				t[j].add(data[i][j][k]);
    			}
    	}
    	//create array of sets as in Part1Main
    	strategy.intersectSets(t);
    }
    
    public void resetSum() { 
    	sum = 0.0f; 
    }
    
    public void incSum(float t) { 
    	sum += t; 
    }
    
    public float getSum() { 
    	return sum; 
    }
    
}