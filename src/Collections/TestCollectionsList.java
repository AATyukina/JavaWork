package Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestCollectionsList {

	public static void main(String[] args) {
		ArrayList<Fraction> alf = new ArrayList<>();
		if (alf.isEmpty()) {
			alf.add(new Fraction("5/7"));
			alf.add(new Fraction("1/3"));
			alf.add(new Fraction("5/7"));
		}
		if (alf.contains(new Fraction("1/3"))) {
			System.out.println("contains");
		}
		alf.set(0, new Fraction("8/9"));
		alf.sort(null);
		while(!alf.isEmpty()) {
			System.out.println(alf.remove(alf.size()-1));
		}
		if (alf.isEmpty()) {
			System.out.println("empty");
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		LinkedList<Fraction> lls = new LinkedList<>();
		int N = 5;
		Fraction frarr[] = new Fraction[N];
		lls.add(new Fraction(4));
		lls.add(new Fraction(7));
		lls.addFirst(new Fraction(25));
		lls.element().printFraction();
		System.out.println("\n");
		lls.toArray(frarr);
		System.out.println("For array:");
		for (int i=0;i<N;i++) {
			System.out.println(frarr[i]);
		}

	}

}
