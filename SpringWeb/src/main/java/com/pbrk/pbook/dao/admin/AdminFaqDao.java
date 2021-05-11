package com.pbrk.pbook.dao.admin;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Faq;
import com.pbrk.pbook.entity.FaqView;

public interface AdminFaqDao {
	
	// code (view)를 groupNo로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
	
	// faq (view)를 요청할 때
	List<FaqView> getAdminFaqViewList(int offset, int size, String field, String query, int codeCd);
	
	// faq 게시물 수를 요청할 때
	int getAdminFaqCount(String field, String query, int codeCd);
	
	// faq 상세(view) 페이지를 요청할 때
	FaqView getAdminFaqViewDetail(int no);

	// faq 데이터를 등록할 때
	int adminFaqInsert(Faq faq);
	
	// faq 데이터를 수정할 때	
	int adminFaqUpdate(Faq faq);

	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
