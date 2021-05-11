package com.pbrk.pbook.service.web;

import java.util.List;

import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.NoticeView;

public interface NoticeService {

	// code (view)를 groupCd로 요청할 때
	List<CodeView> getCodeViewList(int groupCd);
	
	// notice 목록(veiw)를 요청할 때
	List<NoticeView> getNoticeViewList(int page, String field, String query, int codeCd);

	// notice 게시물 수를 요청할 때
	int getNoticeCount(String field, String query, int codeCd);
	
	// notice 상세정보(view)를 요청할 때
	NoticeView getNoticeViewDetail(int no);
}
