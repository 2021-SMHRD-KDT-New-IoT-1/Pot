package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	BoardVO bvo = null;
	ArrayList<BoardVO> bal = null;

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

	// 1. 게시글 등록 기능
	public int writeBoard(String title, String content, int mem_num) {
		try {
			connection();

			String sql = "INSERT INTO board VALUES (BOARD_SEQ.NEXTVAL, sysdate+(interval '9' hour), ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, title);
			pst.setString(2, content);
			pst.setInt(3, mem_num);

			System.out.println("게시글 등록: " + title + " " + content + " " + mem_num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("등록 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 02. 게시글 전체 조회 기능
	public ArrayList<BoardVO> listBoard(String mem_num) {
		try {
			bal = new ArrayList<BoardVO>();
			connection();

			int set_mem_num = Integer.parseInt(mem_num);

			String sql = "SELECT * FROM board WHERE mem_num= ? ORDER BY bo_num DESC";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, set_mem_num);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_bo_num = rs.getString(1);
				String get_bo_date = rs.getString(2);
				String get_bo_title = rs.getString(3);
				String get_content = rs.getString(4);
				String get_mem_num = rs.getString(5);

				bvo = new BoardVO(get_bo_num, get_bo_date, get_bo_title, get_content, get_mem_num);
				bal.add(bvo);

				System.out.println("게시글 정보: " + get_bo_num + " " + get_bo_date + " " + get_bo_title + " " + get_content
						+ " " + get_mem_num);
			}

			System.out.println("게시글 조회 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 조회 실패!");
		} finally {
			close();
		}
		return bal;
	}

	// 03. 게시글 수정 기능
	public int updateBoard(String title, String content, int bo_num) {
		try {
			connection();

			String sql = "UPDATE board SET bo_title = ?, bo_content = ? WHERE bo_num = ?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, title);
			pst.setString(2, content);
			pst.setInt(3, bo_num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
