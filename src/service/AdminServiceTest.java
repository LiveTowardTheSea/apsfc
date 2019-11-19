package service;

import static org.junit.Assert.*;

import org.junit.Test;

import po.Admin;

public class AdminServiceTest {
	private AdminService service = new AdminService();
	@Test
	public void testLogin() {
		System.out.println(service.login("admin", "133"));
	}

	@Test
	public void testUpdate() {
		Admin admin = new Admin(0, "sa", "123", "1");
		System.out.println(service.update(1, admin));
	}

}
