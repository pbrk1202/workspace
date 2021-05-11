package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminCodeDao;
import com.pbrk.pbook.entity.Code;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

@Repository
public class MybatisAdminCodeDao implements AdminCodeDao {

	private AdminCodeDao mapper;
	
	@Autowired
	public MybatisAdminCodeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminCodeDao.class);
	}
	
	@Override
	public List<GroupCodeView> getAdminGroupCodeViewList() {

		return mapper.getAdminGroupCodeViewList();
	}
	
	@Override
	public List<CodeView> getAdminCodeViewList(int offset, int size, String field, String query, int groupCd) {

		return mapper.getAdminCodeViewList(offset, size, field, query, groupCd);
	}
	
	@Override
	public int getAdminCodeCount(String field, String query, int groupCd) {

		return mapper.getAdminCodeCount(field, query, groupCd);
	}
	
	@Override
	public int getAdminCodeCheck(int groupCd, int codeCd) {

		return mapper.getAdminCodeCheck(groupCd, codeCd);
	}
	
	@Override
	public CodeView getAdminCodeViewDetail(int groupCode, int code) {

		return mapper.getAdminCodeViewDetail(groupCode, code);
	}
	
	@Override
	public int adminCodeInsert(Code code) {

		return mapper.adminCodeInsert(code);
	}
	
	@Override
	public int adminCodeUpdate(Code code) {
		
		return mapper.adminCodeUpdate(code);
	}
	
	@Override
	public int adminCodeDelete(Code code) {

		return mapper.adminCodeDelete(code);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
}
