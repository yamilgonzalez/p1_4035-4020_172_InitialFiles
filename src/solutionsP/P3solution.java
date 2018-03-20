package solutionsP;

import java.util.ArrayList;
import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3solution<E> extends AbstractIntersectionFinder<E> {

	public P3solution(String name) {super(name);}

	@Override
	public MySet intersectSets(MySet[] t) {
		ArrayList<E> allElements = new ArrayList<E>();
		Integer m = t.length;
		for(int i= 0 ; i<m ; i++){
			for (Object x : t[i]){
				allElements.add((E) x);
			}
		}
		
		allElements.sort(null);		
		MySet<E> T = new Set2();  // sets in P3's solution are of type Set2
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == m) 
		          T.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == m)
		    T.add(allElements.get(allElements.size()-1));

		return T;
	}
	
}

