/* Team Australopithecus -- Kate Johnston and Jason Mohabir
APCS1 pd10
HW37 -- Rational Equality
2015-11-25 */

public class Rational {

    // instance vars denominator and numerator store the values of the numerator and denominator in this instance of class Rational

    private int numerator;
    private int denominator;

    // constructors

    //Default constructor creates fraction 0/1, the most basic one
    public Rational() {
	numerator = 0;
	denominator = 1;
    }

    //This overloaded construactor sets the numerator and denominaor to the args specified when making the class
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

    public String toString() { // returns the string representation of the number using a / to represent the fraction
	return numerator + " / " + denominator;
    }

    public double floatValue() { // returns the float representation of the number by dividing the two values and returning the float result
	return numerator/(double)denominator;
    }

    public void multiply(Rational s) { // multiplies numbers by multiplying the individual numerators and denominators of the calling and current classes of Rational
	numerator *= s.numerator;
	denominator *= s.denominator;
    }

    public void divide(Rational s) { // divides the fraction by multiplying the numerator by the denominator of the divsor and vice versa
	numerator *= s.denominator;
	denominator *= s.numerator;
    }

    public void add(Rational s) { // adds fractions. If the denominators are the same it just adds the numerator. In the other case, it multiplies the numerators by the denominators of the other fraction and then adds
	if ( denominator == s.denominator ) {
	    numerator += s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator += s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public void subtract(Rational s) { // Same approach as above but instead you subtract at the end
	if ( denominator == s.denominator ) {
	    numerator -= s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator -= s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public int gcd(){ // finds gcd of numerator and denominator using Euilers method of constantly dividing the larger value by the smaller and restarting. Uses the numerator and denominator in the instance of the class
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

    public static int gcds(int n, int d) { // finds gcd in the same way as above, but instead takes in two args, numerator and denominator instead of using the inst vars.
	int min;
	int max;
	int stor;
	if ((n == 0) || (d == 0)){
	    return 0;
	}
	else {
	    if ( n >= d ) {
		max = n;
		min = d;
	    }
	    else {
		max = d;
		min = n;
	    }
	    while (min != 0){
	        stor = min;
		min = max % min;
		max = stor;
	    }
	    return max;
	}
    }


    public void reduce() { // reduces fraction to simplest form by dividng the numerator and denominator by the result of gcd()
	int g = this.gcd();
	if ( g != 0 ) {
	    numerator /= g;
	    denominator /= g;
	}
    }

    public int compareTo(Rational r) { // compares numbers, returning 0 if equal, 1 if the current fraction is greater than the other fraction, and -1 when it is less.
        int a = this.numerator * r.denominator;
	int b = r.numerator * this.denominator;
	if ( a == b ) {
	    return 0;
	}
	else if ( a > b ) {
	    return 1;
	}
	else {
	    return -1;
	}
    }

    public boolean equals(Rational r) {
        boolean retVal = this == r; // checks for aliasing
	this.reduce();
	r.reduce();
	if ( !retVal ) {
	    retVal = r instanceof Rational
		&& this.numerator == r.numerator
		&& this.denominator == r.denominator;
	}
	return retVal;
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
	System.out.println(d.compareTo(e));

	Rational f = new Rational(5,6);
	Rational g = new Rational(9,10);
	f.add(g);
	f.reduce();
	System.out.println(f);
	g.subtract(f);
	g.reduce();
	System.out.println(g);
	System.out.println(g.compareTo(f));

	Rational h = new Rational(1,2);
	Rational i = new Rational(2,4);
	System.out.println(h.equals(i));

	System.out.println(gcds(5,6));
        System.out.println(gcds(10,5));
	System.out.println(gcds(100,6));
	
    }

}
