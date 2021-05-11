package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminBookDao;
import com.pbrk.pbook.entity.Book;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;

@Repository
public class MybatisAdminBookDao implements AdminBookDao {

	private AdminBookDao mapper;
		
	@Autowired
	public MybatisAdminBookDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminBookDao.class);
	}
		
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		return mapper.getAdminCodeViewList(groupCd);
	}
	
	
	@Override
	public List<BookView> getAdminBookViewList(int offset, int size, String field, String query, int codeCd) {

		return mapper.getAdminBookViewList(offset, size, field, query, codeCd);
	}
	
	@Override
	public int getAdminBookCount(String field, String query, int codeCd) {
		
		return mapper.getAdminBookCount(field, query, codeCd);
	}	
	
	@Override
	public BookView getAdminBookViewDetail(int no) {

		return mapper.getAdminBookViewDetail(no);
	}
	
	@Override
	public int adminBookInsert(Book book) {

		return mapper.adminBookInsert(book);
	}
	
	@Override
	public int adminBookUpdate(Book book) {

		return mapper.adminBookUpdate(book);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
}
