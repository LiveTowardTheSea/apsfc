package service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.Notice;

public class NoticeServiceTest {
	NoticeService service = new NoticeService();
	@Test
	public void testFindAll() {
		ArrayList<Notice> list = service.findAll();
		for (Notice notice : list) {
			System.out.println(notice);
		}
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
