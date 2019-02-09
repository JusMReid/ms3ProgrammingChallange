package ms3ProgrammingChallenge;

import java.sql.*;

/*This class is responsible for handling the 
 * connection to the SQLite Database*/

public class ConnToDB {

	public static void connect() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");

		Connection conn = null;

		// The name of the Database
		//String dbName = "jdbc:sqlite:ms3.db";

		// Create Table Statement
		String createTable = "Create Table Customers " + "(A VARCHAR(20)," + "B VARCHAR(20)," + "C VARCHAR(40),"
				+ "D ENUM('Male','Female')," + "E TEXT," + "F VARCHAR(30)," + "G DOUBLE(8,2)," + "H BOOLEAN,"
				+ "I BOOLEAN," + "J VARCHAR(255))";

		// Insert query
		//String insertQuery = "insert into Customers" + "(A, B, C, D, E, F, G, H, I, J)";

		try {
			// create an in-memory database connection
			conn = DriverManager.getConnection("jdbc:sqlite::memory:");

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// Drop the Table if it already exists
			statement.executeUpdate("DROP TABLE IF EXISTS Customers");

			// Create Customers Table
			statement.executeUpdate(createTable);

			// ResultSet resultSet = statement.executeQuery("SELECT * from Customer");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) { // Use SQLException class instead.
				System.err.println(e);
			}
		}
		
		
	}
}
