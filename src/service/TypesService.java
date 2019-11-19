package service;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dao.TypesDao;
import po.Types;

public class TypesService {
	private TypesDao typesDao = new TypesDao();

	// 添加
	public int add(Types type) {
		// 判断添加的菜品类别是否已经存在
		if (typesDao.findByName(type.getName()) != null) {
			// 返回值为-1表示菜品已经存在
			return -1;
		}
		return typesDao.add(type);
	}

	// 删除
	public int delete(int id) {
		return typesDao.delete(id);
	}

	// 修改
	public int update(int id, String name) {
		Types type = typesDao.findByName(name);
		if(type != null && id != type.getId()) {
			return -1;
		}
		return typesDao.update(id, name);
	}

	// 查询所有
	public ArrayList<Types> findAll() {
		return typesDao.findAll();
	}

	// 根据id查询
	public Types findById(int id) {
		return typesDao.findById(id);
	}
}
