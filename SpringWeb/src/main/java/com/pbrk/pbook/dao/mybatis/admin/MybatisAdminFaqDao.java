package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminFaqDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

@Repository
public class MybatisAdminFaqDao implements AdminFaqDao {
	
	private AdminFaqDao mapper;
	
	@Autowired
	public MybatisAdminFaqDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminFaqDao.class);
	}
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		return mapper.getAdminCodeViewList(groupCd);
	}
	
	@Override
	public List<FaqView> getAdminFaqViewList(int offset, int size, String field, String query, int codeCd) {

		return mapper.getAdminFaqViewList(offset, size, field, query, codeCd);
	}
	
	@Override
	public int getAdminFaqCount(String field, String query, int codeCd) {

		return mapper.getAdminFaqCount(field, query, codeCd);
	}
	
	@Override
	public FaqView getAdminFaqViewDetail(int no) {

		return mapper.getAdminFaqViewDetail(no);
	}
	
	@Override
	public int adminFaqInsert(Faq faq) {

		return mapper.adminFaqInsert(faq);
	}
	
	@Override
	public int adminFaqUpdate(Faq faq) {

		return mapper.adminFaqUpdate(faq);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
}
