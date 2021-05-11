package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.web.FaqDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

@Service
public class FaqServiceImp implements FaqService{

	@Autowired
	private FaqDao faqDao;

	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		List<CodeView> list = faqDao.getCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<FaqView> getFaqViewList(int page, String field, String query) {

		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
				
		List<FaqView> list = faqDao.getFaqViewList(offset, size, field, query);
		
		return list;
	}
	
	@Override
	public int getFaqCount(String field, String query) {
		
		return faqDao.getFaqCount(field, query);
	}
	
	@Override
	public FaqView getFaqViewDetail(int no) {
		
		FaqView detail = faqDao.getFaqViewDetail(no);
		
		return detail;
	}
		
	@Override
	public int getFaqInsert(Faq faq) {
		
		return faqDao.getFaqInsert(faq);
	}
	
	@Override
	public int getMemberNo(String memberId) {
		
		return faqDao.getMemberNo(memberId);
	}
}
