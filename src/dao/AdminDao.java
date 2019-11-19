package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Admin;
import util.DBUtil;

public class AdminDao {
	//查询
	public Admin findByNameAndPwd(String name, String pwd) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from admin where name=? and pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Admin admin = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				admin = new Admin(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return admin;
	}
	
	public Admin findByName(String name) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from admin where name=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Admin admin = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				admin = new Admin(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return admin;
	}
	
	//修改
	public int update(int id, Admin admin) {
		Connection conn = DBUtil.getConn();
		String sql = "update admin set name=?, pwd=? where id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getPwd());
			pstmt.setInt(3, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	
}
