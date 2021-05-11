package com.pbrk.pbook.service.web;

import java.util.List;

import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookReviewView2;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

public interface InfoService {
	
	// code 조회를 요청할 때
	List<CodeView> getCodeViewList(int groupCd);
	
	// 내상세정보 조회
	MemberView getInfoMemberViewDetail(String memberId);
	
	// 회원번호 조회
	int getMemberNo(String memberId);
	
	// 회원정보 수정
	int getInfoMemberUpdate(Member member);
	
	// 내리뷰 목록 조회
	List<BookReviewView2> getBookReviewViewList(int page, int memberNo);
	
	// 내리뷰 게시물 수 조회
	int getBookReviewCount(int memberNo);
	
	// 리뷰 상세정보 조회
	BookReviewView2 getInfoBookReviewViewDetail(int bookReviewNo);
	
	// 리뷰 상세정보 수정
	int getInfoBookReviewUpdate(BookReview bookReview);
	
	// 내한줄글 목록 조회
	List<SingleLineView> getInfoSingleLineViewList(int page, int memberNo);
	
	// 내한줄글 게시물 수 조회
	int getInfoSingleLineCount(int memberNo);
	
	// 한줄글 상세정보 조회
	SingleLineView getSingleLineViewDetail(int snglLineNo);
	
	// 한줄글 수정
	int getInfoSingleLineUpdate(SingleLine singleLine);
}
