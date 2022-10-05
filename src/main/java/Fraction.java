public class Fraction {
    //test

    private int dividend = 0;
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

    public Fraction add(Fraction other){
        /**
         * Add this with other
         */
        return null;
    }

    public Fraction subtract(Fraction other){
        /**
         * Subtract this from other
         */
        return null;
    }

    public Fraction multiply(Fraction other){
        /**
         * multiply this from other
         */
        return null;
    }

    public Fraction divide(Fraction other){
        /**
         * divide this from other
         */
        return null;
    }

    public Fraction shorten(){
        /**
         * Shorten this fraction
         */

        return null;
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }
}
