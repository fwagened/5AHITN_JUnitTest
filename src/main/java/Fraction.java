public class Fraction {
    //test

    //testing new update

    //neuer versuch

    //letzter versuch


    private int dividend = 1;
    private int divisor = 1;

    public Fraction(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }


    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public Fraction add(Fraction other) {
        /**
         * @ToDo
         * Add this with other
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor) + (other.dividend * this.divisor), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction substract(Fraction other){
        /**
         * @ToDO
         * Sub other from this
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor) - (other.dividend * this.divisor), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction multiply(Fraction other){
        /**
         * @ToDO
         * Multiply other to this
         */
        Fraction newFraction = new Fraction((this.dividend * other.dividend), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction divide(Fraction other){
        /**
         * @ToDO
         * Multiply this by other
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor), (this.divisor * other.dividend));
        return newFraction;
    }

    public Fraction shorten(){
        /**
         * @ToDO
         * Shorten the fraction
         */
        int gcd = gcd(this.dividend, this.divisor);
        Fraction newFraction = new Fraction((this.dividend / gcd), (this.divisor / gcd));
        return newFraction;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}
