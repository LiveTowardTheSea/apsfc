package dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.OrdersSearch;
import po.Page;
import util.PageUtil;
import vo.OrdersInfo;
import vo.Rorder;
import vo.SalesVolume;

public class OrdersDaoTest {
	OrdersDao dao = new OrdersDao();
	
	
	@Test
	public void testFindByPage() {
		long count = 30;
		OrdersSearch search = new OrdersSearch("1", "", "", null);
		@SuppressWarnings("unchecked")
		Page<OrdersInfo> page = PageUtil.createPage(10, (int) count, 1);
		page = dao.findByPage(page, search); 
		List<OrdersInfo> list = page.getList();
		for (OrdersInfo ordersInfo : list) {
			System.out.println(ordersInfo);
		}
	}
	
	@Test
	public void testCount() {
		OrdersSearch search = new OrdersSearch("5", "", "", null);
		long count = dao.count(search);
		System.out.println(count);
	}
	
	@Test
	public void testFindSalesByDate() {
		ArrayList<SalesVolume> list = dao.findSalesByDate("09-15");
		for (SalesVolume salesVolume : list) {
			System.out.println(salesVolume);
		}
	}
	
	@Test
	public void testFindRankingList() {
		ArrayList<Rorder> list = dao.findRankingList();
		for (Rorder rorder : list) {
			System.out.println(rorder);
		}
		
	}
	
}
