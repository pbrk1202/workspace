package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.NoticeDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.NoticeView;

@Repository
public class MybatisNoticeDao implements NoticeDao{
	
	private NoticeDao mapper;
	
	@Autowired
	public MybatisNoticeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(NoticeDao.class);
	}

	@Override
	public List<CodeView> getCodeViewList(int groupCd) {
		// TODO Auto-generated method stub
		return mapper.getCodeViewList(groupCd);
	}
	
	@Override
	public List<NoticeView> getNoticeViewList(int offset, int size, String field, String query, int codeCd) {

		return mapper.getNoticeViewList(offset, size, field, query, codeCd);
	}

	@Override
	public int getNoticeCount(String field, String query, int codeCd) {

		return mapper.getNoticeCount(field, query, codeCd);
	}

	@Override
	public NoticeView getNoticeViewDetail(int no) {

		return mapper.getNoticeViewDetail(no);
	}
	
	
	
}
