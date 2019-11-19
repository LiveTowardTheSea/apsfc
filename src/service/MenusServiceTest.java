package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import po.Menus;
import po.Page;
import util.PageUtil;
import vo.MenusInfo;

public class MenusServiceTest {
	private MenusService service  = new MenusService();
	@Test
	public void testAdd() {
		Menus menu = new Menus(11, "红烧肉", "123132", "123132", "123132", "123132", "123132", "123132", "123132", "123132");
		System.out.println(service.add(menu));
	}

	@Test
	public void testDelete() {
		service.delete(22);
	}

	@Test
	public void testUpdate() {
		Menus menu = new Menus(11, "粉蒸肉", "123132", "123132", "123132", "123132", "123132", "123132", "123132", "123132");
		System.out.println(service.update(22, menu));
	}
	
	@Test
	public void testFindbyid() {
		Menus menu = service.findById(17);
		System.out.println(menu);
	}

}
