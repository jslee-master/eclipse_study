package my.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/study?serverTimezone=UTC";

	static final String USERNAME = "user2";
	static final String PASSWORD = "j87s64lee";

	public static void main(String[] args) {

		class Professor{

			String name;
			String belong;
			String phone;
			
			public Professor(String name, String b, String p) {
				this.name = name;
				this.belong = b;
				this.phone = p;
			}
		}

		// Array List
		List<Professor> members;
		members = new ArrayList<Professor>();

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "select * from professor";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String belong = rs.getString("belong");
				String phone = rs.getString("phone");
				
				Professor professor = new Professor(name, belong, phone);
				members.add(professor);
				
				System.out.println("name = "+ name + " " + belong + " " + phone);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Professor p : members) {
			
			System.out.println("Name: " + p.name + " " + p.belong + " " + p.phone);
			
		}

	} // end of main()
	
}
