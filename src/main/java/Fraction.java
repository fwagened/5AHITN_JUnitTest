public class Fraction {
    //test

    //testing new update

    //neuer versuch



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

    /**

    public Fraction add(Fraction other){
        int n = (this.dividend * other.divisor) + other.dividend;
        int z = (this.divisor * other.dividend);

       return new Fraction(n, z);
    }

    public Fraction subtract(Fraction other){
        int n = (this.dividend * other.divisor) - other.dividend;
        int z = (this.divisor * other.dividend);

        return new Fraction(n, z);
    }

    public Fraction multiply(Fraction other){
       int n = this.dividend * other.dividend;
       int z = this.divisor * other.divisor;

        return new Fraction(n, z);
    }

    public Fraction divide(Fraction other){
       int n = this.dividend * other.divisor;
       int z = this.divisor * other.dividend;

        return new Fraction(n, z);
    }

    public static int gcd(int n, int z) {
        return z == 0 ? n : gcd(z, n % z);
    }

    //public Fraction shorten(){
      //  Fraction fraction = new Fraction(gcd(this.divisor, this.dividend));

        //return fraction;
    //}


     */


    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}
