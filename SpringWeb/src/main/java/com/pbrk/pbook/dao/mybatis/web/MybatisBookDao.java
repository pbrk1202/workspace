package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.BookDao;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

@Repository
public class MybatisBookDao implements BookDao {

	private BookDao mapper;
	
	@Autowired
	public MybatisBookDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(BookDao.class);
	}

	@Override
	public List<GroupCodeView> getGroupCodeViewList(int offset, int size, String field, String query) {

		return mapper.getGroupCodeViewList(offset, size, field, query);
	}

	@Override
	public List<CodeView> getCodeViewList(int groupCd) {
		// TODO Auto-generated method stub
		return mapper.getCodeViewList(groupCd);
	}
	
	@Override
	public List<CodeView> getCodeViewList(int offset, int size, String field, String query) {

		return mapper.getCodeViewList(offset, size, field, query);
	}

	@Override
	public List<BookView> getBookViewList(int offset, int size, String field, String query) {

		return mapper.getBookViewList(offset, size, field, query);
	}

	@Override
	public List<BookView> getBookViewList(int offset, int size, String field, String query, int codeCd) {
		
		return mapper.getBookViewList(offset, size, field, query, codeCd);
	}
	
	@Override
	public int getBookCount(String field, String query) {

		return mapper.getBookCount(field, query);
	}

	@Override
	public int getBookCount(String field, String query, int codeCd) {
		
		return mapper.getBookCount(field, query, codeCd);
	}
	
	@Override
	public BookView getBookViewDetail(int no) {

		return mapper.getBookViewDetail(no);
	}

	@Override
	public List<BookReviewView> getBookReviewViewListMaxLine(int no, int maxLine) {
		
		return mapper.getBookReviewViewListMaxLine(no, maxLine);
	}	
	
	@Override
	public List<BookReviewView> getBookReviewViewList(int no, int offset, int size, String field, String query) {

		return mapper.getBookReviewViewList(no, offset, size, field, query);
	}

	@Override
	public int getBookReviewCount(int no, String field, String query) {

		return mapper.getBookReviewCount(no, field, query);
	}
		
	@Override
	public int getBookReviewInsert(BookReview bookReview) {

		return mapper.getBookReviewInsert(bookReview);
	}
}
