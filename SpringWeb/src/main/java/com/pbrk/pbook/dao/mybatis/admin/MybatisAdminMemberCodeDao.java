package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminMemberDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;

@Repository
public class MybatisAdminMemberCodeDao implements AdminMemberDao {

	private AdminMemberDao mapper;
	
	@Autowired
	public MybatisAdminMemberCodeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminMemberDao.class);
	}

	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
	
		return mapper.getAdminCodeViewList(groupCd);
	}
	
	@Override
	public List<MemberView> getAdminMemberViewList(int offset, int size, String field, String query, int codeCd) {
		// TODO Auto-generated method stub
		return mapper.getAdminMemberViewList(offset, size, field, query, codeCd);
	}

	@Override
	public int getAdminMemberCount(String field, String query, int codeCd) {
		// TODO Auto-generated method stub
		return mapper.getAdminMemberCount(field, query, codeCd);
	}

	@Override
	public MemberView getAdminMemberViewDetail(int no) {
		// TODO Auto-generated method stub
		return mapper.getAdminMemberViewDetail(no);
	}

	@Override
	public int adminMemberInsert(Member member) {
		// TODO Auto-generated method stub
		return mapper.adminMemberInsert(member);
	}

	@Override
	public int adminMemberUpdate(Member member) {
		// TODO Auto-generated method stub
		return mapper.adminMemberUpdate(member);
	}

	@Override
	public int adminMemberDelete(Member member) {
		// TODO Auto-generated method stub
		return mapper.adminMemberDelete(member);
	}

	@Override
	public int getAdminMemberNo(String memberSessionId) {

		return mapper.getAdminMemberNo(memberSessionId);
	}
}
