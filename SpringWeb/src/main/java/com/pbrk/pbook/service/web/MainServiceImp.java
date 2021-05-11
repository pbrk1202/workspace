package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.web.MainDao;
import com.pbrk.pbook.entity.BookView;
import com.pbrk.pbook.entity.Member;
import com.pbrk.pbook.entity.SingleLineView;

@Service
public class MainServiceImp implements MainService{

	@Autowired
	private MainDao mainDao;

	@Override
	public List<BookView> getAdminBookViewListMaxLine(int maxLine) {
		
		List<BookView> list = mainDao.getAdminBookViewListMaxLine(maxLine);
		
		return list;
	}
	
	@Override
	public List<SingleLineView> getSingleLineViewListMaxLine(int maxLine) {

		List<SingleLineView> list = mainDao.getSingleLineViewListMaxLine(maxLine);
		
		return list;
	}
	
	@Override
	public List<SingleLineView> getSingleLineViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<SingleLineView> list = mainDao.getSingleLineViewList(offset, size, field, query);
		
		return list;
	}
		
	@Override
	public int getLoginConfirm(Member member) {

		return mainDao.getLoginConfirm(member);
	}
}
