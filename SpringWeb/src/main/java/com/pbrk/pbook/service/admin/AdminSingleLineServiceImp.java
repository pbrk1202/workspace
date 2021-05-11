package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminSingleLineDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

@Service	
public class AdminSingleLineServiceImp implements AdminSingleLineService {

	@Autowired
	private AdminSingleLineDao adminSingleLineDao;
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		List<CodeView> list = adminSingleLineDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<SingleLineView> getAdminSingleLineViewList(int page, String field, String query, int codeCd) {

		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<SingleLineView> list = adminSingleLineDao.getAdminSingleLineViewList(offset, size, field, query, codeCd);
		
		return list;
	}
	
	@Override
	public int getAdminSingleLineCount(String field, String query, int codeCd) {
		
		return adminSingleLineDao.getAdminSingleLineCount(field, query, codeCd);
	}
	
	@Override
	public SingleLineView getAdminSingleLineViewDetail(int no) {
		
		SingleLineView singleLineView = adminSingleLineDao.getAdminSingleLineViewDetail(no);
		
		return singleLineView;
	}
	
	@Override
	public int adminSingleLineUpdate(SingleLine singleLine) {

		return adminSingleLineDao.adminSingleLineUpdate(singleLine);
	}

	@Override
	public int getAdminMemberNo(String memberId) {

		return adminSingleLineDao.getAdminMemberNo(memberId);
	}
}
