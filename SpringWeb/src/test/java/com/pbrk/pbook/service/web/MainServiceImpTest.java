package com.pbrk.pbook.service.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.service.admin.AdminSingleLineService;

/**
 * 메인 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class MainServiceImpTest {

	@Autowired
	private MainService service;
	
	@Test
	void test() {

		int page = 1;
		String field = "";
		String query = "";
		
		// 한줄평 조회
//		System.out.println(service.getSingleLineViewList(page, field, query));
		
	}

}
