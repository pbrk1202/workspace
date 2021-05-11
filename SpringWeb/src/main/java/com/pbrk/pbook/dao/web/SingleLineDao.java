package com.pbrk.pbook.dao.web;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

public interface SingleLineDao {
	
	// groupCode (view)를 요청할 때
	List<GroupCodeView> getGroupCodeViewList(int offset, int size, String field, String query);
	
	// code (view)를 요청할 때
	List<CodeView> getCodeViewList(int groupNo);
		
	// code (view)를 요청할 때
	List<CodeView> getCodeViewList(int offset, int size, String field, String query);
		
	// singleLine (view)를 요청할 때
	List<SingleLineView> getSingleLineViewList(int offset, int size, String field, String query, int codeCd);

	// singleLine 게시물 수를 요청할 때
	int getSingleLineCount(String field, String query, int codeCd);
	
	// singleLine 상세(view) 페이지를 요청할 때
	SingleLineView getSingleLineViewDetail(int no);	
	
	// singleLine 데이터를 수정할 때
	int getSingleLineUpdate(SingleLine singleLine);
	
	// singleLine 데이터를 등록할 때
	int getSingleLineInsert(SingleLine singleLine);
	
	// 회원번호 조회
	int getMemberNo(String memberId);
}
