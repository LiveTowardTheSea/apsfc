package service;

import static org.junit.Assert.*;

import org.junit.Test;

import po.Types;

public class TypesServiceTest {
	TypesService typesService = new TypesService(); 
	
	@Test
	public void testAdd() {
		Types type = new Types();
		type.setName("汤类");
		System.out.println(typesService.add(type));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		System.out.println(typesService.update(2, "炒菜"));
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
