package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.Notice;

/**
 * 공지사항 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class AdminNoticeServiceTest {

	@Autowired
	private AdminNoticeService service;
	
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
		
		Notice notice = new Notice();
		
		notice.setNotice_no(87);               // 공지번호
		notice.setNotice_title("제목 테스트");    // 공지제목
		notice.setNotice_content("내용 테스트2"); // 공지내용
		notice.setGroup_cd(1);                 // 공지그룹
		notice.setCode_cd(1);                  // 공지타입
		notice.setReg_no(2);                   // 작성자
		
		notice.setMod_no(2); // 수정자
		
		// 목록 조회
//		System.out.println(service.getAdminNoticeViewList());

		// 목록 조회 2
//		System.out.println(service.getAdminNoticeViewList(field, query));
		
		// 목록 조회 3
//		System.out.println(service.getAdminNoticeViewList(page, field, query));
		
		// 게시물 수
//		System.out.println(service.getAdminNoticeCount());
		
		// 게시물 수 2
//		System.out.println(service.getAdminNoticeCount(field, query));
		
		// 상세정보
//		System.out.println(service.getAdminNoticeViewDetail(85));
		
		// 등록
//		System.out.println(service.adminNoticeInsert(notice));
		
		// 수정
//		System.out.println(service.adminNoticeUpdate(notice));
	}

}
