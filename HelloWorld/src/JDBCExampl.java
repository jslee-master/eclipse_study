import java.sql.*;
import java.util.List;

import com.bit.utils.emaillist.dao.EmaillistDao;
import com.bit.utils.emaillist.dao.EmaillistDaoOrcl;
import com.bit.utils.emaillist.vo.EmaillistVo;

//	JDBC를 이용한 데이터베이스 접속 코드
public class JDBCExampl {
	private static String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String dbuser = "webdb";
	private static String dbpass = "webdb";

	public static void main(String[] args) {
//		connectionTest();
//		selectTest();
//		daoSelectTest();
//		daoInsertTest("홍", "길동", "hong@hwalbin.org");
//		daoInsertTest("고", "길동", "gildong@dooly.org");
//		daoDeleteTest(3L);
//		daoUpdateTest("hong@gamil.com", 2L);
		daoUpdateTest("이", "순신", "lss@gamil.com", 2L);
		daoSelectTest();
	}
	//	DAO Update
	private static void daoUpdateTest(String lastName, String firstName, String email, Long no) {
		EmaillistDao dao = new EmaillistDaoOrcl();
		EmaillistVo vo = new EmaillistVo();
		vo.setLastName(lastName);
		vo.setFirstName(firstName);
		vo.setEmail(email);

		int updatedCount = dao.update(vo, no);

		System.out.printf("%d개의 레코드가 수정되었습니다.%n", updatedCount);
	}
	//	DAO Delete
	private static void daoDeleteTest(Long no) {
		EmaillistDao dao = new EmaillistDaoOrcl();
		int deletedCount = dao.delete(no);
		
		System.out.printf("%d개의 레코드가 삭제되었습니다.%n", deletedCount);
	}
	//	DAO Insert
	private static void daoInsertTest(String lastName, 
										String firstName, 
										String email) {
		EmaillistDao dao = new EmaillistDaoOrcl();
		//	저장을 위한 객체 생성
		EmaillistVo vo = new EmaillistVo();
		vo.setLastName(lastName);
		vo.setFirstName(firstName);
		vo.setEmail(email);

		int insertedCount = dao.insert(vo);
		
		System.out.printf("%d개의 레코드가 삽입되었습니다.%n", insertedCount);
	}
	
	//	DAO Select
	private static void daoSelectTest() {
		//	emaillist 테이블로부터 목록을 출력
		EmaillistDao dao = new EmaillistDaoOrcl();
		//	목록 저장을 위한 리스트 생성
		List<EmaillistVo> list = dao.getList();
		
		//	출력
		for (EmaillistVo vo: list) {
			System.out.println(vo);
		}
	}
	//	SELECT
	private static void selectTest() {
		//	webdb.emaillist 테이블에서 목록을 불러와서 출력
		Connection conn = null;
		Statement stmt = null;	//	SQL을 실행하기 위한 객체
		ResultSet rs = null;	//	SELECT의 결과 레코드 셋 객체
		
		try {
			//	드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	커넥션 얻기
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			//	실행 객체 생성
			stmt = conn.createStatement();
			
			String sql = "SELECT no, last_name, first_name, email FROM emaillist";
			//	SQL 실행 후 결과 레코드 셋 얻기
			rs = stmt.executeQuery(sql);
			
//			System.out.println(rs);
			//	순회하면서 레코드 정보를 얻어오기
			while (rs.next()) {
				Integer no = rs.getInt(1);	//	숫자 인덱스 1부터
				String lastName = rs.getString("last_name");	//	컬럼명 인덱스
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				
				System.out.printf("%d: %s%s - %s%n", 
						no, 
						lastName, 
						firstName, 
						email);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//	접속
	private static void connectionTest() {
		Connection conn = null;
		
		try {
			//	드라이버 얻어내고
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	Connection을 받아오기
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			System.out.println("연결 성공");
			System.out.println("연결 객체:" + conn);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 찾지 못했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
