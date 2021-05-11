package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminGroupCodeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCode;
import com.pbrk.pbook.entity.GroupCodeView;

@Service	
public class AdminGroupCodeServiceImp implements AdminGroupCodeService {

	@Autowired
	private AdminGroupCodeDao adminGroupCodeDao;
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		List<CodeView> list = adminGroupCodeDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
	
	
	@Override
	public List<GroupCodeView> getAdminGroupCodeViewList(int page) {

		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<GroupCodeView> list = adminGroupCodeDao.getAdminGroupCodeViewList(offset, size);
		
		return list;
	}
	
	@Override
	public int getAdminGroupCodeCount() {
		
		return adminGroupCodeDao.getAdminGroupCodeCount();
	}
	
	@Override
	public int getAdminGroupCodeRegCheck(int groupCd) {

		return adminGroupCodeDao.getAdminGroupCodeRegCheck(groupCd);
	}
	
	@Override
	public int getAdminGroupCodeEditCheck(int groupCd) {
		// TODO Auto-generated method stub
		return adminGroupCodeDao.getAdminGroupCodeEditCheck(groupCd);
	}
	
	@Override
	public GroupCodeView getAdminGroupCodeViewDetail(int no) {
		
		GroupCodeView groupCodeView = adminGroupCodeDao.getAdminGroupCodeViewDetail(no);
		
		return groupCodeView;
	}

	@Override
	public int adminGroupCodeInsert(GroupCode groupCode) {
		
		return adminGroupCodeDao.adminGroupCodeInsert(groupCode);
	}

	@Override
	public int adminGroupCodeUpdate(GroupCode groupCode) {
		
		return adminGroupCodeDao.adminGroupCodeUpdate(groupCode);
	}

	@Override
	public int adminGroupCodeDelete(GroupCode groupCode) {
		
		return adminGroupCodeDao.adminGroupCodeDelete(groupCode);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return adminGroupCodeDao.getAdminMemberNo(memberId);
	}
}
