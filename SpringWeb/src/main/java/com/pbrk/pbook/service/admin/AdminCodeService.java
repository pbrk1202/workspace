package com.pbrk.pbook.service.admin;

import java.util.List;

import com.pbrk.pbook.entity.Code;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;

public interface AdminCodeService {

	// groupCode (view)를 요청할 때
	List<GroupCodeView> getAdminGroupCodeViewList();
	
	// code (view)를 요청할 때
	List<CodeView> getAdminCodeViewList(int page, String field, String query, int groupCd);

	// code 게시물 수를 요청할 때
	int getAdminCodeCount(String field, String query, int groupCd);

	// 공통코드 중복체크
	int getAdminCodeCheck(int groupCd, int codeCd);
	
	// code 상세(view) 페이지를 요청할 때
	CodeView getAdminCodeViewDetail(int groupCode ,int code);	
	
	// code 데이터를 등록할 때
	int adminCodeInsert(Code code);

	// code 데이터를 수정할 때
	int adminCodeUpdate(Code code);
	
	// code 데이터를 삭제할 때
	int adminCodeDelete(Code code);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
