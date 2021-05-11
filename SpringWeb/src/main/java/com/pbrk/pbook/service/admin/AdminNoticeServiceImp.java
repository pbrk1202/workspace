package com.pbrk.pbook.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.admin.AdminNoticeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Notice;
import com.pbrk.pbook.entity.NoticeView;

@Service // @Component, @Service, @Controller, @Repositonry, @Configuration,
public class AdminNoticeServiceImp implements AdminNoticeService{

	@Autowired
	private AdminNoticeDao adminNoticeDao;
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {
		
		List<CodeView> list = adminNoticeDao.getAdminCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<NoticeView> getAdminNoticeViewList() {

		return getAdminNoticeViewList(1, "notice_title", "", 1);
	}

	@Override
	public List<NoticeView> getAdminNoticeViewList(String field, String query) {

		return getAdminNoticeViewList(1, field, query, 1);
		
	}
	
	@Override
	public List<NoticeView> getAdminNoticeViewList(int page, String field, String query, int codeCd) {
		
		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0 , 2->10, 3->20 // 등차수열 : an=a1+(n-1)d -> 0+(page-1)*10
		
		List<NoticeView> list = adminNoticeDao.getAdminNoticeViewList(offset, size, field, query, codeCd);
		return list;
	}

	@Override
	public int getAdminNoticeCount() {

		return getAdminNoticeCount("notice_title", "", 1);
	}

	@Override
	public int getAdminNoticeCount(String field, String query, int codeCd) {

		return adminNoticeDao.getAdminNoticeCount(field, query, codeCd);
	}

	@Override
	public NoticeView getAdminNoticeViewDetail(int id) {

		NoticeView notice = adminNoticeDao.getAdminNoticeViewDetail(id);
		
		return notice;
	}

	@Override
	public int adminNoticeInsert(Notice notice) {

		return adminNoticeDao.adminNoticeInsert(notice);
	}
	
	@Override
	public int adminNoticeUpdate(Notice notice) {
		
		return adminNoticeDao.adminNoticeUpdate(notice);
	}
	
	@Override
	public int getAdminMemberNo(String memberId) {

		return adminNoticeDao.getAdminMemberNo(memberId);
	}
}
