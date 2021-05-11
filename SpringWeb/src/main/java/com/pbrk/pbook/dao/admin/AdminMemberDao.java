package com.pbrk.pbook.dao.admin;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;

public interface AdminMemberDao {

	// code (view)를 groupNo로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
	
	// member (view)를 요청할 때
	List<MemberView> getAdminMemberViewList(int offset, int size, String field, String query, int codeCd);

	// member 게시물 수를 요청할 때
	int getAdminMemberCount(String field, String query, int codeCd);

	// member 상세(view) 페이지를 요청할 때
	MemberView getAdminMemberViewDetail(int no);	
	
	// member 데이터를 등록할 때
	int adminMemberInsert(Member member);

	// member 데이터를 수정할 때
	int adminMemberUpdate(Member member);
	
	// member 데이터를 삭제할 때
	int adminMemberDelete(Member member);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberSessionId);
}
