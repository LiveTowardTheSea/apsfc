package service;

import java.util.ArrayList;

import dao.OrdersDao;
import po.Orders;
import po.OrdersSearch;
import po.Page;
import vo.OrdersInfo;
import vo.Rorder;
import vo.SalesVolume;

public class OrdersService {
	
	private OrdersDao ordersDao = new OrdersDao();
	
	
	//分页查询---兼容search功能
	public Page<OrdersInfo> findByPage(Page<OrdersInfo> page, OrdersSearch search) {
		return ordersDao.findByPage(page,search);
	}
	
	//查询数量---兼容search功能
	public long count(OrdersSearch search) {
		// TODO Auto-generated method stub
		return ordersDao.count(search);
	}
	
	public boolean add(Orders order) {
		if(ordersDao.add(order) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int confirm(int id) {
		return ordersDao.confirm(id);
	}
	
	public int delete(int id) {
		return ordersDao.delete(id);
	}
	
	public ArrayList<SalesVolume> findSaleByDate(String date) {
		return ordersDao.findSalesByDate(date);
	}
	
	public ArrayList<Rorder> findRankingList() {
		return ordersDao.findRankingList();
	}
}
