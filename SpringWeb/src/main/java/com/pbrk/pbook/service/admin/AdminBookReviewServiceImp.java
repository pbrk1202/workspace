package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminBookReviewDao;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.CodeView;

@Service	
public class AdminBookReviewServiceImp implements AdminBookReviewService {

	@Autowired
	private AdminBookReviewDao adminBookReviewDao;
			
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		List<CodeView> list = adminBookReviewDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
		
	@Override
	public List<BookReviewView> getAdminBookReviewViewList(int no, int page, String field, String query) {

		int size = 10;
		int offset = 0+(page-1)*size; 
		
		List<BookReviewView> list = adminBookReviewDao.getAdminBookReviewViewList(no, offset, size, field, query);

		return list;
	}
	
	@Override
	public int getAdminBookReviewCount(int no, String field, String query) {

		return adminBookReviewDao.getAdminBookReviewCount(no, field, query);
	}
	
	@Override
	public BookReviewView getAdminBookReviewViewDetail(int book_review_no) {
		
		BookReviewView bookReivewView = adminBookReviewDao.getAdminBookReviewViewDetail(book_review_no);
		
		return bookReivewView;
	}
	
	@Override
	public int adminBookReviewUpdate(BookReview bookReview) {

		return adminBookReviewDao.adminBookReviewUpdate(bookReview);
	}
	
	@Override
	public int adminBookReviewDelete(BookReview bookReview) {

		return adminBookReviewDao.adminBookReviewDelete(bookReview);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return adminBookReviewDao.getAdminMemberNo(memberId);
	}
}
