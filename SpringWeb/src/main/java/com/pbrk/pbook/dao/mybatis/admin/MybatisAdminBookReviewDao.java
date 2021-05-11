package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminBookReviewDao;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.CodeView;

@Repository
public class MybatisAdminBookReviewDao implements AdminBookReviewDao {

	private AdminBookReviewDao mapper;
	
	@Autowired
	public MybatisAdminBookReviewDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminBookReviewDao.class);
	}

	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		return mapper.getAdminCodeViewList(groupCd);
	}
	
	@Override
	public List<BookReviewView> getAdminBookReviewViewList(int no, int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getAdminBookReviewViewList(no, offset, size, field, query);
	}

	@Override
	public int getAdminBookReviewCount(int no, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getAdminBookReviewCount(no, field, query);
	}

	@Override
	public BookReviewView getAdminBookReviewViewDetail(int book_review_no) {
		// TODO Auto-generated method stub
		return mapper.getAdminBookReviewViewDetail(book_review_no);
	}

	@Override
	public int adminBookReviewUpdate(BookReview bookReview) {
		// TODO Auto-generated method stub
		return mapper.adminBookReviewUpdate(bookReview);
	}

	@Override
	public int adminBookReviewDelete(BookReview bookReview) {
		// TODO Auto-generated method stub
		return mapper.adminBookReviewDelete(bookReview);
	}
		
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}	
}
