package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminGroupCodeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCode;
import com.pbrk.pbook.entity.GroupCodeView;

@Repository
public class MybatisAdminGroupCodeDao implements AdminGroupCodeDao {

	private AdminGroupCodeDao mapper;
	
	@Autowired
	public MybatisAdminGroupCodeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminGroupCodeDao.class);
	}
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		return mapper.getAdminCodeViewList(groupCd);
	}

	@Override
	public List<GroupCodeView> getAdminGroupCodeViewList(int offset, int size) {
		// TODO Auto-generated method stub
		return mapper.getAdminGroupCodeViewList(offset, size);
	}

	@Override
	public int getAdminGroupCodeCount() {
		// TODO Auto-generated method stub
		return mapper.getAdminGroupCodeCount();
	}
	
	@Override
	public int getAdminGroupCodeRegCheck(int groupCd) {
		// TODO Auto-generated method stub
		return mapper.getAdminGroupCodeRegCheck(groupCd);
	}
	
	@Override
	public int getAdminGroupCodeEditCheck(int groupCd) {

		return mapper.getAdminGroupCodeEditCheck(groupCd);
	}

	@Override
	public GroupCodeView getAdminGroupCodeViewDetail(int no) {
		// TODO Auto-generated method stub
		return mapper.getAdminGroupCodeViewDetail(no);
	}

	@Override
	public int adminGroupCodeInsert(GroupCode groupCode) {
		// TODO Auto-generated method stub
		return mapper.adminGroupCodeInsert(groupCode);
	}

	@Override
	public int adminGroupCodeUpdate(GroupCode groupCode) {
		// TODO Auto-generated method stub
		return mapper.adminGroupCodeUpdate(groupCode);
	}

	@Override
	public int adminGroupCodeDelete(GroupCode groupCode) {
		// TODO Auto-generated method stub
		return mapper.adminGroupCodeDelete(groupCode);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
	
}
