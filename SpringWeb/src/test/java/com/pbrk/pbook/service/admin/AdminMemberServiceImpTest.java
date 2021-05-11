package com.pbrk.pbook.service.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.entity.Member;

/**
 * 회원 데이터 테스트
 * @author pbrk1202
 * 1차 : 2021-04-22 기본 구조 (완료)
 */
@SpringBootTest
class AdminMemberServiceImpTest {
	
	@Autowired
	private AdminMemberService service;
		
	@Test
	void test() {
		
		int page = 1;
		String field = "";
		String query = "";
		
		int no = 1;
		Member member = new Member();
		
		member.setMember_no(4);                       // 회원번호
		member.setMember_id("root2");                 // 아이디
		member.setMember_pwd("0000");                 // 비밀번호
		member.setMember_nm("테스트2");                 // 회원명
		member.setMember_gender(1);                   // 성별
		member.setMember_bth("2021-04-22");           // 생년월일
		member.setMember_phone("010-0000-0000");      // 전화번호
		member.setMember_email("pbrk1202@gmail.com"); // 이메일

		member.setReg_no(2); // 작성자
		
		// 목록 조회
//		System.out.println(service.getAdminMemberViewList(page, field, query));
		
		// 게시물 수 조회
//		System.out.println(service.getAdminMemberCount(field, query));
		
		// 상제정보 조회
//		System.out.println(service.getAdminMemberViewDetail(1));
		
		// 회원등록
//		System.out.println(service.adminMemberInsert(member));
		
		// 회원수정
//		System.out.println(service.adminMemberUpdate(member));
		
		// 회원삭제
//		System.out.println(service.adminMemberDelete(member));
	}

}
