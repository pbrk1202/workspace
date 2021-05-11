package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.MainDao;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.SingleLineView;

@Repository
public class MybatisMainDao implements MainDao {
	
	private MainDao mapper;
	
	@Autowired
	public MybatisMainDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(MainDao.class);
	}

	@Override
	public List<BookView> getAdminBookViewListMaxLine(int maxLine) {

		return mapper.getAdminBookViewListMaxLine(maxLine);
	}
	
	@Override
	public List<SingleLineView> getSingleLineViewListMaxLine(int maxLine) {

		return mapper.getSingleLineViewListMaxLine(maxLine);	
	}
	
	@Override
	public List<SingleLineView> getSingleLineViewList(int offset, int size, String field, String query) {

		return mapper.getSingleLineViewList(offset, size, field, query);
	}
	
	@Override
	public int getLoginConfirm(Member member) {
		
		return mapper.getLoginConfirm(member);
	}
		
}
