package com.pbrk.pbook.service.admin;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

public interface AdminSingleLineService {
	
	// code (view)를 groupCd로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
	
	// singleLine (view)를 요청할 때
	List<SingleLineView> getAdminSingleLineViewList(int page, String field, String query, int codeCd);

	// singleLine 게시물 수를 요청할 때
	int getAdminSingleLineCount(String field, String query, int codeCd);

	// singleLine 상세(view) 페이지를 요청할 때
	SingleLineView getAdminSingleLineViewDetail(int no);	

	// singleLine 데이터를 수정할 때
	int adminSingleLineUpdate(SingleLine singleLine);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
