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

    public int gcd(){
	int min;
	int max;
	int stor;
	if ((numerator == 0) || (denominator == 0)){
	    return 0;
	}
	else {
	    if ( numerator >= denominator ) {
		max = numerator;
		min = denominator;
	    }
	    else {
		max = denominator;
		min = numerator;
	    }
	    while (min != 0){
	        stor = min;
		min = max % min;
		max = stor;
	    }
	    return max;
	}
    }

    public void reduce() {
	int g = this.gcd();
	if ( g != 0 ) {
	    numerator /= g;
	    denominator /= g;
	}
    }

    public static void main( String[] args ) {

	// testing!
	
	Rational a = new Rational(6,8);
	System.out.println(a.gcd());
	a.reduce();
	System.out.println(a);
	
	Rational b = new Rational(5,5);
	System.out.println(b.gcd());
	b.reduce();
	System.out.println(b);

	Rational c = new Rational(13,11);
	System.out.println(c.gcd());
	c.reduce();
	System.out.println(c);
	
    }

}
