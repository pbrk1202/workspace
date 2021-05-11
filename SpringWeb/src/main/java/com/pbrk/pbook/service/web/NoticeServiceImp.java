package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.web.NoticeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.NoticeView;

@Service // @Component, @Service, @Controller, @Repositonry, @Configuration,
public class NoticeServiceImp implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	
	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		List<CodeView> list = noticeDao.getCodeViewList(groupCd);
		
		return list;
	}	
	
	@Override
	public List<NoticeView> getNoticeViewList(int page, String field, String query, int codeCd) {
		
		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
		
		List<NoticeView> list = noticeDao.getNoticeViewList(offset, size, field, query, codeCd);
		return list;
	}


	@Override
	public int getNoticeCount(String field, String query, int codeCd) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeCount(field, query, codeCd);
	}

	@Override
	public NoticeView getNoticeViewDetail(int no) {
		// TODO Auto-generated method stub

		NoticeView notice = noticeDao.getNoticeViewDetail(no);
		
		return notice;
	}

}
