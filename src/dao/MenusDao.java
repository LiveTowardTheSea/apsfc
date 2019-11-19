package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Menus;
import po.Page;
import util.DBUtil;
import vo.MenusInfo;

public class MenusDao {
	
	// 添加
	public int add(Menus menu) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// SQL语句
		String sql = "insert into menus(name,typeid,burden,brief,price,sums,price1,sums1,imgpath) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getName());
			pstmt.setString(2, menu.getTypeid());
			pstmt.setString(3, menu.getBurden());
			pstmt.setString(4, menu.getBrief());
			pstmt.setString(5, menu.getPrice());
			pstmt.setString(6, menu.getSums());
			pstmt.setString(7, menu.getPrice1());
			pstmt.setString(8, menu.getSums1());
			pstmt.setString(9, menu.getImgpath());
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

	// 修改
	public int update(int id, Menus menu) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// SQL语句
		String sql = "update menus set name=?,burden=?,price=?,price1=?,brief=?,typeid=? where id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getName());
			pstmt.setString(2, menu.getBurden());
			pstmt.setString(3, menu.getPrice());
			pstmt.setString(4, menu.getPrice1());
			pstmt.setString(5, menu.getBrief());
			pstmt.setString(6, menu.getTypeid());
			pstmt.setInt(7, id);
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
		Connection conn = DBUtil.getConn();
		String sql = "delete from menus where id = ?";
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

	// 查询数量
	public long count() {
		Connection conn = DBUtil.getConn();
		String sql = "select count(*) from menus";
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		long count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				count = rSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return count;
	}

	// 查询所有
	public ArrayList<MenusInfo> findAll() { // 获取连接
		Connection conn = DBUtil.getConn(); // 准备sql语句
		String sql = "select "
				+ "m.id id, m.name name, t.id typeid, t.name typename, m.burden burden, m.brief brief, m.price price, m.sums sums, m.price1 price1, m.sums1 sums1, m.imgpath imgpath "
				+ "from menus m, types t " + "where m.typeid=t.id";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<MenusInfo> list = new ArrayList<MenusInfo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				MenusInfo menusInfo = new MenusInfo(rSet.getInt(1), rSet.getString(2), rSet.getString(3),
						rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8),
						rSet.getString(9), rSet.getString(10), rSet.getString(11));
				list.add(menusInfo);
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

	// 分页查询
	public Page<MenusInfo> findByPage(Page<MenusInfo> page) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// 准备sql语句
		String sql = "select "
				+ "m.id id, m.name name, t.id typeid, t.name typename, m.burden burden, m.brief brief, m.price price, m.sums sums, m.price1 price1, m.sums1 sums1, m.imgpath imgpath "
				+ "from menus m left join types t " + "on m.typeid=t.id limit ?, ?";
		// 准备preparedstatement
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<MenusInfo> list = new ArrayList<MenusInfo>();
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				MenusInfo menusInfo = new MenusInfo(rSet.getInt(1), rSet.getString(2), rSet.getString(3),
						rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8),
						rSet.getString(9), rSet.getString(10), rSet.getString(11));
				list.add(menusInfo);
			}
			page.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return page;
	}

	// 根据id查询
	public Menus findById(int id) {
		Connection conn = DBUtil.getConn(); // 准备sql语句
		String sql = "select * from menus where id=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Menus menu = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				menu = new Menus(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9),
						rSet.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return menu;
	}

	// 根据内容查询
	public Menus findByName(String name) {
		Connection conn = DBUtil.getConn(); // 准备sql语句
		String sql = "select * from menus where name=?";
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Menus menu = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rSet = pstmt.executeQuery();
			if (rSet.next()) {
				menu = new Menus(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9),
						rSet.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return menu;
	}
}
