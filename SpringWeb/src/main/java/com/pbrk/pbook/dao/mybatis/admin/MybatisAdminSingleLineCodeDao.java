package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminSingleLineDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

@Repository
public class MybatisAdminSingleLineCodeDao implements AdminSingleLineDao {

	private AdminSingleLineDao mapper;
	
	@Autowired
	public MybatisAdminSingleLineCodeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminSingleLineDao.class);
	}

	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
	
		return mapper.getAdminCodeViewList(groupCd);
	}
	
	@Override
	public List<SingleLineView> getAdminSingleLineViewList(int offset, int size, String field, String query, int codeCd) {
		// TODO Auto-generated method stub
		return mapper.getAdminSingleLineViewList(offset, size, field, query, codeCd);
	}

	@Override
	public int getAdminSingleLineCount(String field, String query, int codeCd) {
		// TODO Auto-generated method stub
		return mapper.getAdminSingleLineCount(field, query, codeCd);
	}

	@Override
	public SingleLineView getAdminSingleLineViewDetail(int no) {
		// TODO Auto-generated method stub
		return mapper.getAdminSingleLineViewDetail(no);
	}

	@Override
	public int adminSingleLineUpdate(SingleLine singleLine) {
		// TODO Auto-generated method stub
		return mapper.adminSingleLineUpdate(singleLine);
	}

	
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
	
}
