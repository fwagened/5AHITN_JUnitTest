import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


class FractionTest {
    /**static Database db;

    @BeforeAll
    static void initDbc(){
        try{
            db = Database.getInstance();
        } catch (SQLException e){

        }
    }
    */

    public static Connection connect(String db) throws SQLException {
        Connection conn = null;

        if (db.length() <= 0) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

        } else {
            conn = DriverManager.getConnection("jdbc.mysql://localhost:3306/" + db, "root", "root");
        }

        return conn;
    }

    @Test
    @Order(1)
    void connectToDatabase() {
        Assertions.assertDoesNotThrow(() -> connect(""));
    }

    @Test
    @Order(2)
    void createDatabase(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect(" ");
            Statement s = c.createStatement();
            s.executeUpdate("CREATE DATABASE testdb");

            s.close();
            c.close();

        });
    }


    //@Test
    //@BeforeAll --> damit die darunterstehenden Zeilen als erster getestet werden

    //@Order(1) --> Nummerierung der auszuführenden tests


    @Test
    void getDividend() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals(1, f.getDividend());
    }

    @Test
    void setDividend() {
        Fraction f = new Fraction(1, 10);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());
    }

    @Test
    void getDivisor() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals(10, f.getDivisor());
    }

    @Test
    void setDivisor() {
        Fraction f = new Fraction(1, 10);
        f.setDivisor(20);

        Assertions.assertEquals(20, f.getDivisor());
    }


    @Test
    void testToString() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals("1 / 10", f.toString());
    }
}