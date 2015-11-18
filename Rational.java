/* Team Sunbin -- Kate Johnston and Shaik Abden
APCS1 pd10
HW33 -- Do You Even Add, Bro?
2015-11-18 */

public class Rational {

    // instance vars

    private int numerator;
    private int denominator;

    // constructors

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

    // methods

    public String toString() {
	return numerator + " / " + denominator;
    }

    public double floatValue() {
	return numerator/(double)denominator;
    }

    public void multiply(Rational s) {
	numerator *= s.numerator;
	denominator *= s.denominator;
    }

    public void divide(Rational s) {
	numerator /= s.numerator;
	denominator /= s.denominator;
    }

    public void add(Rational s) {
	if ( denominator == s.denominator ) {
	    numerator += s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator += s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public void subtract(Rational s) {
	if ( denominator == s.denominator ) {
	    numerator -= s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator -= s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public int gcd(Rational s) {
	return 0;
    }

}
