package com.pbrk.pbook.dao.mybatis.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.admin.AdminNoticeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Notice;
import com.pbrk.pbook.entity.NoticeView;

@Repository
public class MybatisAdminNoticeDao implements AdminNoticeDao{
	
	private AdminNoticeDao mapper;
	
	@Autowired
	public MybatisAdminNoticeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(AdminNoticeDao.class);
	}
	
	@Override
	public List<CodeView> getAdminCodeViewList(int groupCd) {

		return mapper.getAdminCodeViewList(groupCd);
	}
	
	@Override
	public List<NoticeView> getAdminNoticeViewList(int offset, int size, String field, String query, int codeCd) {

		return mapper.getAdminNoticeViewList(offset, size, field, query, codeCd);
	}
	
	@Override
	public int getAdminNoticeCount(String field, String query, int codeCd) {

		return mapper.getAdminNoticeCount(field, query, codeCd);
	}
	
	@Override
	public NoticeView getAdminNoticeViewDetail(int id) {

		return mapper.getAdminNoticeViewDetail(id);
	}
	
	@Override
	public int adminNoticeInsert(Notice notice) {

		return mapper.adminNoticeInsert(notice);
	}
	
	@Override
	public int adminNoticeUpdate(Notice notice) {

		return mapper.adminNoticeUpdate(notice);
	}

	@Override
	public int getAdminMemberNo(String memberId) {

		return mapper.getAdminMemberNo(memberId);
	}
}
