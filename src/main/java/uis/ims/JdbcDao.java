package uis.ims;

import java.sql.*;


import org.apache.derby.jdbc.EmbeddedDriver;
import uis.ims.dbschema.DBTables;
import uis.ims.models.Item;

public class JdbcDao {

    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:derby:resources/uis.ims/database/imsDB;create=true";
    private static final String INSERT_QUERY = "INSERT INTO registration (full_name, email_id, password) VALUES (?, ?, ?)";

    private Connection sqlConn;

    public JdbcDao (){
        try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            this.sqlConn = DriverManager
                    .getConnection(DATABASE_URL);

           // createTables();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

  //  public void createTables() throws SQLException {
//
  //      // Step 1: Establishing a Connection and
  //      // try-with-resource statement will auto close the connection.
  //      try {
  //          Connection connection = this.sqlConn;
//
  //           // Step 2:Create a statement using connection object
  //           PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
//
  //          for (String tableName : DBTables.TABLE_NAMES) {
  //              if (!doesTableExist(tableName, connection)) {
  //                  Statement createTableQuery = DBTables
  //              }
  //          }
//
  //          System.out.println(preparedStatement);
  //          // Step 3: Execute the query or update query
  //          preparedStatement.executeUpdate();
  //      } catch (SQLException e) {
  //          // print SQL exception information
  //          printSQLException(e);
  //      }
  //  }

    public void insertRecord(String fullName, String emailId, String password) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL);

             // Step 2:Create a statement using connection object
             // PreparedStatement preparedCreateStatement = connection.prepareStatement(CREATE_QUERY));
            //preparedCreateStatement.execute();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, emailId);
            preparedStatement.setString(3, password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private static boolean doesTableExist(String tableName, Connection connection) throws SQLException{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, null, tableName.toLowerCase(),null);
        return result.next();
    }

    public void insertItem(Item item){

    }
}