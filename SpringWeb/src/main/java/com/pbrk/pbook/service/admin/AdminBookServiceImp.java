package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminBookDao;
import com.pbrk.pbook.entity.Book;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;

@Service	
public class AdminBookServiceImp implements AdminBookService {

	@Autowired
	private AdminBookDao adminBookDao;
	
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		List<CodeView> list = adminBookDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
		
	@Override
	public List<BookView> getAdminBookViewList(int page, String field, String query, int codeCd) {

		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
				
		List<BookView> list = adminBookDao.getAdminBookViewList(offset, size, field, query, codeCd);

		return list;
	}
	
	@Override
	public int getAdminBookCount(String field, String query, int codeCd) {

		return adminBookDao.getAdminBookCount(field, query, codeCd);
	}
	
	@Override
	public BookView getAdminBookViewDetail(int no) {
		
		BookView bookView = adminBookDao.getAdminBookViewDetail(no);
		
		return bookView;
	}
	
	@Override
	public int adminBookInsert(Book book) {
		
		return adminBookDao.adminBookInsert(book);
		
	}
	
	@Override
	public int adminBookUpdate(Book book) {

		return adminBookDao.adminBookUpdate(book);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return adminBookDao.getAdminMemberNo(memberId);
	}
}
