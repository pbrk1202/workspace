package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.BookReview;


/**
 * 도서 리뷰 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-21 기본 구조 (완료)
 */
@SpringBootTest
class AdminBookReviewServiceImpTest {

	@Autowired
	private AdminBookReviewService service;
	
	@Test
	void test() {

		int page = 1;
		String field = "";
		String query = "";
		
		int bookNo = 1; // 도서 번호
		
		BookReview bookReview = new BookReview();
		bookReview.setBook_no(3);                       // 도서 번호
		bookReview.setBook_score(2);                    // 도서 점수
		bookReview.setBook_review_content("추천 합니다."); // 리뷰 내용
		
		bookReview.setBook_review_pub(true);
		
		bookReview.setReg_no(2); 					    // 작성자 (2 : 관리자)
		bookReview.setMod_no(2); 						// 수정자 (2 : 관리자)
		
		// 목록 조회
//		System.out.println(service.getAdminBookReviewViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminBookReviewCount(bookNo, field, query));
		
		// 게시물 상세정보
//		System.out.println(service.getAdminBookReviewViewDetail(1));
		
		// 도서 리뷰 수정
//		System.out.println(service.adminBookReviewUpdate(bookReview));
		
		// 도서 리뷰 삭제
//		System.out.println(service.adminBookReviewDelete(bookReview));
	}

}
