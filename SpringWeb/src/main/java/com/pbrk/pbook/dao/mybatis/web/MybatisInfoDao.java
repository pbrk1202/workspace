package com.pbrk.pbook.dao.mybatis.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbrk.pbook.dao.web.InfoDao;
import com.pbrk.pbook.dao.web.MainDao;
import com.pbrk.pbook.entity.BookReview;
import com.pbrk.pbook.entity.BookReviewView;
import com.pbrk.pbook.entity.BookReviewView2;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.MemberView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

@Repository
public class MybatisInfoDao implements InfoDao {
	
	private InfoDao mapper;
	
	@Autowired
	public MybatisInfoDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(InfoDao.class);
	}
	
	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		return mapper.getCodeViewList(groupCd);
	}

	@Override
	public MemberView getInfoMemberViewDetail(String memberId) {

		return mapper.getInfoMemberViewDetail(memberId);
	}
	
	@Override
	public int getMemberNo(String memberId) {

		return mapper.getMemberNo(memberId);
	}
	
	@Override
	public int getInfoMemberUpdate(Member member) {

		return mapper.getInfoMemberUpdate(member);
	}
	
	@Override
	public List<BookReviewView2> getBookReviewViewList(int offset, int size, int memberNo) {

		return mapper.getBookReviewViewList(offset, size, memberNo);
	}
	
	@Override
	public int getBookReviewCount(int memberNo) {

		return mapper.getBookReviewCount(memberNo);
	}
	
	@Override
	public BookReviewView2 getInfoBookReviewViewDetail(int bookReviewNo) {

		return mapper.getInfoBookReviewViewDetail(bookReviewNo);
	}
	
	@Override
	public int getInfoBookReviewUpdate(BookReview bookReview) {

		return mapper.getInfoBookReviewUpdate(bookReview);
	}
	
	@Override
	public List<SingleLineView> getInfoSingleLineViewList(int offset, int size, int memberNo) {

		return mapper.getInfoSingleLineViewList(offset, size, memberNo);
	}
	
	@Override
	public int getInfoSingleLineCount(int memberNo) {

		return mapper.getInfoSingleLineCount(memberNo);
	}
	
	@Override
	public SingleLineView getSingleLineViewDetail(int snglLineNo) {

		return mapper.getSingleLineViewDetail(snglLineNo);
	}
	
	@Override
	public int getInfoSingleLineUpdate(SingleLine singleLine) {

		return mapper.getInfoSingleLineUpdate(singleLine);
	}
			
}
