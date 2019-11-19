package dao;

import java.util.ArrayList;

import org.junit.Test;

import po.Types;

public class TypesDaoTest {
	private TypesDao typesDao = new TypesDao();
	@Test
	public void testAdd() {
		Types type = new Types();
		type.setName("川菜");
		int result = typesDao.add(type);
		System.out.println(result);
	}
	
	@Test
	public void testUpdate() {
		int result = typesDao.update(11, "川菜");
		System.out.println(result);
	}
	
	@Test
	public void testFindAll() {
		ArrayList<Types> list = typesDao.findAll();
		for (Types types : list) {
			System.out.println(types);
		}
	}
	
	@Test
	public void testFindById() {
		Types type = typesDao.findById(10);
		System.out.println(type);
	}
	
	@Test
	public void testFindByName() {
		Types type = typesDao.findByName("川菜");
		System.out.println(type);
	}
	
	@Test
	public void testDelete() {
		int result = typesDao.delete(12);
		System.out.println(result);
	}
}
