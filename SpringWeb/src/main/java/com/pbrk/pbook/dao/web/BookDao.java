package com.pbrk.pbook.dao.web;

import java.util.List;

import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

public interface BookDao {
	
	// groupCode (view)를 요청할 때
	List<GroupCodeView> getGroupCodeViewList(int offset, int size, String field, String query);

	// code (view)를 groupNo로 요청할 때
	List<CodeView> getCodeViewList(int groupCd);
	
	// code (view)를 요청할 때
	List<CodeView> getCodeViewList(int offset, int size, String field, String query);
	
	// book 목록(view)를 요청할 때
	List<BookView> getBookViewList(int offset, int size, String field, String query);
	
	// book 목록(view)를 요청할 때
	List<BookView> getBookViewList(int offset, int size, String field, String query, int codeCd);

	// book 게시물 수를 요청할 때
	int getBookCount(String field, String query);

	// book 게시물 수를 요청할 때
	int getBookCount(String field, String query, int codeCd);
	
	// book 상세(view) 페이지를 요청할 때
	BookView getBookViewDetail(int no);

	// bookReview 목록(view)를 요청할 때
	List<BookReviewView> getBookReviewViewListMaxLine(int no, int maxLine);
	
	// bookReview 목록(view)를 요청할 때
	List<BookReviewView> getBookReviewViewList(int no, int offset, int size, String field, String query);

	// bookReview 게시물 수를 요청할 때
	int getBookReviewCount(int no, String field, String query);
	
	// 리뷰 등록
	int getBookReviewInsert(BookReview bookReview);
}
