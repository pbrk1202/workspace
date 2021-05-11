package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminFaqDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

@Service
public class AdminFaqServiceImp implements AdminFaqService{

	@Autowired
	private AdminFaqDao adminFaqDao;

	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		List<CodeView> list = adminFaqDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<FaqView> getAdminFaqViewList(int page, String field, String query, int codeCd) {
		
		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
				
		List<FaqView> list = adminFaqDao.getAdminFaqViewList(offset, size, field, query, codeCd);
		
		return list;
	}
	
	@Override
	public int getAdminFaqCount(String field, String query, int codeCd) {
		
		return adminFaqDao.getAdminFaqCount(field, query, codeCd);
	}
	
	@Override
	public FaqView getAdminFaqViewDetail(int no) {
		
		FaqView detail = adminFaqDao.getAdminFaqViewDetail(no);
		
		return detail;
	}
	
	@Override
	public int adminFaqUpdate(Faq faq) {
		
		return adminFaqDao.adminFaqUpdate(faq);
	}

	@Override
	public int adminFaqInsert(Faq faq) {
		
		return adminFaqDao.adminFaqInsert(faq);
	}

	@Override
	public int getAdminMemberNo(String memberId) {

		return adminFaqDao.getAdminMemberNo(memberId);
	}
}
