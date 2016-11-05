import java.sql.*;

public class DBTest {
	public static void main(String[] args) {
		final String QUERY = "select empId, lastName, firstName, homePhone, " + "salary from employee";

	try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost/s2emp","river","mucis");
		PreparedStatement stmt = con.prepareStatement(QUERY)) {

		System.out.println(stmt.toString());

		ResultSet rs = stmt.executeQuery(QUERY);

		while (rs.next()) {
			System.out.println(
				rs.getInt("empId") + ", " +
				rs.getString("lastName") + ", " +
				rs.getString("firstName") + ", " + 
				rs.getString("homePhone") + ", " + 
				rs.getDouble("salary"));
		}
	} catch (SQLException ex) {
		System.out.println("retrieve SQLException: " + ex.getMessage());
	}
    }
}
