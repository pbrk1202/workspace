package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class InfoServiceImp implements InfoService{

	@Autowired
	private InfoDao infoDao;

	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		List<CodeView> list = infoDao.getCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public MemberView getInfoMemberViewDetail(String memberId) {
		
		MemberView memberView = infoDao.getInfoMemberViewDetail(memberId);
		
		return memberView;
	}
	
	@Override
	public int getMemberNo(String memberId) {

		return infoDao.getMemberNo(memberId);
	}
	
	@Override
	public int getInfoMemberUpdate(Member member) {

		return infoDao.getInfoMemberUpdate(member);
	}
	
	@Override
	public List<BookReviewView2> getBookReviewViewList(int page, int memberNo) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
		
		List<BookReviewView2> list = infoDao.getBookReviewViewList(offset, size, memberNo);
						
		return list;
	}
	
	@Override
	public int getBookReviewCount(int memberNo) {
	
		return infoDao.getBookReviewCount(memberNo);
	}
	
	@Override
	public BookReviewView2 getInfoBookReviewViewDetail(int bookReviewNo) {
		
		return infoDao.getInfoBookReviewViewDetail(bookReviewNo);
	}
	
	@Override
	public int getInfoBookReviewUpdate(BookReview bookReview) {

		return infoDao.getInfoBookReviewUpdate(bookReview);
	}
	
	@Override
	public List<SingleLineView> getInfoSingleLineViewList(int page, int memberNo) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
		
		List<SingleLineView> list = infoDao.getInfoSingleLineViewList(offset, size, memberNo);
		
		return list;
	}
	
	@Override
	public int getInfoSingleLineCount(int memberNo) {

		return infoDao.getInfoSingleLineCount(memberNo);
	}
	
	@Override
	public SingleLineView getSingleLineViewDetail(int snglLineNo) {

		return infoDao.getSingleLineViewDetail(snglLineNo);
	}
	
	@Override
	public int getInfoSingleLineUpdate(SingleLine singleLine) {

		return infoDao.getInfoSingleLineUpdate(singleLine);
	}
}
