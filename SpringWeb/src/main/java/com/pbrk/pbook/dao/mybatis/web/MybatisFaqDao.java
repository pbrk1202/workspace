package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.FaqDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

@Repository
public class MybatisFaqDao implements FaqDao {
	
	private FaqDao mapper;
	
	
	@Autowired
	public MybatisFaqDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(FaqDao.class);
	}

	
	@Override
	public List<CodeView> getCodeViewList(int groupCd) {
		
		return mapper.getCodeViewList(groupCd);
	}
	
	@Override
	public List<FaqView> getFaqViewList(int offset, int size, String field, String query) {

		return mapper.getFaqViewList(offset, size, field, query);
	}

	@Override
	public int getFaqCount(String field, String query) {

		return mapper.getFaqCount(field, query);
	}

	@Override
	public FaqView getFaqViewDetail(int no) {

		return mapper.getFaqViewDetail(no);
	}
	
	@Override
	public int getFaqInsert(Faq faq) {
		
		return mapper.getFaqInsert(faq);
	}
	
	@Override
	public int getMemberNo(String memberId) {

		return mapper.getMemberNo(memberId);
	}
}
