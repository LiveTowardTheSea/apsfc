package service;

import java.util.ArrayList;

import dao.NoticeDao;
import po.Notice;

public class NoticeService {
	
	private NoticeDao noticeDao = new NoticeDao();
	
	public ArrayList<Notice> findAll() {
		return noticeDao.findAll();
	}
	
	public int add(Notice notice) {
		return noticeDao.add(notice);
	}
	
	public int delete(int id) {
		return noticeDao.delete(id);
	}
	
	public Notice findById(int id) {
		return noticeDao.findById(id);
	}
}
