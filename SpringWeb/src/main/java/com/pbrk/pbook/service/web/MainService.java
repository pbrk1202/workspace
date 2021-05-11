package com.pbrk.pbook.service.web;

import java.util.List;

import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.SingleLineView;

public interface MainService {
	
	// book 목록(view)를 요청할 때
	List<BookView> getAdminBookViewListMaxLine(int maxLine);	
	
	// singleLine (view)를 요청할 때
	List<SingleLineView> getSingleLineViewListMaxLine(int maxLine);
		
	// singleLine (view)를 요청할 때
	List<SingleLineView> getSingleLineViewList(int page, String field, String query);

	// 로그인 확인
	int getLoginConfirm(Member member);
}
