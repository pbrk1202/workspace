package com.pbrk.pbook.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbrk.pbook.dao.web.SingleLineDao;
import com.pbrk.pbook.entity.CodeView;
import com.pbrk.pbook.entity.GroupCodeView;
import com.pbrk.pbook.entity.SingleLine;
import com.pbrk.pbook.entity.SingleLineView;

@Service	
public class SingleLineServiceImp implements SingleLineService {

	@Autowired
	private SingleLineDao singleLineDao;
	
	@Override
	public List<GroupCodeView> getGroupCodeViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<GroupCodeView> list = singleLineDao.getGroupCodeViewList(offset, size, field, query);
		
		return list;
	}
	
	@Override
	public List<CodeView> getCodeViewList(int groupCd) {

		List<CodeView> list = singleLineDao.getCodeViewList(groupCd);
		
		return list;
	}
	
	@Override
	public List<CodeView> getCodeViewList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<CodeView> list = singleLineDao.getCodeViewList(offset, size, field, query);
		
		return list;
	}
	
	@Override
	public List<SingleLineView> getSingleLineViewList(int page, String field, String query, int codeCd) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
				
		List<SingleLineView> list = singleLineDao.getSingleLineViewList(offset, size, field, query, codeCd);
		
		return list;
	}
	
	@Override
	public int getSingleLineCount(String field, String query, int codeCd) {
		
		return singleLineDao.getSingleLineCount(field, query, codeCd);
	}
	
	@Override
	public SingleLineView getSingleLineViewDetail(int no) {
		
		SingleLineView singleLineView = singleLineDao.getSingleLineViewDetail(no);
		
		return singleLineView;
	}
	

	@Override
	public int getSingleLineUpdate(SingleLine singleLine) {
		// TODO Auto-generated method stub
		return singleLineDao.getSingleLineUpdate(singleLine);
	}
	
	@Override
	public int getSingleLineInsert(SingleLine singleLine) {
		// TODO Auto-generated method stub
		return singleLineDao.getSingleLineInsert(singleLine);
	}

	@Override
	public int getMemberNo(String memberId) {
	
		return singleLineDao.getMemberNo(memberId);
	}
	
	
}
