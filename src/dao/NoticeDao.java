package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Notice;
import util.DBUtil;

public class NoticeDao {
	// 增加
	public int add(Notice notice) {
		// 获取连接 准备SQL语句 preparedstatement
		Connection conn = DBUtil.getConn();
		String sql = "insert into notice(name, content, times) values(?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getName());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getTimes());
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

	// 删除
	public int delete(int id) {
		// 获取连接 准备SQL语句 preparedstatement
		Connection conn = DBUtil.getConn();
		String sql = "delete from notice where id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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

	// 查询所有
	public ArrayList<Notice> findAll() {
		// 获取连接 准备SQL语句 preparedstatement
		Connection conn = DBUtil.getConn();
		String sql = "select * from notice order by times desc";
		PreparedStatement pstmt = null;
		ArrayList<Notice> noticeList = new ArrayList<>();
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				Notice notice = new Notice(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		
		return noticeList;
	}
	
	public Notice findById(int id) {
		// 获取连接 准备SQL语句 preparedstatement
		Connection conn = DBUtil.getConn();
		String sql = "select * from notice where id=?";
		PreparedStatement pstmt = null;
		Notice notice = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				notice = new Notice(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return notice;
	}
}
