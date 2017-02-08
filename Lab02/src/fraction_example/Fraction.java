package fraction_example;
public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction add(Fraction other) {
		int newNumer = numerator * other.denominator + denominator * other.numerator;
		int newDenom = denominator * other.denominator;
		return new Fraction(newNumer, newDenom).simplify();
	}

	public Fraction subtract(Fraction other) {
		int newNumer = numerator * other.denominator - denominator * other.numerator;
		int newDenom = denominator * other.denominator;
		return new Fraction(newNumer, newDenom).simplify();
	}
	
	public Fraction multiply(Fraction other) {
		int newNumer = numerator * other.numerator;
		int newDenom = denominator * other.denominator;
		return new Fraction(newNumer, newDenom).simplify();
	}
	
	public Fraction divide(Fraction other) {
		int newNumer = numerator * other.denominator;
		int newDenom = denominator * other.numerator;
		return new Fraction(newNumer, newDenom).simplify();
	}

	public Fraction simplify() {
		int gcd = gcd(numerator, denominator);
		return new Fraction(numerator/gcd, denominator/gcd);
	}

	private int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Fraction))
			return false;
		Fraction temp1 = this.simplify();
		Fraction temp2 = ((Fraction)other).simplify();
		return temp1.numerator == temp2.numerator && temp1.denominator == temp2.denominator;
	}
	
	@Override
	public String toString() {
		return denominator == 1 ? ("" + numerator): ("" + numerator + " / " + denominator);
	}
	
	public double toValue() {
		if (denominator == 0)
			throw new ArithmeticException("Denominator is zero");
		return (double)numerator/denominator;
	}

	
	
	
	
	
	
	
	
	
	
}
