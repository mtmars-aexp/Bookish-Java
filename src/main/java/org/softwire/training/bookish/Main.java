package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "LibraryDatabase";
        String user = "bookish";
        String password = "bookish!1";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

        jdbcMethod(connectionString);
        //jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Library");
        rs.next();
        rs.next();
        System.out.println(rs.getString("LibraryID"));
        String outPut = rs.getString(1);



    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);



    }
}
