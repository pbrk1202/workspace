package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.web.BookDao;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

@Service	
public class BookServiceImp implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<GroupCodeView> getGroupCodeViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<GroupCodeView> list = bookDao.getGroupCodeViewList(offset, size, field, query);
		
		return list;
	}
	
	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		List<CodeView> list = bookDao.getCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<CodeView> getCodeViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<CodeView> list = bookDao.getCodeViewList(offset, size, field, query);
		
		return list;
	}
	
	@Override
	public List<BookView> getBookViewList(int page, String field, String query) {

		int size = 9; // img 게시판
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
				
		List<BookView> list = bookDao.getBookViewList(offset, size, field, query);

		return list;
	}
	
	@Override
	public List<BookView> getBookViewList(int page, String field, String query, int codeCd) {
		
		int size = 9; // img 게시판
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
				
		List<BookView> list = bookDao.getBookViewList(offset, size, field, query, codeCd);

		return list;
	}
	
	@Override
	public int getBookCount(String field, String query) {

		return bookDao.getBookCount(field, query);
	}
	
	@Override
	public int getBookCount(String field, String query, int codeCd) {

		return bookDao.getBookCount(field, query, codeCd);
	}
	
	@Override
	public BookView getBookViewDetail(int no) {
		BookView bookView = bookDao.getBookViewDetail(no);
		
		return bookView;
	}
	
	@Override
	public List<BookReviewView> getBookReviewViewListMaxLine(int no, int maxLine) {

		List<BookReviewView> list = bookDao.getBookReviewViewListMaxLine(no, maxLine);

		return list;
	}
	
	@Override
	public List<BookReviewView> getBookReviewViewList(int no, int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size; 
		
		List<BookReviewView> list = bookDao.getBookReviewViewList(no, offset, size, field, query);

		return list;
	}
	
	@Override
	public int getBookReviewCount(int no, String field, String query) {
		
		return bookDao.getBookReviewCount(no, field, query);
	}
	
	
	@Override
	public int getBookReviewInsert(BookReview bookReview) {
		// TODO Auto-generated method stub
		
		return bookDao.getBookReviewInsert(bookReview);
	}
	
}
