package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.Faq;

/**
 * 자주하는 질문 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-21 기본 구조 (완료)
 */
@SpringBootTest
class AdminFaqServiceImpTest {

	@Autowired
	private AdminFaqService service;
	
	
	@Test
	void test() {

		int page = 1;
		String field = "";
		String query = "";
		
		int no = 160;
	
		Faq faq = new Faq();
		
//		faq.setFaq_no(161);
		faq.setFaq_title("질문 테스트1");       // 질문제목
		faq.setFaq_content("질문 내용 테스트"); // 질문내용
		faq.setFaq_answer("답변");           // 질문답변
		
		faq.setGroup_cd(3);                 // 그룹타입
		faq.setCode_cd(2);                  // 질문타입
		
		faq.setReg_no(2);                   // 작성자
		

		// 목록 조회
//		System.out.println(service.getAdminFaqViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminFaqCount(field, query));
		
		// 상세정보 조회
//		System.out.println(service.getAdminFaqViewDetail(no));
		
		// 질문 등록
//		System.out.println(service.adminFaqInsert(faq));
		
		// 질문 수정
//		System.out.println(service.adminFaqUpdate(faq));
		
	}

}
