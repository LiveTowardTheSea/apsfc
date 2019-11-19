package dao;
/*
 * DAO层的每个操作只负责自己本身的工作
 * 不需要做判断是否允许修改或者允许添加
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Types;
import util.DBUtil;

public class TypesDao {
	// 添加将types对象中的数据添加进数据库
	public int add(Types type) {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "insert into types(name) values(?)";

		// 创建preparedstatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, type.getName());
			// 发送sql语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	// 删除id为id的项目
	public int delete(int id) {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "delete from types where id = ?";

		// 创建preparedstatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, id);
			// 发送sql语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return result;
	}

	// 修改 把id为id的项目的name修改为name
	public int update(int id, String name) {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "update types set name = ? where id = ?";

		// 创建preparedstatement
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			// 发送sql语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return result;
	}

	// 查询所有
	public ArrayList<Types> findAll() {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "select * from types";

		// 创建preparedstatement 用于接收结果的rset以及返回结果的list
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Types> list = new ArrayList<Types>();
		try {
			pstmt = conn.prepareStatement(sql);
			// 发送sql语句得到结果
			rSet = pstmt.executeQuery();
			// 处理结果
			while (rSet.next()) {
				Types type = new Types();
				type.setId(rSet.getInt(1));
				type.setName(rSet.getString(2));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return list;
	}

	// 根据id查询
	public Types findById(int id) {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "select * from types where id = ?";

		// 创建preparedstatement 用于接收结果的rset以及返回结果的list
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Types type = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, id);
			// 发送sql语句得到结果
			rSet = pstmt.executeQuery();
			// 处理结果
			if (rSet.next()) {
				type = new Types();
				type.setId(rSet.getInt(1));
				type.setName(rSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return type;
	}

	// 根据内容查询
	public Types findByName(String name) {
		// 创建连接
		Connection conn = DBUtil.getConn();

		// 创建sql语句
		String sql = "select * from types where name = ?";

		// 创建preparedstatement 用于接收结果的rset以及返回结果的list
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Types type = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, name);
			// 发送sql语句得到结果
			rSet = pstmt.executeQuery();
			// 处理结果
			if (rSet.next()) {
				type = new Types();
				type.setId(rSet.getInt(1));
				type.setName(rSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return type;
	}
}
