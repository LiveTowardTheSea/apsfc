package service;

import dao.AdminDao;
import po.Admin;

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();
	
	//登录
	public Admin login(String name, String pwd) {
		return adminDao.findByNameAndPwd(name, pwd);
	}
	
	//修改
	public int update(int id, Admin admin) {
		//判断修改之后的名字是否和其它用户重复
		Admin a = adminDao.findByName(admin.getName());
		if(a != null && a.getId() != id) {
			return -1;
		}
		return adminDao.update(id, admin);
	}
}
