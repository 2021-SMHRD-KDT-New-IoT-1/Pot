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

	// 0. ��ü ��� (�޼���)
	public void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_2_1025";
			String password = "smhrd2";
			System.out.println("jdbc driver �ε� ����");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("----------");
			e.printStackTrace();
			System.out.println("�������...");
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

	// 1. ȸ������ ���(�޼���)
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
			System.out.println("���Խ���");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 2. �α��� ���(�޼���)
	public MemberVO login(String email, String pw) {

		try {
			connection();

			String sql = "SELECT email, tel, nick, mem_num FROM pot_member WHERE email = ? AND pw = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, email);
			pst.setString(2, pw);

			rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("�α��� ����!");
				
				String get_email = rs.getString(1);
				String get_tel = rs.getString(2);
				String get_nick = rs.getString(3);
				String get_mem_num = rs.getString(4);

				vo = new MemberVO(get_email, get_tel, get_nick, get_mem_num);

			} else {
				System.out.println("�α��� ����!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�α��� ����!");
		} finally {
			close();
		}
		return vo;
	}

	// 3. ���� ���
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
	
	// 4. ȸ�� �˻� ���
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
			System.out.println("��ȸ ����!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�α��� ����!");
		} finally {
			close();
		}
		
		return al;	
	}
	
	// 5. ȸ�� ���� ���
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
	
	// 6. ȸ�� ���̵� �ߺ� üũ ���
	public boolean idCheck(String email) {
		try {
			connection();
			
			String sql = "SELECT email FROM pot_member WHERE email = ? ";
			pst = conn.prepareStatement(sql);

			pst.setString(1, email);

			rs = pst.executeQuery();

			if (rs.next()) {
				// �Է��� �̸����� ����� �� ������
				check = true;
			} else {
				// �Է��� �̸����� ����� �� ������
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ߺ� üũ ����!");
		} finally {
			close();
		}
		
		return check;
	}
	
}
