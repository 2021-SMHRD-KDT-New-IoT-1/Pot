package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	boolean check = false;

	// 0. 자체 기능 (메서드)
	public void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_2_1025";
			String password = "smhrd2";
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("----------");
			e.printStackTrace();
			System.out.println("연결실패...");
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// 1. 회원가입 기능(메서드)
	public int join(String email, String pw, String tel, String nick) {

		try {
			connection();

			String sql = "INSERT INTO pot_member VALUES (MEM_SEQ.NEXTVAL, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, nick);
			pst.setString(4, tel);
			
			System.out.println(email + " " + pw + " " +  " " + nick + " " + tel);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("가입실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 2. 로그인 기능(메서드)
	public MemberVO login(String email, String pw) {

		try {
			connection();

			String sql = "SELECT email, tel, nick, mem_num FROM pot_member WHERE email = ? AND pw = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, email);
			pst.setString(2, pw);

			rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("로그인 성공!");
				
				String get_email = rs.getString(1);
				String get_tel = rs.getString(2);
				String get_nick = rs.getString(3);
				String get_mem_num = rs.getString(4);

				vo = new MemberVO(get_email, get_tel, get_nick, get_mem_num);

			} else {
				System.out.println("로그인 실패!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패!");
		} finally {
			close();
		}
		return vo;
	}

	// 3. 수정 기능
	public int update(String email, String pw, String tel, String nick) {
		try {
			connection();

			String sql = "UPDATE POT_MEMBER SET pw = ?, tel = ?, nick = ? WHERE email = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, pw);
			pst.setString(2, tel);
			pst.setString(3, nick);
			pst.setString(4, email);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	// 4. 회원 검색 기능
	public ArrayList<MemberVO> selectAll() {
		al = new ArrayList<MemberVO>();
		
		try {
			connection();

			String sql = "SELECT email, tel, address FROM WEB_member";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				String get_email = rs.getString(1);
				String get_tel = rs.getString(2);
				String get_address = rs.getString(3);

				vo = new MemberVO(get_email, get_tel, get_address);
				
				al.add(vo);
			} 
			System.out.println("조회 성공!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패!");
		} finally {
			close();
		}
		
		return al;	
	}
	
	// 5. 회원 삭제 기능
	public int delete(String email) {
		try {
			connection();

			String sql = "DELETE FROM WEB_member WHERE email = ? ";
			pst = conn.prepareStatement(sql);

			pst.setString(1, email);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}
	
	// 6. 회원 아이디 중복 체크 기능
	public boolean idCheck(String email) {
		try {
			connection();
			
			String sql = "SELECT email FROM pot_member WHERE email = ? ";
			pst = conn.prepareStatement(sql);

			pst.setString(1, email);

			rs = pst.executeQuery();

			if (rs.next()) {
				// 입력한 이메일을 사용할 수 없을때
				check = true;
			} else {
				// 입력한 이메일을 사용할 수 있을때
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("중복 체크 실패!");
		} finally {
			close();
		}
		
		return check;
	}
	
}
