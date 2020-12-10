package dbmanager;

import java.util.Scanner;

//import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class CRUD {

	public static void main(String[] args) {
		
//		C();
//		R();
//		U();
		
//		OracleDataSource ods = null;	
		// 오라클과 연결에 필요한 기본정보를 설정하는데 사용됨. 기본정보는 오라클 접속 방법 및 주소, 사용자 계정, 사용자 비밀번호 등이 있다.
		
		Connection conn = null;			
		// ods로 설정된 정보를 이용하여 오라클과 실제로 연결을 설정하는데 사용된다. ods에 설정된 오라클 접속 방법 및 주소, 
		// 사용자 계정, 비밀번호 등을 이용하여 연결하고 그 정보가 con 변수에 저장된다. con 변수를 이용하여 SQL문을 실행시킬 수 있다.
		
		Statement stmt = null;
		// stmt는 연결된 오라클에 SQL문을 실행시키기 위해 사용된다.
		
		ResultSet rs = null;
		// stmt 변수를 이용하여 실행시킬 수 있는 SQL문들 중에서 select문의 실행 결과는 Result-Set으로 선언된 변수인 rs에 전달되어 저장된다.
		// rs 변수를 이용하면 select 문의 실행 결과를 프로그램에서 다룰 수 있게 된다.
		
		String url = "jdbc:oracle:thin:@localhost:1521/orcl"; 
		// oracle developer에서 DB의 URL
		
		String user = "ljs";		// DB 사용자명
		String password = "1234";	// 비밀 번호

		try {
//			ods = new OracleDataSource();
//			ods.setURL(url);
//			ods.setUser(user);
//			ods.setPassword(password);
//			conn = ods.getConnection();
//			stmt = conn.createStatement();
			
			// CRUD 모듈 결과가 String형의 쿼리문을 리턴
			
			//////////////////////////////////////
			// 쿼리문을 만들어서 String형 result 에다가 대입

			System.out.print("필드명: ");
			String fieldscan = (new Scanner(System.in)).next();
			System.out.print("삭제할 값: ");
			String deletescan = (new Scanner(System.in)).next();
			
			String result = "DELETE FROM EMP WHERE "+ fieldscan +"='" + deletescan + "'"; // 결과값
//			String result = "SELECT * FROM EMP"; // 결과값
			stmt.executeQuery(result);
			
			rs = stmt.executeQuery("SELECT * FROM EMP");
			System.out.println("NAME\tAGE\tSALARY");
			while (rs.next()) {
				String name = rs.getString(1);	// VARCHAR2 는 String
				int age = rs.getInt(2);			// NUMBER 는 int
				int salary = rs.getInt(3);		// NUMBER 는 int
				System.out.println(name + "\t" + age + "\t" + salary);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		}

		
		
//		INSERT INTO emp27 VALUES ('호랑이',20); --CRUD중 C
//		SELECT * FROM emp27; --CRUD중 R
//		UPDATE emp27 SET age='30' WHERE name='호랑이'; --new update
//		DELETE FROM emp27 WHERE name='호랑이'; --Delete
		
	}

	private static String d() {
		System.out.print("지울 이름: ");
		String namescan = (new Scanner(System.in)).next();
//		System.out.println("DELETE FROM EMP WHERE name='" + namescan + "'");
		return namescan;
	}

	private static void U() {
		System.out.print("갱신 이름: "); //이름으로 찾아서 나이나 급여 바꾸기?
		String namescan = (new Scanner(System.in)).next();
		System.out.print("바꾸려는 필드명: ");
		String scan = (new Scanner(System.in)).next();
		System.out.print("바꾸려는 수: ");
		int agescan = (new Scanner(System.in)).nextInt();
		System.out.println("UPDATE emp SET age='30' WHERE name='호랑이';");
	}

	private static void R() {
		System.out.println("SELECT * FROM emp;");
	}

	private static void C() {
		System.out.print("이름 입력: ");
		String namescan = (new Scanner(System.in)).next();
		System.out.print("나이 입력: ");
		int agescan = (new Scanner(System.in)).nextInt();
		System.out.print("급여 입력: ");
		int salaryscan = (new Scanner(System.in)).nextInt();
		System.out.println("INSERT INTO emp VALUES ('" + namescan + "'," + agescan +"," + salaryscan + ");");
	}

}
