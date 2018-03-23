package solutionsP;

import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

/**
 * @author Maria A. Marrero 802-15-4204 Sec 090
 * @author Yamil J. Gonzalez 802-15-3112 Sec 090
 */

public class P1P2solution<E> extends AbstractIntersectionFinder {

	public P1P2solution(String name) {super(name);} 

	@Override
	public MySet intersectSets(MySet[] t) {
		MySet T;
		if (getName().equals("P1"))         //Checks strategy selected by user and constructs
			T = (Set1<E>) t[0];			   //The required set
		else 
			T = (Set2<E>) t[0];


		for(int i = 1 ; i<t.length ; i++) {
			Iterator<Object> setIter = T.iterator(); 
			while(setIter.hasNext()) {
				if (!t[i].contains(setIter.next())) 
					setIter.remove();
			}
		}
		return T;	
	}
}