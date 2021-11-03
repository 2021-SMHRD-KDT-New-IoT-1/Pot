package arduinosensor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_2_1025";
			String db_pw = "smhrd2";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public SensorVO update(int mysensor) {
		SensorVO vo = null;
		conn();
		String sql1 = "update PT_HUMIDITY set HUMIDITY = ?";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, mysensor);
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		vo = getSensor();
		return vo;
	}
	
	public SensorVO getSensor() {
		SensorVO vo = null;
		conn();
		String sql = "select HUMIDITY from PT_HUMIDITY";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				int mysensor = rs.getInt(1);
				vo = new SensorVO(mysensor);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
}
