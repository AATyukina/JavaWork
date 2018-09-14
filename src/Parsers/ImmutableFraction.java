package Parsers;

public final class ImmutableFraction {
	private final Fraction fr;

	ImmutableFraction(Fraction fr) {
		this.fr = fr.clone();
	}

	public ImmutableFraction add(ImmutableFraction a, ImmutableFraction b) {
		Fraction res;
		Fraction a1 = new Fraction(a.fr.getNom(), a.fr.getDenom());
		Fraction b1 = new Fraction(b.fr.getNom(), b.fr.getDenom());
		res = a1.add(a1, b1);
		return new ImmutableFraction(res);
	}

	public ImmutableFraction deny(ImmutableFraction a, ImmutableFraction b) { 
		Fraction res;
		Fraction a1 = new Fraction(a.fr.getNom(), a.fr.getDenom());
		Fraction b1 = new Fraction(b.fr.getNom(), b.fr.getDenom());
		res = a1.deny(b1, a1);
		return new ImmutableFraction(res);
	}

	public ImmutableFraction multiply(ImmutableFraction a, ImmutableFraction b) {
		Fraction res;
		Fraction a1 = new Fraction(a.fr.getNom(), a.fr.getDenom());
		Fraction b1 = new Fraction(b.fr.getNom(), b.fr.getDenom());
		res = a1.multiply(a1, b1);
		return new ImmutableFraction(res);
	}

	public ImmutableFraction divide(ImmutableFraction a, ImmutableFraction b) {
		Fraction res;
		Fraction a1 = new Fraction(a.fr.getNom(), a.fr.getDenom());
		Fraction b1 = new Fraction(b.fr.getNom(), b.fr.getDenom());
		res = a1.divide(a1, b1);
		return new ImmutableFraction(res);
	}

	public void print() {
		fr.printFraction();
	}
	
	@Override
	public String toString() {
		return fr.toString();
	}
	
	@Override
	public boolean equals(Object item) {
		if (this == item)
			return true;
		if (item == null || getClass() != item.getClass())
			return false;
		if (item instanceof ImmutableFraction) {
			Fraction a1 = new Fraction(((ImmutableFraction) item).fr.getNom(), ((ImmutableFraction) item).fr.getDenom());
			return fr.equals(a1);
		}

		return false;

	}
	
	@Override
	public int hashCode() {
		final int middle = 31;
		int result = 1;
		result = middle * result + fr.getNom();
		result = middle * result + fr.getDenom();
		return result;
	}

	public static void main(String[] args) {
		ImmutableFraction ifr = new ImmutableFraction(new Fraction("4/6"));
		ImmutableFraction ifr1 = ifr.deny(ifr, new ImmutableFraction(new Fraction("1/6")));
		ifr.print();
		ifr1.print();

	}

}
