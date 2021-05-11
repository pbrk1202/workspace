package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.Code;

/**
 * 공통코드 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-21 기본 구조 (완료)
 */
@SpringBootTest
class AdminCodeServiceImpTest {

	@Autowired
	private AdminCodeService service;
	
	
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
		
		int groupCode = 2;
		int codeCode = 2;
		
		Code code = new Code();
		code.setGroup_cd(101);       // 그룹코드
		code.setCode_cd(1);          // 공통코드
		code.setCode_nm("테스트 코드 수정"); // 공통코드 명
		code.setReg_no(2);           // 작성자 명
		
		code.setMod_no(2); // 수정자 명
		
		// 목록 조회
//		System.out.println(service.getAdminCodeViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminCodeCount(field, query));
		
		// 상제정보 조회
//		System.out.println(service.getAdminCodeViewDetail(groupCode, codeCode));
		
		// 공통코드 등록
//		System.out.println(service.adminCodeInsert(code));
		
		// 공통코드 수정
//		System.out.println(service.adminCodeUpdate(code));
		
		// 공통코드 삭제
//		System.out.println(service.adminCodeDelete(code));
	}

}
