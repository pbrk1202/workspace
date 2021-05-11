package com.pbrk.pbook.service.web;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

public interface FaqService {

	// code (view)를 groupCd로 요청할 때
	List<CodeView> getCodeViewList(int groupCd);
	
	// faq (view)를 요청할 때
	List<FaqView> getFaqViewList(int page, String field, String query);
	
	// faq 게시물 수를 요청할 때
	int getFaqCount(String field, String query);
	
	// faq 상세(view) 페이지를 요청할 때
	FaqView getFaqViewDetail(int no);
	
	// faq 데이터를 등록할 때
	int getFaqInsert(Faq faq);
	
	// 회원번호 조회
	int getMemberNo(String memberId);
}
