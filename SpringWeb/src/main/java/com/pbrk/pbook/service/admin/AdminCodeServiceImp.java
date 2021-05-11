package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminCodeDao;
import com.pbrk.pbook.entity.Code;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

@Service	
public class AdminCodeServiceImp implements AdminCodeService {

	@Autowired
	private AdminCodeDao adminCodeDao;

	
	@Override
	public List<GroupCodeView> getAdminGroupCodeViewList() {

		List<GroupCodeView> list = adminCodeDao.getAdminGroupCodeViewList();
		
		return list;
	}
	
	@Override
	public List<CodeView> getAdminCodeViewList(int page, String field, String query, int groupCd) {

		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<CodeView> list = adminCodeDao.getAdminCodeViewList(offset, size, field, query, groupCd);
		
		return list;
	}
	
	@Override
	public int getAdminCodeCount(String field, String query, int groupCd) {
		
		return adminCodeDao.getAdminCodeCount(field, query, groupCd);
	}
	
	
	@Override
	public int getAdminCodeCheck(int groupCd, int codeCd) {

		return adminCodeDao.getAdminCodeCheck(groupCd, codeCd);
	}
	
	
	@Override
	public CodeView getAdminCodeViewDetail(int groupCode, int code) {
		
		CodeView codeView = adminCodeDao.getAdminCodeViewDetail(groupCode, code);
		
		return codeView;
	}
	
	@Override
	public int adminCodeInsert(Code code) {
		
		return adminCodeDao.adminCodeInsert(code);
	}
	
	@Override
	public int adminCodeUpdate(Code code) {

		return adminCodeDao.adminCodeUpdate(code);
	}
	
	@Override
	public int adminCodeDelete(Code code) {

		return adminCodeDao.adminCodeDelete(code);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return adminCodeDao.getAdminMemberNo(memberId);
	}
}
