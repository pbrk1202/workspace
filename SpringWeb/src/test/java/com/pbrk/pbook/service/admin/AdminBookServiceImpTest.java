package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.Book;

/**
 * 도서 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-21 기본 구조 (완료)
 */
@SpringBootTest
class AdminBookServiceImpTest {

	@Autowired
	private AdminBookService service;
	
	
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
	
		Book book = new Book();
		book.setBook_title("도서 테스트 수정2");  // 도서제목
		book.setBook_desc("도서 테스트 소개");    // 도서소개
		book.setBook_author("테스트");          // 저자
		book.setBook_author_desc("테스트 소개"); // 저자소개
		book.setBook_publisher("테스트문학");    // 출판사
		book.setBook_pub_date("2021");        // 발행년도
		
		book.setBook_pub(false); // 공개여부
		
		book.setGroup_cd(2); // 그룹코드
		book.setCode_cd(2);  // 공통코드
		book.setReg_no(2);   // 작성자
		
		book.setMod_no(2);   // 수정자
		
		//book.setBook_no(11);  // 도서 번호
		int bookNo = 11;      // 도서 번호
		
		// 목록 조회
//		System.out.println(service.getAdminBookViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminBookCount(field, query));
		
		// 상세 정보 조회
//		System.out.println(service.getAdminBookViewDetail(bookNo));
		
		// 도서 등록
//		System.out.println(service.adminBookInsert(book));
		
		// 도서 수정
//		System.out.println(service.adminBookUpdate(book));
	}

}
