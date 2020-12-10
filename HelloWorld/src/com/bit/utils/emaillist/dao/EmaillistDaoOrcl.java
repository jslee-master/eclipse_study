package com.bit.utils.emaillist.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bit.utils.emaillist.vo.EmaillistVo;

//	데이터 전송 객체
public class EmaillistDaoOrcl implements EmaillistDao {
	//	데이터베이스 접속 정보
	private static String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String dbuser = "webdb";
	private static String dbpass = "webdb";

	//	접속부는 공통이다 -> 접속 객체를 반환하는 메서드
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			//	드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (Exception e) {
			//	드라이버 못 찾았을 때
			System.err.println("드라이버 로드 실패!");
		}
		
		return conn;
	}
	
	//	SELECT no, last_name, first_name, email, created_at
	//	FROM emaillist ORDER BY created_at DESC
	@Override
	public List<EmaillistVo> getList() {
		//	결과를 반환할 List
		List<EmaillistVo> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//	접속 객체
			conn = getConnection();
			//	질의 수행 객체
			stmt = conn.createStatement();
			String sql = "SELECT no, last_name, first_name, email, created_at FROM emaillist ORDER BY created_at DESC";
			//	질의 수행 결과 객체 생성
			rs = stmt.executeQuery(sql);
			
			//	java.sql 결과 객체 -> DTO의 리스트로 변환
			while(rs.next()) {
				//	변환 작업 수행
				Long no = rs.getLong(1);
				String lastName = rs.getString(2);
				String firstName = rs.getString(3);
				String email = rs.getString(4);
				Date createdAt = rs.getDate(5);
				
				//	DTO 객체 생성
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setLastName(lastName);
				vo.setFirstName(firstName);
				vo.setEmail(email);
				vo.setCreatedAt(createdAt);
				
				//	리스트에 등록
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//	자원 정리
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(EmaillistVo vo) {
		int insertedCount = 0;	//	영향 받은 레코드의 수
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "INSERT INTO emaillist VALUES (seq_emaillist_pk.nextval, ?, ?, ?, sysdate)";
			//	템플릿 쿼리 사용을 위한 PreparedStatement
			pstmt = conn.prepareStatement(sql);	//	실행 계획 준비
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());

			insertedCount = pstmt.executeUpdate();	//	INSERT, UPDATE, DELETE
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertedCount;
	}

	@Override
	public int delete(Long no) {
		int deletedCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "DELETE FROM emaillist WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deletedCount;
	}

	@Override
	public int update(EmaillistVo vo, Long no) {
		//	연습 문제
		int updatedCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "UPDATE emaillist SET last_name = ?, first_name = ?, email = ? WHERE no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setLong(4, no);

			updatedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updatedCount;
	}

}
