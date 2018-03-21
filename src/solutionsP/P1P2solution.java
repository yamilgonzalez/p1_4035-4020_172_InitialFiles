package solutionsP;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1P2solution<E> extends AbstractIntersectionFinder {

	public P1P2solution(String name) {super(name);}

	@Override
	public MySet intersectSets(MySet[] t) {
		MySet T;
		if (getName().equals("1")) {
			T = (Set1<E>) t[0];
			for(int i = 1 ; i<t.length ; i++) {
				for (Object x : T) {
					if (!t[i].contains(x)) {
						T.remove(x);
					}
				}
			}
			return T;
		}
		else if (getName().equals("2")) {
			T = (Set2<E>) t[0];
			for(int i = 1 ; i<t.length ; i++) {
				for (Object x : T) {
					if(!t[i].contains(x)) {
						T.remove(x);
					}
				}
			}
			return T;
		}
		return null;		
	}
}