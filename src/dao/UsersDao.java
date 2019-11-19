package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Users;
import util.DBUtil;

public class UsersDao {
	
	public int add(Users user) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into users(name,pwd,realname,sex,age,card,address,phone,email,code,type) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getRealname());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getAge());
			pstmt.setString(6, user.getCard());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getEmail());
			pstmt.setString(10, user.getCode());
			pstmt.setString(11, user.getType());
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	public int update(int id, Users user) {
		Connection conn = DBUtil.getConn();
		String sql = "update users set pwd=?,realname=?,age=?,card=?,address=?,phone=?,email=?,code=? where id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getRealname());
			pstmt.setString(3, user.getAge());
			pstmt.setString(4, user.getCard());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getCode());
			pstmt.setInt(9, id);
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	public Users findUserByNameAndPwd(String name, String pwd) {
		//建立连接
		Connection conn = DBUtil.getConn();
		//准备SQL语句
		String sql = "select * from users where name=? and pwd=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Users user = null;
		try {
			//获取pstmt
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rSet = pstmt.executeQuery();
			//处理结果
			if (rSet.next()) {
				user = new Users(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9),
						rSet.getString(10), rSet.getString(11), rSet.getString(12));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
	
	public Users findUserById(int id) {
		//建立连接
		Connection conn = DBUtil.getConn();
		//准备SQL语句
		String sql = "select * from users where id=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Users user = null;
		try {
			//获取pstmt
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			//处理结果
			if (rSet.next()) {
				user = new Users(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9),
						rSet.getString(10), rSet.getString(11), rSet.getString(12));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
	
	public Users findUserByName(String name) {
		//建立连接
		Connection conn = DBUtil.getConn();
		//准备SQL语句
		String sql = "select * from users where name=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Users user = null;
		try {
			//获取pstmt
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, name);
			rSet = pstmt.executeQuery();
			//处理结果
			if (rSet.next()) {
				user = new Users(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9),
						rSet.getString(10), rSet.getString(11), rSet.getString(12));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
}
