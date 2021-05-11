package com.pbrk.pbook.service.admin;

import java.util.List;

import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.CodeView;

public interface AdminBookReviewService {
		
	// code (view)를 groupCd로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
		
	// bookReview 목록(view)를 요청할 때
	List<BookReviewView> getAdminBookReviewViewList(int no, int page, String field, String query);

	// bookReview 게시물 수를 요청할 때
	int getAdminBookReviewCount(int no, String field, String query);

	// bookReview 상세(view) 페이지를 요청할 때
	BookReviewView getAdminBookReviewViewDetail(int book_review_no);	
	
	// bookReview 데이터를 수정할 때
	int adminBookReviewUpdate(BookReview bookReview);
	
	// bookReview 데이터를 삭제할 때
	int adminBookReviewDelete(BookReview bookReview);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
