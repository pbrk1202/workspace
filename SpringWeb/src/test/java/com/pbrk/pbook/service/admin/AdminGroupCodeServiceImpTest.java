package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.GroupCode;

/**
 * 그룹코드 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-21 기본 구조 (완료)
 */
@SpringBootTest
class AdminGroupCodeServiceImpTest {

	@Autowired
	private AdminGroupCodeService service;
	
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
						
		GroupCode groupCode = new GroupCode();
		
		groupCode.setGroup_cd(101);                  // 그룹코드 (테스트 : 100번째 값 부터)
//		groupCode.setGroup_cd_nm("테스트 그룹코드");     // 그룹코드 명 
		groupCode.setGroup_cd_nm("테스트 그룹코드 수정"); // 그룹코드 명
		
		groupCode.setGroup_del(false);               // 삭제여부 (false : 사용중)
		groupCode.setReg_no(2);                      // 작성자 (2 : 관리자)
		groupCode.setMod_no(3);					     // 수정자 (2 : 관리자)
		
		// 목록 조회
//		System.out.println(service.getAdminGroupCodeViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminGroupCodeCount(field, query));
		
		// 게시물 등록
//		System.out.println(service.adminGroupCodeInsert(groupCode));
		
		// 게시물 수정
//		System.out.println(service.adminGroupCodeUpdate(groupCode));

		// 게시물 삭제
//		System.out.println(service.adminGroupCodeDelete(groupCode));
	}

}
