package dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.glass.ui.MenuItem;

import po.Menus;
import po.Page;
import util.PageUtil;
import vo.MenusInfo;

public class MenusDaoTest {
	private MenusDao menusDao = new MenusDao();

	@Test
	public void testCount() {
		long count = menusDao.count();
		System.out.println(count);
	}

	@Test
	public void findByPage() {
		long count = menusDao.count();
		Page<MenusInfo> page = PageUtil.createPage(10, (int) count, 1);
		page = menusDao.findByPage(page);
		List<MenusInfo> list = page.getList();
		for (MenusInfo menusInfo : list) {
			System.out.println(menusInfo);
		}
	}
	
	@Test
	public void testDelete() {
		int result = menusDao.delete(20);
		System.out.println(result);
	}
	
	@Test
	public void testFindbyid() {
		Menus menu = menusDao.findById(17);
		System.out.println(menu);
	}
	
	@Test
	public void testFindByName() {
		Menus menu = menusDao.findByName("水煮鱼");
		System.out.println(menu);
	}
	
	@Test
	public void testAdd() {
		Menus menu = new Menus(11, "123132", "123132", "123132", "123132", "123132", "123132", "123132", "123132", "123132");
		System.out.println(menusDao.add(menu));
	}
	
	@Test
	public void testUpdate() {
		Menus menu = new Menus(21, "红烧牛肉面", "123132", "123132", "123132", "123132", "123132", "123132", "123132", "123132");
		System.out.println(menusDao.update(21, menu));
	}

}
