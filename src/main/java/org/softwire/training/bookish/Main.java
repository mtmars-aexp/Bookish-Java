package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println(System.getenv("DB_NAME"));

        String hostname = "localhost";
        String database = "LibraryDatabase";
        String user = "bookish";
        String password = "bookish!1";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

        //jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        System.out.println("JDBC method...");

        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT Books.BookID, Books.BookName, Authors.FirstName FROM Books JOIN Authors ON Books.AuthorID = Authors.AuthorID ORDER BY BookName ASC");


        ResultObject resultObject;
        List<ResultObject> resultsList = new ArrayList<>();

        getResults(rs, resultsList);

        for(int i = 0; i != resultsList.size(); i++){
            System.out.println(resultsList.get(i).getFirstName());
            System.out.println(resultsList.get(i).getLastName());
            System.out.println(resultsList.get(i).getUserID());
        }


    }

    public static void getResults(ResultSet rs, List<ResultObject> resultsList) throws SQLException {
        while (rs.next()) {

            ResultObject resultObject = new ResultObject();

            resultObject.setUserID(rs.getInt("AuthorID"));
            resultObject.setFirstName(rs.getString("FirstName"));
            resultObject.setLastName(rs.getString("LastName"));

            resultsList.add(resultObject);
        }
    }

    public static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);


        List<Book> bookList = jdbi.withHandle(handle -> { return handle.createQuery("SELECT * FROM Books ORDER BY BookName ASC").mapToBean(Book.class).list(); });

        bookList.stream().forEach(x -> System.out.println(x.getBookName()));


    }
}
