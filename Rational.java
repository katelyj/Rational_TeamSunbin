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

    public String toString() { // returns the string representation of the number
	return numerator + " / " + denominator;
    }

    public double floatValue() { // returns the float representation of the number
	return numerator/(double)denominator;
    }

    public void multiply(Rational s) { // multiplies numbers
	numerator *= s.numerator;
	denominator *= s.denominator;
    }

    public void divide(Rational s) { // divides numbers
	numerator /= s.numerator;
	denominator /= s.denominator;
    }

    public void add(Rational s) { // adds numbers
	if ( denominator == s.denominator ) {
	    numerator += s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator += s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public void subtract(Rational s) { // subtracts numbers
	if ( denominator == s.denominator ) {
	    numerator -= s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator -= s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public int gcd(){ // finds greatest common denominator of number
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

    public void reduce() { // reduces fraction to simplest form
	int g = this.gcd();
	if ( g != 0 ) {
	    numerator /= g;
	    denominator /= g;
	}
    }

    public static void main( String[] args ) { // main method

	// testing!
	
	Rational a = new Rational(6,8);
	System.out.println(a.floatValue());
	System.out.println(a.gcd());
	a.reduce();
	System.out.println(a);
	
	Rational b = new Rational(5,5);
	System.out.println(b.floatValue());
	System.out.println(b.gcd());
	b.reduce();
	System.out.println(b);

	Rational c = new Rational(13,11);
	System.out.println(c.gcd());
	c.reduce();
	System.out.println(c);

	Rational d = new Rational(1,2);
	Rational e = new Rational(3,2);
	d.add(e);
	System.out.println(d);
	e.subtract(d);
	System.out.println(e);

	Rational f = new Rational(5,6);
	Rational g = new Rational(9,10);
	f.add(g);
	f.reduce();
	System.out.println(f);
	g.subtract(f);
	g.reduce();
	System.out.println(g);
	
    }

}
