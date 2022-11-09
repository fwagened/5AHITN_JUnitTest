import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.sql.*;


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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, "root", "root");
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
            s.executeUpdate("CREATE DATABASE databasedb");

            s.close();
            c.close();

        });
    }

    @Test
    @Order(3)
    void connectToSpecificDatabase(){
        Assertions.assertDoesNotThrow(() -> connect("testdb"));
    }

    @Test
    @Order(4)
    void createTable(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");

            Statement s = c.createStatement();
            s.executeUpdate("CREATE TABLE testTable (mycolumn VARCHAR(255) NULL)");

            s.close();
            c.close();

        });
    }

    @Test
    @Order(5)
    void insertIntoTable(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");
            Statement s = c.createStatement();
            s.executeUpdate("INSERT INTO testTable (mycolumn) VALUES (some text )");

            s.close();
            c.close();

        });
    }

    @Test
    @Order(6)
    void selectFromTable(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");

            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM testTable LIMIT 1");

            if (res.first()) {
                Assertions.assertEquals(res.getString("mycolumn"), "some text");
            }

            s.close();
            c.close();

        });
    }

    @Test
    @Order(7)
    void deleteFromTable(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect(" ");

            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("DELETE FROM testTable WHERE (mycolumn = 'some text')");

            if (res.first()) {
                Assertions.assertEquals(res.getString(" "), " ");
            }

            s.close();
            c.close();

        });
    }

    @Test
    @Order(8)
    void dropTable(){
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect(" ");

            Statement s = c.createStatement();
            ResultSet res = s.executeQuery("DROP TABLE testTable");

            if (res.first()) {
                Assertions.assertEquals(res.getString(" "), " ");
            }

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