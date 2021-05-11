package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminMemberDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;

@Service	
public class AdminMemberServiceImp implements AdminMemberService {

	@Autowired
	private AdminMemberDao adminMemberDao;
	
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		List<CodeView> list = adminMemberDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<MemberView> getAdminMemberViewList(int page, String field, String query, int codeCd) {

		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<MemberView> list = adminMemberDao.getAdminMemberViewList(offset, size, field, query, codeCd);
		
		return list;
	}
	
	@Override
	public int getAdminMemberCount(String field, String query, int codeCd) {
		
		return adminMemberDao.getAdminMemberCount(field, query, codeCd);
	}
	
	@Override
	public MemberView getAdminMemberViewDetail(int no) {
		
		MemberView memberView = adminMemberDao.getAdminMemberViewDetail(no);
		
		return memberView;
	}
	
	@Override
	public int adminMemberInsert(Member member) {
		
		return adminMemberDao.adminMemberInsert(member);
	}
	
	@Override
	public int adminMemberUpdate(Member member) {

		return adminMemberDao.adminMemberUpdate(member);
	}
	
	@Override
	public int adminMemberDelete(Member member) {

		return adminMemberDao.adminMemberDelete(member);
	}
	
	@Override
	public int getAdminMemberNo(String memberSessionId) {
		// TODO Auto-generated method stub
		return adminMemberDao.getAdminMemberNo(memberSessionId);
	}
}
