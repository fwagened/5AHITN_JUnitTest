import java.sql.Connection;
import java.sql.*;

public class Fraction {


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
         * Add this with other
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor) + (other.dividend * this.divisor), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction substract(Fraction other){
        /**
         * Sub other from this
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor) - (other.dividend * this.divisor), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction multiply(Fraction other){
        /**
         * Multiply other to this
         */
        Fraction newFraction = new Fraction((this.dividend * other.dividend), (this.divisor * other.divisor));
        return newFraction;
    }

    public Fraction divide(Fraction other){
        /**
         * Multiply this by other
         */
        Fraction newFraction = new Fraction((this.dividend * other.divisor), (this.divisor * other.dividend));
        return newFraction;
    }

    public Fraction shorten(){
        /**
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


    //MySQL JDBC Connection
    /**
     * 1) Verbindung zu MySQL (JDBC)
     * 2) Erstellen einer DB
     * 3) Erstellen einer Tabelle (mit einem Feld)
     * 4) Einfügen eines Datnesatzes in der Tabelle
     * 5) Auslesen eines Datensatzes
     */

    static {
        try {
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    Connection connection = null;





}
