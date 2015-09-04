import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlExecute {

	private Statement stmt;
	private Integer ID = 1;

	public MySqlExecute() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/forsun?"
					+ "user=chuk&password=09111981");
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showData() {

		ResultSet set;
		try {
			set = stmt.executeQuery("select * from currency");

			while (set.next()) {

				System.out.println(set.getInt("ID") + " "
						+ set.getString("Code") + " "
						+ set.getString("Country"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addCountry(String data) {

		try {

			stmt.executeUpdate("INSERT INTO currency (ID,country)VALUES (" + ID
					+ ",'" + data + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addCode(String data) {

		try {

			stmt.executeUpdate("update currency set Code='" + data
					+ "' where ID=" + ID);
			ID++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
