package com.pbrk.pbook.service.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.service.admin.AdminSingleLineService;

/**
 * 공지사항 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class NoticeServiceImpTest {

	@Autowired
	private NoticeService service;
	
	@Test
	void test() {

		int no = 86;
		int page = 1;
		String field = "";
		String query = "";
		
		// 목록 조회
//		System.out.println(service.getNoticeViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getNoticeCount(field, query));
		
		// 상세정보 조회
//		System.out.println(service.getNoticeViewDetail(no));
		
	}

}
