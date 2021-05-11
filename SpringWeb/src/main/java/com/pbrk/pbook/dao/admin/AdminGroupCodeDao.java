package com.pbrk.pbook.dao.admin;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCode;
import com.pbrk.pbook.entity.GroupCodeView;

public interface AdminGroupCodeDao {

	// code (view)를 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
		
	// groupCode (view)를 요청할 때
	List<GroupCodeView> getAdminGroupCodeViewList(int offset, int size);

	// groupCode 게시물 수를 요청할 때
	int getAdminGroupCodeCount();
	
	// 그룹코드 등록 중복체크
	int getAdminGroupCodeRegCheck(int groupCd);

	// 그룹코드 수정 중복체크
	int getAdminGroupCodeEditCheck(int groupCd);
	
	// groupCode 상세(view) 페이지를 요청할 때
	GroupCodeView getAdminGroupCodeViewDetail(int no);	
	
	// groupCode 데이터를 등록할 때
	int adminGroupCodeInsert(GroupCode groupCode);

	// groupCode 데이터를 수정할 때
	int adminGroupCodeUpdate(GroupCode groupCode);
	
	// code 데이터를 삭제할 때
	int adminGroupCodeDelete(GroupCode groupCode);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
}
