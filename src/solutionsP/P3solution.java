package solutionsP;

import java.util.ArrayList;
import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;
/**
 * 
 * @author Maria A Marrero
 *
 */
public class P3solution<E> extends AbstractIntersectionFinder<E> {

	public P3solution(String name) {super(name);}

	
	@Override
	public MySet intersectSets(MySet[] t) {
		ArrayList<E> allElements = new ArrayList<E>();
		Integer m = t.length;
		for(int i= 0 ; i<m ; i++){			 // Constructs the multi-set
			for (Object x : t[i]){
				allElements.add((E) x);
			}
		}
		
		allElements.sort(null); 		
		MySet<E> T = new Set2<E>();   		
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {   //Counts how many times a number appears in allElements
		    if (allElements.get(i).equals(e)) 			 
		       c++;
		    else { 
		       if (c == m) 
		          T.add(e);    
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == m)
		    T.add(allElements.get(allElements.size()-1)); //If the number appears m times, is added to the final set

		return T;
	}
	
}

