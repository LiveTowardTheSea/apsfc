package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Orders;
import po.OrdersSearch;
import po.Page;
import util.DBUtil;
import vo.OrdersInfo;
import vo.Rorder;
import vo.SalesVolume;

public class OrdersDao {

	// 增加
	public int add(Orders order) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into orders(userid, menuid, menusum, times, delivery) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getUserid());
			pstmt.setString(2, order.getMenuid());
			pstmt.setString(3, order.getMenusum());
			pstmt.setString(4, order.getTimes());
			pstmt.setString(5, order.getDelivery());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	// 确认配送
	public int confirm(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "update orders set delivery=1 where id=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
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
		String sql = "delete from orders where id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}

	
	
	//搜索-----总条数
	public long count(OrdersSearch search) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// 准备sql语句
		String sql = "select count(*) "
				+ "from orders o left join menus m on o.menuid=m.id "
				+ "left join users u on o.userid=u.id where u.realname like '%' ";
		//arraylist用于存放参数
		ArrayList<Object> params = new ArrayList<>();
		// 拼接SQL语句
		if(search != null) {
			if(search.getUserid() != null && search.getUserid().trim().length() != 0){ //去掉字符串两段的空格
				sql = sql + "and u.id = ? ";
				params.add(search.getUserid());
			}
			if (search.getMenuname() != null && search.getMenuname().trim().length() != 0) {
				sql = sql + "and m.name like ? ";
				params.add("%" + search.getMenuname() + "%");
			}
			if(search.getDate() != null && search.getDate().trim().length() != 0) {
				sql = sql + "and o.times like ? ";
				params.add("%" + search.getDate() + "%");
			}
			if(search.getDelivery() != null && search.getDelivery().trim().length() != 0) {
				sql = sql + "and o.delivery = ? ";
				params.add(search.getDelivery());
			}
		}
		// 准备preparedstatement
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		long count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 设置参数
			for(int index = 0; index < params.size(); index++){
				pstmt.setObject(index + 1, params.get(index));
			}
			//System.out.println(pstmt.toString());
			rSet = pstmt.executeQuery();
			// 处理结果
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
	
	//搜索-----分页查询
	public Page<OrdersInfo> findByPage(Page<OrdersInfo> page, OrdersSearch search) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// 准备sql语句
		String sql = "select o.id, u.id, u.realname, u.phone, u.address, m.name, o.menusum, m.price, m.price*o.menusum, o.times, o.delivery "
				+ "from orders o left join menus m on o.menuid=m.id "
				+ "left join users u on o.userid=u.id where u.realname like '%' ";
		//arraylist用于存放参数
		ArrayList<Object> params = new ArrayList<>();
		// 拼接SQL语句
		if(search != null) {
			if(search.getUserid() != null && search.getUserid().trim().length() != 0){ //去掉字符串两段的空格
				sql = sql + "and u.id = ? ";
				params.add(search.getUserid());
			}
			if (search.getMenuname() != null && search.getMenuname().trim().length() != 0) {
				sql = sql + "and m.name like ? ";
				params.add("%" + search.getMenuname() + "%");
			}
			if(search.getDate() != null && search.getDate().trim().length() != 0) {
				sql = sql + "and o.times like ? ";
				params.add("%" + search.getDate() + "%");
			}
			if(search.getDelivery() != null && search.getDelivery().trim().length() != 0) {
				sql = sql + "and o.delivery = ? ";
				params.add(search.getDelivery());
			}
		}
		sql = sql + "order by times desc limit ?,?";
		params.add(page.getBeginIndex());
		params.add(page.getEveryPage());
		// 准备preparedstatement
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<OrdersInfo> ordersList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 设置参数
			for(int index = 0; index < params.size(); index++){
				pstmt.setObject(index + 1, params.get(index));
			}
			// System.out.println(pstmt.toString());
			rSet = pstmt.executeQuery();
			// 处理结果
			while (rSet.next()) {
				OrdersInfo ordersInfo = new OrdersInfo(rSet.getInt(1), rSet.getString(2), rSet.getString(3),
						rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8),
						rSet.getString(9), rSet.getString(10), rSet.getString(11));
				ordersList.add(ordersInfo);
			}
			page.setList(ordersList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return page;
	}
	
	
	//查询每种菜品的销售额，根据时间查询
	public ArrayList<SalesVolume> findSalesByDate(String date) {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// 准备sql语句
		String sql = "select m.name, sum(o.menusum), m.price, m.price*sum(o.menusum) "
					+ "from orders o left join menus m on o.menuid=m.id "
					+ "where o.times like ? "
					+ "group by o.menuid";
		// 准备preparedstatement
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<SalesVolume> salesList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, "%" + date + "%");
			// System.out.println(pstmt.toString());
			rSet = pstmt.executeQuery();
			// 处理结果
			while (rSet.next()) {
				SalesVolume salesVolume = new SalesVolume(rSet.getString(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
				salesList.add(salesVolume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return salesList;
	}
	
	public ArrayList<Rorder> findRankingList() {
		// 获取连接
		Connection conn = DBUtil.getConn();
		// 准备sql语句
		String sql = "select m.id, m.name, sum(o.menusum) "
				+ "from orders o left join menus m on o.menuid=m.id " + "group by o.menuid order by sum(o.menusum) desc";
		// 准备preparedstatement
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Rorder> rankingList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			// System.out.println(pstmt.toString());
			rSet = pstmt.executeQuery();
			// 处理结果
			while (rSet.next()) {
				Rorder rorder = new Rorder(rSet.getInt(1), rSet.getString(2), rSet.getString(3));
				rankingList.add(rorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return rankingList;
	}

}
