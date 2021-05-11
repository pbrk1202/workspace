package com.pbrk.pbook.dao.admin;

import java.util.List;

import com.pbrk.pbook.entity.Book;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;

public interface AdminBookDao {

	// code (view)를 groupNo로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
	
	// book 목록(view)를 요청할 때
	List<BookView> getAdminBookViewList(int offset, int size, String field, String query, int codeCd);

	// book 게시물 수를 요청할 때
	int getAdminBookCount(String field, String query, int codeCd);

	// book 상세(view) 페이지를 요청할 때
	BookView getAdminBookViewDetail(int no);	
	
	// book 데이터를 등록할 때
	int adminBookInsert(Book book);

	// book 데이터를 수정할 때
	int adminBookUpdate(Book book);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
