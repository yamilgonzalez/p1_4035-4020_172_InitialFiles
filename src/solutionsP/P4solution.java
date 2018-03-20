package solutionsP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P4solution<E> extends AbstractIntersectionFinder<E> {

	public P4solution(String name) {super(name);}

	@Override
	public MySet intersectSets(MySet[] t) {
		ArrayList<E> allElements = new ArrayList<E>();
		Integer m = t.length;
		for(int i= 0 ; i<m ; i++){
			for (Object x : t[i]){
				allElements.add((E) x);
			}
		}

		HashMap<E, Integer> map = new HashMap<>(); 
		for (E e : allElements) { 
			Integer c = map.getOrDefault(e, 0); 
			map.put(e, c+1); 
		}
		MySet<E> T = new Set2<>(); 
		for (Map.Entry<E, Integer> entry : map.entrySet())
			if (entry.getValue() == m) 
				T.add(entry.getKey()); 
		return T;
	}
}