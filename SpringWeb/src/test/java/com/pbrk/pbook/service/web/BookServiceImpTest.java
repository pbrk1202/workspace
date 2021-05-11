package com.pbrk.pbook.service.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 도서 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class BookServiceImpTest {

	@Autowired
	private BookService service;
	
	@Test
	void test() {
		
		int no = 1;
		int page = 1;
		String field = "";
		String query = "";
		
		// groupCode 목록 조회
//		System.out.println(service.getGroupCodeViewList(page, field, query));
		
		// code 목록 조회
//		System.out.println(service.getCodeViewList(page, field, query));
		
		// book 목록 조회
//		System.out.println(service.getBookViewList(page, field, query));		
		
		// book 게시물 수 조회
//		System.out.println(service.getBookCount(field, query));
		
		// book 상세 정보 조회
//		System.out.println(service.getBookViewDetail(1));
		
		// bookReview 목록 조회
//		System.out.println(service.getBookReviewViewList(no, page, field, query));
		
		// bookReview 게시물 수 조회
//		System.out.println(service.getBookReviewCount(no, field, query));
		
	}

}
