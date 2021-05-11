package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.SingleLine;

/**
 * 한줄글 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class AdminSingleLineServiceTest {

	@Autowired
	private AdminSingleLineService service;
	
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
		
		int no = 2;
//		sl.sngl_line_no AS sngl_line_no,
//		 sl.sngl_line_title AS sngl_line_title,
//		 sl.sngl_line_content AS sngl_line_content,
//		 sl.sngl_line_pub AS sngl_line_pub,
//		 sl.group_cd AS group_cd,
//		 sl.code_cd AS code_cd,
//		 sl.reg_no AS reg_no,
//		 sl.reg_date AS reg_date,
//		 sl.mod_no AS mod_no,
		
		SingleLine singleLine = new SingleLine();
		
		singleLine.setSngl_line_no(2);             // 한줄글 번호
		singleLine.setSngl_line_title("한줄글 변경"); // 한줄글 제목
		singleLine.setSngl_line_content("한줄글 변경"); // 한줄글 제목
		
		singleLine.setMod_no(2); // 수정자
		
		// 목록 조회
//		System.out.println(service.getAdminSingleLineViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminSingleLineCount(field, query));
		
		// 상세정보 조회
//		System.out.println(service.getAdminSingleLineViewDetail(page));
		
		// 한줄글 수정
//		System.out.println(service.adminSingleLineUpdate(singleLine));
	}

}
