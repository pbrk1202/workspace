package com.pbrk.pbook.dao.web;

import java.util.List;

import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.SingleLineView;

public interface MainDao {

	// book 목록(view)를 요청할 때
	List<BookView> getAdminBookViewListMaxLine(int maxLine);
	
	// singleLine (view)를 요청할 때
	List<SingleLineView> getSingleLineViewListMaxLine(int maxLine);
	
	// singleLine (view)를 요청할 때
	List<SingleLineView> getSingleLineViewList(int offset, int size, String field, String query);
			
	// 로그인 확인을 요청할 때
	int getLoginConfirm(Member member);
	
}
