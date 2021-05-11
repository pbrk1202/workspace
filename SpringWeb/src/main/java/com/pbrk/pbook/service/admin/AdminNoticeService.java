package com.pbrk.pbook.service.admin;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Notice;
import com.pbrk.pbook.entity.NoticeView;

public interface AdminNoticeService {

	// code (view)를 groupCd로 요청할 때
	List<CodeView> getAdminCodeViewList(int groupCd);
	
	// notice 목록(veiw)를 요청할 때
	List<NoticeView> getAdminNoticeViewList();
	
	// notice 목록(veiw)를 요청할 때
	List<NoticeView> getAdminNoticeViewList(String field, String query);
	
	// notice 목록(veiw)를 요청할 때
	List<NoticeView> getAdminNoticeViewList(int page, String field, String query, int codeCd);

	// notice 게시물 수를 요청할 때
	int getAdminNoticeCount();
	
	// notice 게시물 수를 요청할 때
	int getAdminNoticeCount(String field, String query, int codeCd);

	// notice 상세정보(view)를 요청할 때
	NoticeView getAdminNoticeViewDetail(int id);
		
	// notice 데이터를 수정할 때
	int adminNoticeUpdate(Notice notice);

	// notice 데이터를 등록할 때
	int adminNoticeInsert(Notice notice);
	
	// 회원번호 조회
	int getAdminMemberNo(String memberId);
	
}
