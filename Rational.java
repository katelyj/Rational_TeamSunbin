public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
	numerator = 0;
	denominator = 1;
    }

    public Rational(int n, int d) {
	if ( d == 0 ) {
	    System.out.println("Nope.");
	    numerator = 0;
	    denominator = 1;
	}
	else {
	    numerator = n;
	    denominator = d;
	}
    }

    public String toString() {
	return numerator + " / " + denominator;
    }

    public double floatValue() {
	return numerator/(double)denominator;
    }

    public void multiply(Rational s) {
	this.numerator *= s.numerator;
	this.denominator *= s.denominator;
    }

    public void divide(Rational s) {
	this.numerator /= s.numerator;
	this.denominator /= s.denominator;
    }

}
