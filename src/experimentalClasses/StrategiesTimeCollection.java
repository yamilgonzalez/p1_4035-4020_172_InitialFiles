package experimentalClasses;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;

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
    
    public void runTrial(Integer [][][] data) { 
    	strategy.intersectSets(null);
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