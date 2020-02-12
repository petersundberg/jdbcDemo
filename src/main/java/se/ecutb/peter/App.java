package se.ecutb.peter;

import se.ecutb.peter.data.Database;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Database.getConnection();
    }
}
