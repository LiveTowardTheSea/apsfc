package service;

import dao.UsersDao;
import po.Users;

public class UsersService {
	private UsersDao usersDao = new UsersDao();
	
	public Users findUserByNameAndPwd(String name, String pwd) {
		return usersDao.findUserByNameAndPwd(name, pwd);
	}
	
	public Users findUserById(int id) {
		return usersDao.findUserById(id);
	}
	
	public int register(Users user) {
		Users u = usersDao.findUserByName(user.getName());
		if(u != null) { //用户名已存在
			return -1;
		}
		return usersDao.add(user);
	}
	
	public int update(int id, Users user) {
		return usersDao.update(id, user);
	}
}
