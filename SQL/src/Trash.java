

//: io/UsingRandomAccessFile.java


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Trash {

	public static void main(String[] args) throws InterruptedException,
			SQLException, ClassNotFoundException {

		Class.forName("org.mariadb.jdbc.Driver");

		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost/forsun?"
						+ "user=chuk&password=09111981");
		Statement stmt = con.createStatement();

		ResultSet set = stmt.executeQuery("select * from currency");

		while (set.next()) {

			System.out.println(set.getInt("ID") + " " + set.getString("Code")
					+ " " + set.getString("Country"));

		}

	}

} 