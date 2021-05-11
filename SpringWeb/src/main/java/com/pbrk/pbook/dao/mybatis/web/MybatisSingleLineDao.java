package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.SingleLineDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

@Repository
public class MybatisSingleLineDao implements SingleLineDao {
	
	private SingleLineDao mapper;
	
	@Autowired
	public MybatisSingleLineDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(SingleLineDao.class);
	}

	@Override
	public List<GroupCodeView> getGroupCodeViewList(int offset, int size, String field, String query) {

		return mapper.getGroupCodeViewList(offset, size, field, query);
	}

	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		return mapper.getCodeViewList(groupCd);
	}
	
	@Override
	public List<CodeView> getCodeViewList(int offset, int size, String field, String query) {

		return mapper.getCodeViewList(offset, size, field, query);
	}

	@Override
	public List<SingleLineView> getSingleLineViewList(int offset, int size, String field, String query, int codeCd) {

		return mapper.getSingleLineViewList(offset, size, field, query, codeCd);
	}

	@Override
	public int getSingleLineCount(String field, String query, int codeCd) {

		return mapper.getSingleLineCount(field, query, codeCd);
	}

	@Override
	public SingleLineView getSingleLineViewDetail(int no) {

		return mapper.getSingleLineViewDetail(no);
	}
	
	@Override
	public int getSingleLineUpdate(SingleLine singleLine) {
		
		return mapper.getSingleLineUpdate(singleLine);
	}
	
	@Override
	public int getSingleLineInsert(SingleLine singleLine) {
		// TODO Auto-generated method stub
		return mapper.getSingleLineInsert(singleLine);
	}
	
	@Override
	public int getMemberNo(String memberId) {

		return mapper.getMemberNo(memberId);
	}
}
