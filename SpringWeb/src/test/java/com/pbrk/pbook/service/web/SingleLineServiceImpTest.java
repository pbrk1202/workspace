package com.pbrk.pbook.service.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.service.admin.AdminSingleLineService;

/**
 * 한줄글 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class SingleLineServiceImpTest {

	@Autowired
	private SingleLineService service;
	
	@Test
	void test() {

		int page = 1;
		String field = "";
		String query = "";
		
		// groupCode 목록 조회
//		System.out.println(service.getGroupCodeViewList(page, field, query));
		
		// code 목록 조회
//		System.out.println(service.getCodeViewList(page, field, query));
		
		// singleLine 목록 조회
//		System.out.println(service.getSingleLineViewList(page, field, query));
		
		// singleLine 게시물 수 조회
//		System.out.println(service.getSingleLineCount(field, query));
		
	}

}
