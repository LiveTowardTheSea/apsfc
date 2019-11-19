package dao;

import org.junit.Test;

import po.Admin;

public class AdminDaoTest {
	private AdminDao dao = new AdminDao();
	
	@Test
	public void testFindByNameAndPwd() {
		System.out.println(dao.findByNameAndPwd("sa", "123"));
	}

	@Test
	public void testFindByName() {
		System.out.println(dao.findByName("admin"));
	}

	@Test
	public void testUpdate() {
		Admin admin = new Admin(0, "admin", "123", "0");
		System.out.println(dao.update(2, admin));
	}

}
