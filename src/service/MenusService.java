package service;

import dao.MenusDao;
import po.Menus;
import po.Page;
import vo.MenusInfo;

public class MenusService {
	private MenusDao menusDao = new MenusDao();

	// 添加
	public int add(Menus menu) {
		// 根据菜品名称查找是否重复添加
		Menus m = menusDao.findByName(menu.getName());
		if (m != null) { // 如果要添加的name已经存在
			return -1;
		}
		return menusDao.add(menu);
	}

	// 删除
	public int delete(int id) {
		return menusDao.delete(id);
	}

	// 修改
	public int update(int id, Menus menu) {
		Menus m = menusDao.findByName(menu.getName());
		// 如果能够查到 并且查到的菜品id和想要修改的菜品id不一样
		if (m != null && m.getId() != id) {
			return -1;
		}
		return menusDao.update(id, menu);
	}

	// 查询一共有多少条
	public long count() {
		return menusDao.count();
	}

	// 分页查询
	public Page<MenusInfo> findByPage(Page<MenusInfo> page) {
		return menusDao.findByPage(page);
	}

	// 根据id查询
	public Menus findById(int id) {
		return menusDao.findById(id);
	}

	// 根据内容查询
	public Menus findByName(String name) {
		return menusDao.findByName(name);
	}
}