package Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fraction implements Comparable<Fraction> {
	static Logger logger = Logger.getLogger("FractionLog");
	private int nom;
	private int denom;

	Fraction(String a) { // Конструктор из строки
		if (a.indexOf("/") != -1) {
			nom = Integer.parseInt(a.substring(0, a.indexOf("/")));
			denom = Integer.parseInt(a.substring(a.indexOf("/") + 1));
		} else {
			nom = Integer.parseInt(a);
			denom = 1;
		}
		setLogLevel(Level.WARNING);
		logger.log(Level.INFO, this.toString());
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
	}

	Fraction(int a) {
		nom = a;
		denom = 1;
		this.adjust(0);
		setLogLevel(Level.WARNING);
		logger.log(Level.INFO, this.toString());
	}

	Fraction(int a, int b) { // Конструктор на основе двух чисел
		nom = a;
		denom = b;
		this.adjust(0);
		setLogLevel(Level.WARNING);
		logger.log(Level.INFO, this.toString());
	}

	public void add(Fraction a) { // Сложение с числом
		nom = a.nom * denom + nom * a.denom;
		denom = a.denom * denom;
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
	}

	public Fraction add(Fraction a, Fraction b) {
		nom = a.nom * b.denom + b.nom * a.denom;
		denom = a.denom * b.denom;
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
		return this;
	}

	public Fraction deny(Fraction a, Fraction b) { // Вычитание
		nom = b.nom * a.denom - a.nom * b.denom;
		denom = b.denom * a.denom;
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
		return this;
	}

	public void deny(Fraction a) {
		nom = nom * a.denom - a.nom * denom;
		denom = denom * a.denom;
		logger.log(Level.INFO, this.toString());
		this.adjust(0);
	}

	public Fraction multiply(Fraction a, Fraction b) {
		nom = a.nom * b.nom;
		denom = a.denom * b.denom;
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
		return this;
	}

	public Fraction divide(Fraction a, Fraction b) {
		nom = a.nom * b.denom;
		denom = a.denom * b.nom;
		this.adjust(0);
		logger.log(Level.INFO, this.toString());
		return this;
	}

	private void reduceFr() { // Алгоритм Евклида и упрощение дроби
		int a = nom;
		int b = denom;
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		nom = nom / a;
		denom = denom / a;

	}

	private void adjust(int a) throws java.lang.ArithmeticException {
		if (nom == 0 && denom == 0 || denom == 0) {
			logger.log(Level.INFO, ArithmeticException.class.getName());
			throw new ArithmeticException();
		}
		reduceFr();
		if (denom < 0 && nom < 0 || denom < 0) {
			denom = -1 * denom;
			nom = -1 * nom;
		}
	}

	public void printFraction() { // Печать дроби
		if (nom == denom || denom == 1) {
			System.out.print(nom + "\n");
		} else
			System.out.print(nom + "/" + denom + "\n");
	}

	public String toString() {
		if (denom == 1)
			return String.valueOf(nom);
		return String.valueOf(nom) + "/" + String.valueOf(denom);
	}

	public boolean equals(Object item) {
		if (this == item)
			return true;
		if (item == null || getClass() != item.getClass())
			return false;
		if (item instanceof Fraction) {
			// if ((nom == ((Fraction) item).nom) || ((denom == ((Fraction) item).denom)))
			// return true;
			if (nom * ((Fraction) item).denom == ((Fraction) item).nom * denom)
				return true;
		}

		return false;

	}

	public int hashCode() {
		final int middle = 31;
		int result = 1;
		result = middle * result + nom;
		result = middle * result + denom;
		return result;
	}

	public int compareTo(Fraction p) {

		return p.denom * nom - denom * p.nom;
	}

	public static void sort(Fraction[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j].compareTo(arr[j + 1]) >= 0) {
					Fraction tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	public static void setLogLevel(Level l) {
		logger.setLevel(l);
	}

	public static void main(String[] args) {
		Fraction f2 = new Fraction("5/7");
		Fraction f1 = new Fraction(0, 1);
		// Fraction f3 = null;
		f2 = f2.divide(f2, f1);
	}
}
